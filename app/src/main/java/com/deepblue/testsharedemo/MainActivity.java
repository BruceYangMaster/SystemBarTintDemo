package com.deepblue.testsharedemo;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 全屏（必须在setContentView之前调用）
         * requestFeature() must be called before adding content
         */
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        /**
         * 加载布局
         */
        setContentView(R.layout.activity_main);
        /**
         * 隐藏titlebar(必须是有titlebar的主题)
         */
//        getSupportActionBar().hide();
        initWidget();
    }

    private void initWidget() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
// create our manager instance after the content view is set
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        // enable status bar tint
        tintManager.setStatusBarTintEnabled(true);
        // enable navigation bar tint
        /**
         * 设置底部的颜色是否改变
         */
        tintManager.setNavigationBarTintEnabled(true);
        //
        // set a custom tint color for all system bars
        tintManager.setTintColor(Color.GREEN);
/**
 *   set a custom navigation bar resource
 */

//        tintManager.setNavigationBarTintResource(R.mipmap.ic_launcher);
/**
 * set a custom status bar drawable
 */
//        tintManager.setNavigationBarTintDrawable(Drawable);

    }
}
