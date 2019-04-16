package vn.edu.httpgreenacademy.vuivc.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import vn.edu.httpgreenacademy.vuivc.Interface.TakeImage;
import vn.edu.httpgreenacademy.vuivc.R;

import static android.app.Activity.RESULT_OK;

public class DialogChangeImage extends DialogFragment {
    Button btn_CameraShot,btn_takefromphone;
    TakeImage takeImage;
    Bitmap bitmap;
    public void TakeImage(TakeImage takeImage){
        this.takeImage = takeImage;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater =getActivity().getLayoutInflater();
        View view =layoutInflater.inflate(R.layout.dialog_doianh,null);
        builder.setView(view).setTitle("Option");
        btn_CameraShot = view.findViewById(R.id.btn_CameraShot);
        btn_takefromphone = view.findViewById(R.id.btn_takefromphone);
        btn_CameraShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captureImage();
                dismiss();
            }
        });
        btn_takefromphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosePicture();
                dismiss();
            }
        });

        return builder.create();
    }

    private void choosePicture() {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        getActivity().startActivityForResult(pickPhoto , 200);//one can be replaced with any action code
    }

    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        getActivity().startActivityForResult(intent,100);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 100)
        {
            if(resultCode == RESULT_OK)
            {
                bitmap = (Bitmap) data.getExtras().get("data");
                takeImage.imagefromCamera(bitmap);


            }
        }
        else if(requestCode ==200)
        {
            if(resultCode==RESULT_OK)
                try {
                    Uri imageUri = data.getData();
                    bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
                    takeImage.imagefromCamera(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
