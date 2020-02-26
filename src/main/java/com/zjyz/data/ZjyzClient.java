package com.zjyz.data;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class ZjyzClient {

    private  String orgCode;
    private  String sign;
    private  String url;

    /**
     * 构建权限验证参数
     * @param orgCode
     * @param sign
     */
    public  ZjyzClient(String orgCode,String sign,String url){
        this.orgCode = orgCode;
        this.sign = sign;
        this.url = url;
    }

    private static final Log logger = LogFactory.get();

    public FileRespMode fileUpload(String localFile) {

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        FileRespMode mode = null;
        try {
            httpClient = HttpClients.createDefault();
            // 把一个普通参数和文件上传给下面这个地址是一个servlet
            HttpPost httpPost = new HttpPost(url);

            // 把文件转换成流对象FileBody
            FileBody bin = new FileBody(new File(localFile));


            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    // 相当于<input type="file" name="file"/>
                    .addPart("file", bin)
                    .build();

            httpPost.setEntity(reqEntity);
            httpPost.setHeader("orgCode",orgCode);
            httpPost.setHeader("sign",sign);

            // 发起请求 并返回请求的响应
            response = httpClient.execute(httpPost);
            if(response.getStatusLine().getStatusCode() == 200) {
                // 获取响应对象
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    // 打印响应内容
                     mode = JSON.parseObject(EntityUtils.toString(resEntity, Charset.forName("UTF-8")),FileRespMode.class);
                }

                // 销毁
                EntityUtils.consume(resEntity);
            }else {
                logger.error("访问异常");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(response != null){
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(httpClient != null){
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mode;
    }


    public DataRespModel putObject(String dataJson) {

        return null;
    }
}
