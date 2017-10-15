package com.example.byron.crop_screen;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout mRootView;

    private boolean isRemove = false;
    private Bitmap mRootViewBackGround;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRootView = (LinearLayout)findViewById(R.id.rootView);
        mRootView.setOnClickListener(this);
    }
    private void createViewBackGround(View v){
        v.setDrawingCacheEnabled(true);
        v.buildDrawingCache();
        Bitmap drawingCache = v.getDrawingCache(true); // 获取view背景的一种方法，获取view转换为背景，非联动，如果view内的view发生改变则背景也不会变

//        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);// 获取view背景的第二种方法，这个是联动 获取view转换为背景，如果view内的view发生改变则背景也会发生改变
//       Canvas canvas = new Canvas();
//        canvas.setBitmap(bitmap);
//        v.draw(canvas);
      mRootViewBackGround = drawingCache;
//
//        v.findViewById(R.id.iv_one).setVisibility(View.GONE);
//        v.findViewById(R.id.iv_two).setVisibility(View.GONE);
//        v.findViewById(R.id.iv_three).setVisibility(View.GONE);
    }
    private void removeAllChild(){
        mRootView.removeAllViews();
    }

    @Override
    public void onClick(View v) {
        createViewBackGround(mRootView);
        removeAllChild();
        if(!isRemove){
            Toast.makeText(this,"清空所有布局，并保存页面对象Bitmap",Toast.LENGTH_LONG).show();

            isRemove = true;
            return;
        }
        Toast.makeText(this,"把页面对象Bitmap设置为背景",Toast.LENGTH_LONG).show();
//        LinearLayout viewById = (LinearLayout)mRootView.findViewById(R.id.bottom);
//        viewById.setMinimumHeight(mRootViewBackGround.getHeight());
//        viewById.setMinimumWidth(mRootViewBackGround.getWidth());
//        viewById.setGravity(Gravity.BOTTOM);
        mRootView.setBackground(new BitmapDrawable(mRootViewBackGround));


    }
}
