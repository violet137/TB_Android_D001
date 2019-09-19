package vn.edu.httpgreenacademy.vuivc.UI.Login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import vn.edu.httpgreenacademy.vuivc.Fragment.Home.HomeFragment;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.Utils.Interface.Login_Status;

public class FragmentLogin extends Fragment implements  Login_Status{
    TextView Txt_Error;
    LoginButton btnloginfacebook;
    CallbackManager callbackManager;
    int KIEM_TRA_DANG_NHAP;
    String email_user;
    String name_user;
    String link_user;
    String fb_id_user;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        btnloginfacebook = (LoginButton)view.findViewById(R.id.btn_login_facebook);
        btnloginfacebook.setReadPermissions("email", "public_profile");
        btnloginfacebook.setFragment(this);

        callbackManager = CallbackManager.Factory.create(); // xử lý các phản hồi đăng nhập

        final AccessToken checkAccessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = checkAccessToken != null && !checkAccessToken.isExpired();
        if(!isLoggedIn)
        {
            btnloginfacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {

                    AccessToken accessToken = loginResult.getAccessToken();
                    String token = accessToken.getToken();

                    if(!token.isEmpty())
                    {
                        GraphRequest request = GraphRequest.newMeRequest(
                                loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {

                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {
                                        Log.v("Main", response.toString());
                                        setProfileToView(object);
                                    }
                                });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id,name,email,gender, birthday");
                        request.setParameters(parameters);
                        request.executeAsync();
                    }

                }


                @Override
                public void onCancel() {
                    Toast.makeText(getContext(), "Cancel", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onError(FacebookException error) {
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
                }
            });
        }
        else
        {
            // Redirect to home fragment
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new HomeFragment())
                    .commit();

        }
        //LoginManager.getInstance().logOut();

        return view;
    }

    private void setProfileToView(JSONObject jsonObject) {
        try {

            if (jsonObject.has("picture")) {
                link_user = jsonObject.getJSONObject("picture").getJSONObject("data").getString("url");
            }

            SharedPreferences sharedPreferences = getContext().getSharedPreferences(getString(R.string.fb_sharePre_Name),Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("fb_sharePre_login_status","" + true);
            editor.putString("fb_sharePre_login_id",jsonObject.getString("id"));
            editor.putString("fb_sharePre_login_name",jsonObject.getString("name"));
            editor.putString("fb_sharePre_login_email",jsonObject.getString("email"));
            editor.putString("fb_sharePre_login_imgURL",link_user);
            editor.commit();

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new HomeFragment())
                    .commit();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void LoginStatus(Boolean isThanhCong) {
        if(isThanhCong)
        {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new HomeFragment())
                    .commit();
        }
    }


}
