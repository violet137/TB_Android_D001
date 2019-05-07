package vn.edu.httpgreenacademy.vuivc;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import vn.edu.httpgreenacademy.vuivc.Fragment.Comment.Comment_Dialog_Fragmment;
import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentUserMain;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();
    ImageView imageViewComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_testing_layout);
        imageViewComment = findViewById(R.id.imageViewComment);

        imageViewComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Comment_Dialog_Fragmment comment_dialog_fragmment = new Comment_Dialog_Fragmment();
                comment_dialog_fragmment.show(fragmentManager,"");
                imageViewComment.setVisibility(View.INVISIBLE);
            }
        });
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //FragmentUserMain fragmentUserMain = new FragmentUserMain();
        //fragmentManager.beginTransaction().replace(android.R.id.content, fragmentUserMain).commit();
//        VerticalVideoFragment videoPagerFragment = new VerticalVideoFragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(android.R.id.content,videoPagerFragment).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for(Fragment fragment:getSupportFragmentManager().getFragments())
        {
            fragment.onActivityResult(requestCode,resultCode,data);
        }
    }



}
