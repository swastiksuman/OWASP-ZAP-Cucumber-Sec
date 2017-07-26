package com.vdsi.zaps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;

public class SimpleExample {

    private static final String ZAP_ADDRESS = "127.0.0.1";
    private static final int ZAP_PORT = 8095;
    private static final String ZAP_API_KEY = null; // Change this if you have set the apikey in ZAP via Options / API

    private static final String TARGET = "http://demo.testfire.net/bank/login.aspx";

    public static void main() {
        ClientApi api = new ClientApi(ZAP_ADDRESS, ZAP_PORT);

        try {
        	
            System.out.println("Spider : " + TARGET);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(api.core.htmlreport());
            FileOutputStream out = new FileOutputStream("filename.html");
            int DEFAULT_BUFFER_SIZE = 1024;
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            long count = 0;
            int n = 0;

            n = byteArrayInputStream.read(buffer, 0, DEFAULT_BUFFER_SIZE);

            while (n >= 0) {
            	out.write(buffer, 0, n);
               n = byteArrayInputStream.read(buffer, 0, DEFAULT_BUFFER_SIZE);
            }
            out.flush();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
