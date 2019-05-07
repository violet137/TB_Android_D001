package vn.edu.httpgreenacademy.vuivc.Draw;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import vn.edu.httpgreenacademy.vuivc.R;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static com.facebook.FacebookSdk.getApplicationContext;

public class FragmentEditPick extends Fragment implements View.OnClickListener {
    ImageView imganhche, imgbackedit, imgok;
    Button btloadanh, btcamera, bttren, btgiua, btduoi;
    EditText edThongtinche;
    TextView txtChoLoadAnh;
    final int RQS_IMAGE1 = 1;
    int code = 0;
    Bitmap bitmapOriginal;
    int anh;
    Uri source1;
    Bitmap bp;


    private final String fileName = "anh.PNG";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenteditanh, container, false);

        imganhche = view.findViewById(R.id.imganhche);
        imgbackedit = view.findViewById(R.id.imgbackedit);
        imgok = view.findViewById(R.id.imgOK);
        btcamera = view.findViewById(R.id.btCamera);
        bttren = view.findViewById(R.id.btTren);
        btgiua = view.findViewById(R.id.btGiua);
        btduoi = view.findViewById(R.id.btDuoi);
        btloadanh = view.findViewById(R.id.btLoadImg);
        edThongtinche = view.findViewById(R.id.edThongTinChe);
        txtChoLoadAnh = view.findViewById(R.id.txtChoLoadAnh);
        btloadanh.setOnClickListener(this);
        bttren.setOnClickListener(this);
        btgiua.setOnClickListener(this);
        btduoi.setOnClickListener(this);
        btcamera.setOnClickListener(this);
        imgbackedit.setOnClickListener(this);
        imgok.setOnClickListener(this);

        checkAndRequestPermissions();
        Bundle bundle = getArguments();
        if (bundle != null) {
            anh = bundle.getInt("hinhanh");
        }
        bitmapOriginal = BitmapFactory.decodeResource(getResources(), anh);
        if (code == 0) {
            imganhche.setImageBitmap(bitmapOriginal);
        }

        return view;
    }


    private void captureimage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 100);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgOK:
                saveData();
                break;
            case R.id.btCamera:
                askPermissionAndCaptureVideo();
                code = 2;
                break;
            case R.id.btTren:
                if (anh != 0) {
                    ReloadImage2();
                }

                if (source1 != null) {
                    Bitmap processedBitmap = chenanhtren();
                    if (processedBitmap != null) {
                        imganhche.setImageBitmap(processedBitmap);
                        Toast.makeText(getContext().getApplicationContext(),
                                "Done",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext().getApplicationContext(),
                                "Something wrong in processing!",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext().getApplicationContext(),
                            "Select both image!",
                            Toast.LENGTH_LONG).show();
                }

                if (bp != null) {
                    camera2();
                }
                break;
            case R.id.btLoadImg:
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RQS_IMAGE1);
                break;
            case R.id.imgbackedit:
                getActivity().onBackPressed();
                break;
            case R.id.btGiua:
                if (anh != 0) {
                    ReloadImage3();
                }
                if (source1 != null) {
                    Bitmap processedBitmap = chenanhgiua();
                    if (processedBitmap != null) {
                        imganhche.setImageBitmap(processedBitmap);
                        Toast.makeText(getContext().getApplicationContext(),
                                "Done",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext().getApplicationContext(),
                                "Something wrong in processing!",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext().getApplicationContext(),
                            "Select both image!",
                            Toast.LENGTH_LONG).show();
                }
                if (bp != null) {
                    camera3();
                }
                break;
            case R.id.btDuoi:
                if (anh != 0) {
                    ReloadImage1();
                }
                if (source1 != null) {
                    Bitmap processedBitmap = chenanhduoi();
                    if (processedBitmap != null) {
                        imganhche.setImageBitmap(processedBitmap);
                        Toast.makeText(getContext().getApplicationContext(),
                                "Done",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext().getApplicationContext(),
                                "Something wrong in processing!",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext().getApplicationContext(),
                            "Select both image!",
                            Toast.LENGTH_LONG).show();
                }
                if (bp != null) {
                    camera1();
                }
                break;

        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RQS_IMAGE1:
                    source1 = data.getData();
                    txtChoLoadAnh.setText(source1.toString());
                    break;
            }
        }

        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                bp = (Bitmap) data.getExtras().get("data");
                this.imganhche.setImageBitmap(bp);


            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getContext(), "Action canceled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Action Failed", Toast.LENGTH_SHORT).show();
            }
        }

    }


    private Bitmap chenanhtren() {
        Bitmap bm1 = null;
        Bitmap newBitmap = null;

        try {
            bm1 = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(source1));

            Bitmap.Config config = bm1.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }

            newBitmap = Bitmap.createBitmap(bm1.getWidth(), bm1.getHeight(), config);
            Canvas newCanvas = new Canvas(newBitmap);

            newCanvas.drawBitmap(bm1, 0, 0, null);
            String captionString = edThongtinche.getText().toString();
            if (captionString != null) {

                Paint paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
                paintText.setColor(Color.WHITE);
                paintText.setTextSize(50);
                paintText.setStyle(Paint.Style.FILL);
                paintText.setShadowLayer(10f, 10f, 10f, Color.BLACK);


                Rect rectText = new Rect();
                paintText.getTextBounds(captionString, 0, captionString.length(), rectText);

                newCanvas.drawText(captionString,
                        0, rectText.height(), paintText);

                Toast.makeText(getContext().getApplicationContext(),
                        "drawText: " + captionString,
                        Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(getContext().getApplicationContext(),
                        "caption empty!",
                        Toast.LENGTH_LONG).show();
            }
            newCanvas.save();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return newBitmap;
    }

    private Bitmap chenanhgiua() {
        Bitmap bm1 = null;
        Bitmap newBitmap = null;

        try {
            bm1 = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(source1));

            Bitmap.Config config = bm1.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }

            newBitmap = Bitmap.createBitmap(bm1.getWidth(), bm1.getHeight(), config);
            Canvas newCanvas = new Canvas(newBitmap);

            newCanvas.drawBitmap(bm1, 0, 0, null);
            newCanvas.translate(0, 600);
            String captionString = edThongtinche.getText().toString();
            if (captionString != null) {

                Paint paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
                paintText.setColor(Color.WHITE);
                paintText.setTextSize(50);
                paintText.setStyle(Paint.Style.FILL);
                paintText.setShadowLayer(10f, 10f, 10f, Color.BLACK);


                Rect rectText = new Rect();
                paintText.getTextBounds(captionString, 0, captionString.length(), rectText);

                newCanvas.drawText(captionString,
                        0, rectText.height(), paintText);

                Toast.makeText(getContext().getApplicationContext(),
                        "drawText: " + captionString,
                        Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(getContext().getApplicationContext(),
                        "caption empty!",
                        Toast.LENGTH_LONG).show();
            }
            newCanvas.save();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return newBitmap;
    }

    private Bitmap chenanhduoi() {
        Bitmap bm1 = null;
        Bitmap newBitmap = null;

        try {
            bm1 = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(source1));

            Bitmap.Config config = bm1.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }

            newBitmap = Bitmap.createBitmap(bm1.getWidth(), bm1.getHeight(), config);
            Canvas newCanvas = new Canvas(newBitmap);

            newCanvas.drawBitmap(bm1, 0, 0, null);
            newCanvas.translate(0, 1230);
            String captionString = edThongtinche.getText().toString();
            if (captionString != null) {

                Paint paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
                paintText.setColor(Color.WHITE);
                paintText.setTextSize(50);
                paintText.setStyle(Paint.Style.FILL);
                paintText.setShadowLayer(10f, 10f, 10f, Color.BLACK);


                Rect rectText = new Rect();
                paintText.getTextBounds(captionString, 0, captionString.length(), rectText);

                newCanvas.drawText(captionString,
                        0, rectText.height(), paintText);

                Toast.makeText(getContext().getApplicationContext(),
                        "drawText: " + captionString,
                        Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(getContext().getApplicationContext(),
                        "caption empty!",
                        Toast.LENGTH_LONG).show();
            }
            newCanvas.save();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return newBitmap;
    }

    private void camera1() {

        String textToDraw = edThongtinche.getText().toString();

        Bitmap newBitmap = bp.copy(bp.getConfig(), true);

        Canvas newCanvas = new Canvas(newBitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setTextSize(20);
        paint.setStyle(Paint.Style.FILL);
        paint.setShadowLayer(10f, 10f, 10f, Color.BLACK);

        Rect bounds = new Rect();
        paint.getTextBounds(textToDraw, 0, textToDraw.length(), bounds);
        int x = 0;
        int y = newBitmap.getHeight();

        newCanvas.drawText(textToDraw, x, y, paint);

        imganhche.setImageBitmap(newBitmap);


    }

    private void camera2() {

        String textToDraw = edThongtinche.getText().toString();

        Bitmap newBitmap = bp.copy(bp.getConfig(), true);
        ;

        Canvas newCanvas = new Canvas(newBitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setTextSize(20);
        paint.setStyle(Paint.Style.FILL);
        paint.setShadowLayer(10f, 10f, 10f, Color.BLACK);

        Rect bounds = new Rect();
        paint.getTextBounds(textToDraw, 0, textToDraw.length(), bounds);
        newCanvas.drawText(textToDraw, 0, 15, paint);
        newCanvas.translate(0, 0);


        imganhche.setImageBitmap(newBitmap);


    }

    private void camera3() {

        String textToDraw = edThongtinche.getText().toString();

        Bitmap newBitmap = bp.copy(bp.getConfig(), true);
        ;

        Canvas newCanvas = new Canvas(newBitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setTextSize(20);
        paint.setStyle(Paint.Style.FILL);
        paint.setShadowLayer(10f, 10f, 10f, Color.BLACK);
        int y = bp.getHeight();
        Rect bounds = new Rect();
        paint.getTextBounds(textToDraw, 0, textToDraw.length(), bounds);
        newCanvas.drawText(textToDraw, 0, y / 2, paint);
        newCanvas.translate(0, 0);


        imganhche.setImageBitmap(newBitmap);


    }


    private void ReloadImage1() {

        String textToDraw = edThongtinche.getText().toString();

        Bitmap newBitmap = bitmapOriginal.copy(bitmapOriginal.getConfig(), true);

        Canvas newCanvas = new Canvas(newBitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        paint.setStyle(Paint.Style.FILL);
        paint.setShadowLayer(10f, 10f, 10f, Color.BLACK);

        Rect bounds = new Rect();
        paint.getTextBounds(textToDraw, 0, textToDraw.length(), bounds);
        int x = 0;
        int y = newBitmap.getHeight();

        newCanvas.drawText(textToDraw, x, y, paint);

        imganhche.setImageBitmap(newBitmap);


    }

    private void ReloadImage2() {

        String textToDraw = edThongtinche.getText().toString();

        Bitmap newBitmap = bitmapOriginal.copy(bitmapOriginal.getConfig(), true);

        Canvas newCanvas = new Canvas(newBitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        paint.setStyle(Paint.Style.FILL);
        paint.setShadowLayer(10f, 10f, 10f, Color.BLACK);

        Rect bounds = new Rect();
        paint.getTextBounds(textToDraw, 0, textToDraw.length(), bounds);
        newCanvas.drawText(textToDraw, 0, 45, paint);
        newCanvas.translate(0, 0);


        imganhche.setImageBitmap(newBitmap);


    }

    private void ReloadImage3() {

        String textToDraw = edThongtinche.getText().toString();

        Bitmap newBitmap = bitmapOriginal.copy(bitmapOriginal.getConfig(), true);

        Canvas newCanvas = new Canvas(newBitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        paint.setStyle(Paint.Style.FILL);
        paint.setShadowLayer(10f, 10f, 10f, Color.BLACK);
        int y = bitmapOriginal.getHeight() / 2;
        Rect bounds = new Rect();
        paint.getTextBounds(textToDraw, 0, textToDraw.length(), bounds);
        newCanvas.drawText(textToDraw, 0, y, paint);
        newCanvas.translate(0, 0);

        imganhche.setImageBitmap(newBitmap);


    }

    private void askPermissionAndCaptureVideo() {
        if (Build.VERSION.SDK_INT >= 23) {
            int readPermission = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
            int writePermission = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED) {
                this.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 102);
                return;
            }
        }
        this.captureimage();
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
    public void saveData(){
        if (isExternalStorageReadable())
        {
            String content = imganhche.toString();
            File file;
            FileOutputStream outputStream;
            try {
                file = new File(Environment.getExternalStorageDirectory(), "vuivc.PNG");
                Log.d("Vuivc", Environment.getExternalStorageDirectory().getAbsolutePath());
                outputStream = new FileOutputStream(file);
                outputStream.write(content.getBytes());
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Toast.makeText(getContext(),"Can not save file",Toast.LENGTH_SHORT).show();
        }


}

    private void checkAndRequestPermissions() {
        String[] permissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(getContext(), permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(getActivity(), listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
        }
    }




}
