package vn.edu.httpgreenacademy.vuivc.http_httpsRequest;

import android.content.Context;

import java.util.Map;

public class Vollyput {
    private Context activity;
    private AsyncTaskCompleteListener asyncTaskCompleteListener;
    private Map<String, String> map;
    String Url;
    String headers;
    int servicecode;
    public Vollyput(String url, final String header, final int servicecode, final AsyncTaskCompleteListener asyncTaskCompleteListener){
        Url = url;
        this.headers = header;
        this.servicecode = servicecode;
        this.asyncTaskCompleteListener = asyncTaskCompleteListener;

    }
}
