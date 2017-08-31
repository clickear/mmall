package com.mmall.util;

import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;
import de.sstoehr.harreader.model.*;
import okhttp3.*;
import okio.BufferedSink;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/27.
 */
public class HarUtil {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private  static OkHttpClient client = new OkHttpClient();
    private static HarReader harReader = new HarReader();
    public static Har getHarObject(String harStr) throws HarReaderException {
        Har har = harReader.readFromString(harStr);
        return har;
    }

    public static String request(String harStr) throws IOException {
        Har har = null;
        try {
            har = getHarObject(harStr);
        } catch (HarReaderException e) {
            e.printStackTrace();
        }

        Request.Builder builder = new Request.Builder();
        for (HarEntry harEntry:har.getLog().getEntries()) {
            HarRequest request = harEntry.getRequest();
            HttpMethod method = request.getMethod();

            for(HarHeader header :request.getHeaders()){
                if(header.getName() == "Accept-Encoding"){
                    continue;
                }
                builder.addHeader(header.getName(), header.getValue());
            }

            builder.url(request.getUrl());
            if(method == HttpMethod.GET){
                builder.get();
            }else if(method == HttpMethod.POST){
                // RequestBody body = new RequestBody().
                if(request.getPostData() !=null && request.getPostData().getText() != null){
                    RequestBody body = RequestBody.create(MediaType.parse(request.getPostData().getMimeType()), request.getPostData().getText());
                    builder.post(body);
                }else{
                    builder.post(RequestBody.create(JSON,""));
                }
            }
            Request requestBuild  =  builder.build();
            Response response = client.newCall(requestBuild).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        Har har = null;
        try {
            har = HarUtil.getHarObject("");
        } catch (HarReaderException e) {
            e.printStackTrace();
        }




    }

}
