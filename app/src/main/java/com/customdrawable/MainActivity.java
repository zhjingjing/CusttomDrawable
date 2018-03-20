package com.customdrawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.customdrawable.view.BitmapShaderView;
import com.customdrawable.view.CircleDrawable;
import com.customdrawable.view.RoundImageDrawable;

public class MainActivity extends AppCompatActivity {

    private LinearLayout relRoot;
    private ImageView roundimage;
    private ImageView circleimage;
    private BitmapShaderView shaderview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.image);
        //圆角
        roundimage.setImageDrawable(new RoundImageDrawable(bitmap, 100));
        //圆形
        circleimage.setImageDrawable(new CircleDrawable(bitmap));

    }

    private void initView() {
        relRoot = (LinearLayout) findViewById(R.id.rel_root);
        roundimage = (ImageView) findViewById(R.id.roundimage);
        circleimage = (ImageView) findViewById(R.id.circleimage);
        shaderview = (BitmapShaderView) findViewById(R.id.shaderview);
    }
}
