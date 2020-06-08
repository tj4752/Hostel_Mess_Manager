package com.example.mymess31;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

public class QR_code extends AppCompatActivity {
//declare java objects for xml widgets
    Button btn_generate;
    EditText et_email;
    ImageView iv_qrcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        //type cast convert xml widges into java objects
        iv_qrcode=findViewById(R.id.iv_qrcode);
                //to click on the button
                        //convert the edit text input into string objects
                        String email=getIntent().getExtras().getString("Email");
                        WindowManager windowManager=(WindowManager)getSystemService(WINDOW_SERVICE);
                        Display display=windowManager.getDefaultDisplay();
                        Point point=new Point();
                        display.getSize(point);
                        int x=point.x;
                        int y=point.y;
                        int icon=x<y?x:y;
                        icon=icon *3/4;
                        //now we have to use the library
                        QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(email,null, Contents.Type.TEXT, BarcodeFormat.QR_CODE.toString(), icon);
                        try{
                            Bitmap bitmap=qrCodeEncoder.encodeAsBitmap();
                            iv_qrcode.setImageBitmap(bitmap);

                        }catch(WriterException e){
                            e.printStackTrace();
                        }
    }
}
