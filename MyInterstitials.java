package com.blogspot.hu2di.qrart.qart.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.blogspot.hu2di.qrart.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by HUNGDH on 1/9/2017.
 */

public class MyInterstitials {

    private Context context;
    private InterstitialAd mInterstitialAd;

    private final long DELTA_TIME = 60000;
    private final String LAST_TIME_SHOW_ADS = "lastTimeShowAds";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public MyInterstitials(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(LAST_TIME_SHOW_ADS, Context.MODE_PRIVATE);
        initializeInterstitialAds();
    }

    private void initializeInterstitialAds() {
        // Create the InterstitialAd and set the adUnitId.
        mInterstitialAd = new InterstitialAd(context);
        // Defined in res/values/strings.xml
        mInterstitialAd.setAdUnitId(context.getString(R.string.interstitials_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });

        requestNewInterstitial();
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    public void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded() && (System.currentTimeMillis() - getLastTime()) > DELTA_TIME) {
            mInterstitialAd.show();
            saveLastTime();
        }
    }

    @SuppressLint("CommitPrefEdits")
    private void saveLastTime() {
        editor = preferences.edit();
        editor.clear();
        editor.putLong(LAST_TIME_SHOW_ADS, System.currentTimeMillis());
        editor.commit();
    }

    private long getLastTime() {
        return preferences.getLong(LAST_TIME_SHOW_ADS, 1);
    }
}
