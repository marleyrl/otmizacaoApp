package me.cassiano.betterxp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import me.cassiano.betterxp.databinding.ActivityMainBinding;
import me.cassiano.betterxp.viewmodel.MainActivityViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setViewModel(new MainActivityViewModel(this));
    }

    @Override
    protected void onDestroy() {
        mBinding.getViewModel().destroy();
        super.onDestroy();
    }
}
