#########################################
// For banners
compile('com.mopub:mopub-sdk-banner:4.12.0@aar') {
    transitive = true
}
// For interstitials
compile('com.mopub:mopub-sdk-interstitial:4.12.0@aar') {
    transitive = true
}

#########################################	
<activity android:name="com.mopub.mobileads.MoPubActivity" android:configChanges="keyboardHidden|orientation|screenSize"/>
<activity android:name="com.mopub.mobileads.MraidActivity" android:configChanges="keyboardHidden|orientation|screenSize"/>
<activity android:name="com.mopub.common.MoPubBrowser" android:configChanges="keyboardHidden|orientation|screenSize"/>
<activity android:name="com.mopub.mobileads.MraidVideoPlayerActivity" android:configChanges="keyboardHidden|orientation|screenSize"/>

#########################################
<string name="mopub_banner_ad_unit_id" translatable="false">b195f8dd8ded45fe847ad89ed1d016da</string>
<string name="mopub_interstitial_ad_unit_id" translatable="false">24534e1901884e398f1253216226017e</string>

#########################################
<com.mopub.mobileads.MoPubView
    android:id="@+id/adview"
    android:layout_width="320dp"
    android:layout_height="50dp"
    android:layout_alignParentBottom="true"
    android:layout_centerInParent="true"/>

#########################################
private MoPubView moPubView;

    private void initBanner() {
        moPubView = (MoPubView) findViewById(R.id.adview);
        moPubView.setAdUnitId(getResources().getString(R.string.mopub_banner_ad_unit_id));
        moPubView.loadAd();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moPubView.destroy();
    }

##########################################
private MoPubInterstitial mInterstitial;

	private void initInterstitialAds() {
        mInterstitial = new MoPubInterstitial(this, getResources().getString(R.string.mopub_interstitial_ad_unit_id));
        mInterstitial.load();
    }
	
	@Override
    protected void onDestroy() {
        super.onDestroy();
        mInterstitial.destroy();
    }
	
	if (mInterstitial.isReady()) {
        mInterstitial.show();
    }
