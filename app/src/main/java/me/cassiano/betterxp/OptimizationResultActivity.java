package me.cassiano.betterxp;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import org.parceler.Parcels;

import me.cassiano.betterxp.databinding.ActivityOptimizationResultBinding;
import me.cassiano.betterxp.model.PokemonOptimizationProblem;
import me.cassiano.betterxp.viewmodel.OptimizationResultViewModel;

public class OptimizationResultActivity extends BaseActivity<ActivityOptimizationResultBinding> {

    private static final String EXTRA_PROBLEM = "EXTRA_PROBLEM";

    public static void start(Context context, PokemonOptimizationProblem problem) {

        Intent intent = new Intent(context, OptimizationResultActivity.class);
        intent.putExtra(EXTRA_PROBLEM, Parcels.wrap(problem));
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_optimization_result);
        setupToolbar();

        PokemonOptimizationProblem problem
                = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_PROBLEM));
        mBinding.setViewModel(new OptimizationResultViewModel(problem));
    }

    @Override
    protected void onDestroy() {
        mBinding.getViewModel().destroy();
        super.onDestroy();
    }

    private void setupToolbar() {

        if (getSupportActionBar() != null) {

            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDefaultDisplayHomeAsUpEnabled(true);

        }

    }
}
