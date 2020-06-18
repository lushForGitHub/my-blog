package com.ls.springcloud.base;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @ClassName HttpHelper
 * @Description
 * @Author lushuai
 * @Date 2019/11/14 14:58
 */
public class HttpHelper {

    public static String getRequestBody(HttpServletRequest request){
        StringBuilder sbf = new StringBuilder();
        ServletInputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            char[] bytes = new char[1024];
            int length;
            while( (length = reader.read(bytes)) != -1){
                sbf.append(new String(bytes, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }
}
