package com.customdrawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
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
    private ImageView clipview;

    int level;
    private Handler mHandler = new Handler();
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

        final ClipDrawable clipDrawable= (ClipDrawable) clipview.getDrawable();

        level=clipDrawable.getLevel();

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                clipDrawable.setLevel(level);
                level+=200;

                if (level<=10000){
                    mHandler.postDelayed(this,100);
                }
            }
        },100);


    }

    private void initView() {
        relRoot = (LinearLayout) findViewById(R.id.rel_root);
        roundimage = (ImageView) findViewById(R.id.roundimage);
        circleimage = (ImageView) findViewById(R.id.circleimage);
        shaderview = (BitmapShaderView) findViewById(R.id.shaderview);
        clipview = (ImageView) findViewById(R.id.clipview);
    }
}
