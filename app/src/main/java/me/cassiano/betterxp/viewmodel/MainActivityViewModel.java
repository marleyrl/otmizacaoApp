package me.cassiano.betterxp.viewmodel;


import android.app.Activity;

import me.cassiano.betterxp.MainFluxActivity;

public class MainActivityViewModel implements BaseViewModel {


    private Activity mActivity;

    public MainActivityViewModel(Activity activity) {
        mActivity = activity;

    }

    @Override
    public void destroy() {
        mActivity = null;

    }

    public void onNextClicked() {
        MainFluxActivity.start(mActivity);
        mActivity.finish();
    }
}
