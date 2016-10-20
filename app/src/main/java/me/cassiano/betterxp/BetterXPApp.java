package me.cassiano.betterxp;

import android.app.Application;

import me.cassiano.betterxp.service.VettselService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BetterXPApp extends Application {

    private static BetterXPApp instance;
    private static VettselService vettselService;

    public static BetterXPApp getInstance() {
        return instance;
    }

    public static VettselService getVettselService() {
        return vettselService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://vettsel.cassiano.me:4567")
                .build();

        vettselService = retrofit.create(VettselService.class);
    }


}
