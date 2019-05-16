package vn.edu.httpgreenacademy.vuivc.Network;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import vn.edu.httpgreenacademy.vuivc.Utils.Interface.Login_Status;

public class Login_ASyctask extends AsyncTask<String,Void, Boolean> {
    Login_Status login_status;

    public Login_ASyctask(Login_Status login_status) {
        this.login_status = login_status;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
 
        String Username = strings[0];
        String password = strings[1];
        try{
            URL url = new URL("http://13.229.117.90:8012/Auth/Login");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");

            JSONObject jsonObject =new JSONObject();
            jsonObject.put("Username", Username);
            jsonObject.put("Pwd", password);
            jsonObject.put("Token", "");
            jsonObject.put("AccountType", "Thuong");

            OutputStream outputStream =  httpURLConnection.getOutputStream();
            outputStream.write(jsonObject.toString().getBytes());

            httpURLConnection.connect();

            if(httpURLConnection.getResponseCode() == httpURLConnection.HTTP_OK)
            {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String tam = "";
                while ((tam =bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(tam);
                }
                inputStream.close();

                Log.d("Json",""+stringBuilder.toString());

                JSONObject severjson = new JSONObject(stringBuilder.toString());
                int status =  severjson.getInt("Status");
                if(status == 1)
                {
                    return true;
                }
                return false;

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
        }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        login_status.LoginStatus(aBoolean);
    }
}
