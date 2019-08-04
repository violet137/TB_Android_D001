package vn.edu.httpgreenacademy.vuivc.http_httpsRequest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


public class Vollyheaders {
    private Context activity;
    private AsyncTaskCompleteListener asyncTaskCompleteListener;
    String Url;
    String headers;
    int servicecode;
    String token;
    JSONObject postparams;

    public Vollyheaders(final Activity activity, String url, JSONObject postparams, final int servicecode, final AsyncTaskCompleteListener asyncTaskCompleteListener) {
        this.postparams = postparams;
        this.servicecode = servicecode;
        this.asyncTaskCompleteListener = asyncTaskCompleteListener;
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, postparams,
                new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {
                        if (response != null) {
                            asyncTaskCompleteListener.onTaskCompleted(response.toString(), servicecode);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        NetworkResponse response = error.networkResponse;
                        if (!response.toString().isEmpty()) {
                            try {
                                String body = new String(error.networkResponse.data, "UTF-8");
                                Log.d("ccccc", "onErrorResponse: " + body);
                                if (response.statusCode == 403) {
                                    activity.finish();
                                } else {
                                    asyncTaskCompleteListener.onTaskCompleted(body, servicecode);
                                }
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }else {
                        }
                    }
                }) {
            /** Passing some request headers* */
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Authorization", token);

                return headers;
            }
        };
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }
}
