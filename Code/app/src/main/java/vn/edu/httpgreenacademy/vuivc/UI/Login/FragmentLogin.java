package vn.edu.httpgreenacademy.vuivc.UI.Login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import vn.edu.httpgreenacademy.vuivc.Fragment.Home.HomeFragment;
import vn.edu.httpgreenacademy.vuivc.Utils.Interface.Login_Status;
import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentLogin extends Fragment implements  Login_Status {
    TextView Txt_Error;

    LoginButton btnloginfacebook;
    CallbackManager callbackManager;
    int KIEM_TRA_DANG_NHAP;
    String email_user;
    String name_user;
    String link_user;


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
                    Toast.makeText(getContext(), "Dang nhap thanh cong", Toast.LENGTH_LONG).show();
                    AccessToken accessToken = loginResult.getAccessToken();
                    String token = accessToken.getToken();
                    Toast.makeText(getContext(), token, Toast.LENGTH_LONG).show();
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
            Profile profile = Profile.getCurrentProfile();
            if (profile != null) {
                Log.d("my info", "Logged, user name=" + profile.getFirstName() + " " + profile.getLastName());
                HomeFragment fragmentHome = new HomeFragment();
                Bundle args = new Bundle();
                args.putString("fb_email_user", profile.getFirstName() + " " + profile.getLastName());
                args.putString("fb_name_user", profile.getFirstName() + " " + profile.getLastName());
                args.putString("fb_link_user", profile.getFirstName() + " " + profile.getLastName());
                fragmentHome.setArguments(args);

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(android.R.id.content, fragmentHome)
                        .commit();
            }
        }
        //LoginManager.getInstance().logOut();

        return view;
    }

    private void setProfileToView(JSONObject jsonObject) {
        try {
            //gender.setText(jsonObject.getString("gender"));
            //jsonObject.getString("id")
            email_user = jsonObject.getString("email");
            name_user = jsonObject.getString("name");
            if (jsonObject.has("picture")) {
                link_user = jsonObject.getJSONObject("picture").getJSONObject("data").getString("url");
            }
            Log.d("fb profile",email_user + " - " + name_user + " - " + link_user);


            HomeFragment fragmentHome = new HomeFragment();
            Bundle args = new Bundle();
            args.putString("fb_email_user", email_user);
            args.putString("fb_name_user", name_user);
            args.putString("fb_link_user", link_user);
            fragmentHome.setArguments(args);

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, fragmentHome)
                    .commit();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void LoginStatus(Boolean isThanhCong) {
        if(isThanhCong)
        {
            HomeFragment fragmentHome = new HomeFragment();
            Bundle args = new Bundle();
            args.putString("fb_email_user", email_user);
            args.putString("fb_name_user", name_user);
            args.putString("fb_link_user", link_user);
            fragmentHome.setArguments(args);

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, fragmentHome)
                    .commit();
        }
    }
}
