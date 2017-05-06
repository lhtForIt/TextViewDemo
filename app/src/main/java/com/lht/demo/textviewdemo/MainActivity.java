package com.lht.demo.textviewdemo;

import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private TextView tv10;
    private float num = 1.2f;
    private RelativeSizeSpan rss;
    private RelativeSizeSpan res;
    private Timer timer;
    private int key;
    private SpannableString sps1;
    private Handler hd = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x111) {

                sps1.setSpan(rss, key%sps1.length(), key%sps1.length() + 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                sps1.setSpan(res, 0, key%sps1.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                sps1.setSpan(res, key%sps1.length() + 1, sps1.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                key++;
                tv1.setText(sps1);

            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv8 = (TextView) findViewById(R.id.tv8);
        tv9 = (TextView) findViewById(R.id.tv9);
        tv10 = (TextView) findViewById(R.id.tv10);

        SpannableString sps = new SpannableString("我的前景色是紫色");
        ForegroundColorSpan fc = new ForegroundColorSpan(Color.parseColor("#d696f7"));
        BackgroundColorSpan bc = new BackgroundColorSpan(Color.parseColor("#3bc1ff"));
        sps.setSpan(fc, 6, sps.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        sps.setSpan(bc, 6, sps.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv.setText(sps);

        sps1 = new SpannableString("千，里之行始于足下！");
//        for (int i = 0; i < sps1.length(); i++) {
//
//            if (i < sps1.length() / 2) {
//                num += 0.2f;
//            } else {
//                num -= 0.2f;
//            }
//            rss = new RelativeSizeSpan(num);
//            sps1.setSpan(rss, i, i + 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//
//        }
        rss = new RelativeSizeSpan(1.4f);
        res = new RelativeSizeSpan(1.0f);
        ForegroundColorSpan fc1 = new ForegroundColorSpan(Color.parseColor("#d696f7"));
        sps1.setSpan(fc1, 0, sps1.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                hd.sendEmptyMessage(0x111);
            }
        }, 0, 260);


        SpannableString sps2 = new SpannableString("给文字添加删除线");
        StrikethroughSpan st = new StrikethroughSpan();
        sps2.setSpan(st, 5, sps2.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv2.setText(sps2);

        SpannableString sps3 = new SpannableString("给文字添加下划线");
        UnderlineSpan ul = new UnderlineSpan();
        sps3.setSpan(ul, 5, sps3.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv3.setText(sps3);

        SpannableString sps4 = new SpannableString("为文字设置上标");
        SuperscriptSpan ss = new SuperscriptSpan();
        RelativeSizeSpan el = new RelativeSizeSpan(0.8f);
        sps4.setSpan(el, 5, sps4.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        sps4.setSpan(ss, 5, sps4.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv4.setText(sps4);

        SpannableString sps5 = new SpannableString("位文字设置下标");
        SubscriptSpan sub = new SubscriptSpan();
        sps5.setSpan(sub, 5, sps5.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv5.setText(sps5);

        SpannableString sps6 = new SpannableString("为文字设置粗体、斜体风格");
        StyleSpan sty = new StyleSpan(Typeface.BOLD);
        StyleSpan sty1 = new StyleSpan(Typeface.ITALIC);
        sps6.setSpan(sty, 5, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        sps6.setSpan(sty1, 8, 10, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv6.setText(sps6);
        tv6.setHighlightColor(Color.parseColor("#ff6655"));

        SpannableString sps7 = new SpannableString("在文字中添加表情（表情）");
        Drawable dra = getResources().getDrawable(R.mipmap.touxiang);
        dra.setBounds(0, 0, 42, 42);
        ImageSpan imagespan = new ImageSpan(dra);
        sps7.setSpan(imagespan, 6, 8, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv7.setText(sps7);

        SpannableString sps8 = new SpannableString("为文字设置点击事件");
        ClickableSpan cl = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                Toast.makeText(MainActivity.this, "我被点击了", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void updateDrawState(TextPaint ds) {
                //不显示下划线
                ds.setUnderlineText(false);
            }
        };
        sps8.setSpan(cl, 5, sps8.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //必须加这一句话，不然点击没效果
        tv8.setMovementMethod(LinkMovementMethod.getInstance());
        tv8.setText(sps8);

        SpannableString sps9 = new SpannableString("为文字设置超链接");
        URLSpan us = new URLSpan("http://www.baidu.com");
        sps9.setSpan(us, 5, sps9.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv9.setMovementMethod(LinkMovementMethod.getInstance());
        tv9.setText(sps9);

        SpannableString sps10 = new SpannableString("文字模糊和浮雕效果");
        MaskFilterSpan mf = new MaskFilterSpan(new MaskFilter());
        sps10.setSpan(mf, 3, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv10.setText(sps10);


    }
}
