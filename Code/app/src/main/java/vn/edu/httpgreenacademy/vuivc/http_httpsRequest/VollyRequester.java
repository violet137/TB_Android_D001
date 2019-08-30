package vn.edu.httpgreenacademy.vuivc.http_httpsRequest;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.http_httpsRequest.AppController;
import vn.edu.httpgreenacademy.vuivc.http_httpsRequest.AsyncTaskCompleteListener;
import vn.edu.httpgreenacademy.vuivc.http_httpsRequest.Commonutils;


/**
 * Created by Amal on 28-06-2015.
 */
public class VollyRequester {

    private Context activity;
    private AsyncTaskCompleteListener asyncTaskCompleteListener;
    private Map<String, String> map;
    int servicecode;

    String URL_Requester = "url";

    // SeekbarTimer seekbar;

    public VollyRequester(Context activity, int method_type, Map<String, String> map, int servicecode, AsyncTaskCompleteListener asyncTaskCompleteListener) {
        int method;
        this.activity = activity;
        this.asyncTaskCompleteListener = asyncTaskCompleteListener;
        this.map = map;
        this.servicecode = servicecode;
        if (method_type == 0) {
            method = Request.Method.GET;
        } else  {
            method = Request.Method.POST;
//        } else{
//            method = Request.Method.PUT;
        }
        String URL = map.get(URL_Requester);
        map.remove(URL_Requester);

        if (method == Request.Method.POST) {
            volley_requester(method, URL, (map == null) ? null : map);
            Log.d("url", "VollyRequesterpost: " + URL);
        } else {
            volley_requester(URL);
            Log.d("url", "VollyRequester: " + URL);
        }

    }


    public void volley_requester(int method, String url, final Map<String, String> requestbody) {
        StringRequest jsonObjRequest = new StringRequest(method,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //seekbar.cancel();
                        if (response != null) {
                            Log.d("mmmmmm", "onResponse: " + response);
                            asyncTaskCompleteListener.onTaskCompleted(response.toString(), servicecode);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ccccc", "onErrorResponse: " + error);
                NetworkResponse response = error.networkResponse;
                if(response !=null) {
                    try {
                        String body = new String(error.networkResponse.data, "UTF-8");
                        Log.d("ccccc", "onErrorResponse: " + body);
                        asyncTaskCompleteListener.onTaskCompleted(body, servicecode);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(activity, "No network", Toast.LENGTH_SHORT).show();
                }


//                response.headers.put("content-type","application/json; charset=utf-8");
                //Log.d("Manh", "onErrorResponse: "+response.headers.get("content-type"));
//                if (error instanceof ServerError && response != null) {
//                    if (error instanceof NoConnectionError) {
//                        Log.d("amal", "volley requester 2" + error.toString());
//                        String msg = activity.getResources().getString(R.string.txt_network_not_available);
//                        Commonutils.showtoast(msg, activity);
//                        Commonutils.progressdialog_hide();
//                    }
//
//                    try {
//
//                       // response.headers.get("content-type ");
//                        String res = new String(response.data,
//                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
//                        Log.d("cccccccc", "onErrorResponse: "+res);
//                        // Now you can use any deserializer to make sense of data
//                        JSONObject obj = new JSONObject(res);
//                        String Error = obj.getString("error");
//                        Log.d("error_code", "onErrorResponse:" + Error);
//                        if (Error.contains("400")) {
//                            Toast.makeText(activity, "lỗi token" + Error, Toast.LENGTH_SHORT).show();
//                        }
//                        asyncTaskCompleteListener.onTaskCompleted(obj.toString(), servicecode);
//                        error.printStackTrace();
//                    } catch (UnsupportedEncodingException e1) {
//                        // Couldn't properly decode data to string
//                        e1.printStackTrace();
//                    } catch (JSONException e2) {
//                        // returned data is not JSONObject?
//                        e2.printStackTrace();
//                    }
//                }
            }
        }) {

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded;charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params = requestbody;
                return params;
            }
        };
        jsonObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                500000,
                5,
                1f));
        Log.d("bbb", "volley_requester: " + jsonObjRequest);
        String tag_string_req = "string_req";
        AppController.getInstance().addToRequestQueue(jsonObjRequest, tag_string_req);
    }

    public void volley_requester(String url) {
        Log.d("url11", "volley_requester: " + url);
        JsonObjectRequest jsongetrequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("SSSSS", "onResponse: " + response);
                if (response != null) {
                    asyncTaskCompleteListener.onTaskCompleted(response.toString(), servicecode);
                }
                //seekbar.cancel();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("amal", "volley requester 2" + error.toString());
                if (error instanceof NoConnectionError) {
                    Log.d("amal", "volley requester 2" + error.toString());
                    String msg = "No network connection. Please check your internet";
                    Commonutils.showtoast(msg, activity);
                    Commonutils.progressdialog_hide();
                }
                NetworkResponse response = error.networkResponse;
                if (!response.toString().isEmpty()) {
                    if (error instanceof ServerError && response != null) {
                        try {
                            String res = new String(response.data,
                                    HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                            // Now you can use any deserializer to make sense of data
                            JSONObject obj = new JSONObject(res);
                            error.printStackTrace();
                        } catch (UnsupportedEncodingException e1) {
                            // Couldn't properly decode data to string
                            e1.printStackTrace();
                        } catch (JSONException e2) {
                            // returned data is not JSONObject?
                            e2.printStackTrace();
                        }
                    }
                }else {
                    Toast.makeText(activity, "No network", Toast.LENGTH_SHORT).show();
                }
            }
        });
        jsongetrequest.setRetryPolicy(new DefaultRetryPolicy(
                500000,
                5,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(jsongetrequest);
    }


    private class SeekbarTimer extends CountDownTimer {

        public SeekbarTimer(long startTime, long interval) {
            super(startTime, interval);


        }

        @Override
        public void onFinish() {
            Toast.makeText(activity, "No network", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onTick(long millisUntilFinished) {


        }
    }

    public void volley_headers(String url, final String token) {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url,
                new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {
                        Log.d("ccccc", "onResponse: " + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Failure Callback
                    }
                }) {
            /** Passing some request headers* */
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                //headers.put("Content-Type", "application/json");
                headers.put("Authorization", token);
                return headers;
            }
        };
    }
}
