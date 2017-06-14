compile 'com.google.android.gms:play-services-ads:10.2.0'

<string name="native_ad_unit_id">ca-app-pub-3940256099942544/1072772517</string>
<string name="banner_ad_unit_id">ca-app-pub-3940256099942544/6300978111</string>
<string name="interstitial_ad_unit_id">ca-app-pub-3940256099942544/1033173712</string>

Rewarded Video 		ca-app-pub-3940256099942544/5224354917
Native Advanced 	ca-app-pub-3940256099942544/2247696110
Native Express 	(Small template): ca-app-pub-3940256099942544/2793859312
		(Large template): ca-app-pub-3940256099942544/2177258514

//BANNER
xmlns:ads="http://schemas.android.com/apk/res-auto"

<com.google.android.gms.ads.AdView
        android:id="@+id/adView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_alignParentBottom="true"
        ads:adSize="SMART_BANNER"
        ads:adUnitId="@string/banner_ad_unit_id"/>

private void initBanner() {
    final AdView mAdView = (AdView) findViewById(R.id.adView);
    
    mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                mAdView.setVisibility(View.GONE);
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mAdView.setVisibility(View.VISIBLE);
            }
    });
    
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);
}

//INTERSTITIAL
private InterstitialAd mInterstitialAd;

private void initInterstitialAd() {
	mInterstitialAd = new InterstitialAd(this);
	mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));

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
        .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
        .build();

    mInterstitialAd.loadAd(adRequest);
}
         
private void showInterstitial() {
    if (mInterstitialAd.isLoaded()) {
        mInterstitialAd.show();
    }
}

//NATIVE
<com.google.android.gms.ads.NativeExpressAdView
        android:id="@+id/adViewExpress"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        ads:adSize="320x300"
        ads:adUnitId="@string/native_ad_unit_id"/>

private void initNativeAds() {
    final NativeExpressAdView nativeAds = (NativeExpressAdView) findViewById(R.id.adViewExpress);
    nativeAds.setAdListener(new AdListener() {
        @Override
        public void onAdLoaded() {
            super.onAdLoaded();
            nativeAds.setVisibility(View.VISIBLE);
        }
	@Override
        public void onAdFailedToLoad(int i) {
            super.onAdFailedToLoad(i);
            nativeAds.setVisibility(View.GONE);
        }
    });
    AdRequest adRequest = new AdRequest.Builder()
          //.addTestDevice("8B6D4ADFA9FB66F0468D16879194A3DE")
            .build();
nativeAds.loadAd(adRequest);
}

