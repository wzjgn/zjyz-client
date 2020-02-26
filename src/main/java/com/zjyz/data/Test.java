package com.zjyz.data;

public class Test {

    public static  void  main(String arg []){

        ZjyzClient  client = new  ZjyzClient("1111","2222","http://localhost:18000/api/v1/data/processUpload");

        String file = "/Users/ouburikou/Documents/jetbrains-agent.jar";
        FileRespMode mode =  client.fileUpload(file);

    }
}
