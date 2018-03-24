package com.lychee.lychee_app.application;

import android.app.Application;

import com.tsengvn.typekit.Typekit;

/**
 * Created by quf93 on 2018-03-08.
 */

public class LycheeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // font 설정
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "fonts/NanumSquareR.otf"))
                .addBold(Typekit.createFromAsset(this, "fonts/NanumSquareB.otf"));
    }
}
