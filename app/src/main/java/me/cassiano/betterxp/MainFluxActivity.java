package me.cassiano.betterxp;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import me.cassiano.betterxp.databinding.ActivityMainFluxBinding;
import me.cassiano.betterxp.viewmodel.MainFluxActivityViewModel;

public class MainFluxActivity extends BaseActivity<ActivityMainFluxBinding> {

    public static void start(Context context) {
        Intent intent = new Intent(context, MainFluxActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_flux);
        mBinding.setViewModel(new MainFluxActivityViewModel(this, mBinding.vpPager));
    }

    @Override
    protected void onDestroy() {
        mBinding.getViewModel().destroy();
        super.onDestroy();
    }
}
