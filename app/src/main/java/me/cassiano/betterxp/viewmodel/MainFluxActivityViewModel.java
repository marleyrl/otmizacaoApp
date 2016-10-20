package me.cassiano.betterxp.viewmodel;


import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import me.cassiano.betterxp.OptimizationResultActivity;
import me.cassiano.betterxp.adapter.StepsViewPagerAdapter;
import me.cassiano.betterxp.model.PokemonOptimizationProblem;
import me.cassiano.betterxp.model.Restriction;

public class MainFluxActivityViewModel implements BaseViewModel, StepsViewPagerAdapter.OnNextClickListener {

    private AppCompatActivity mActivity;
    private StepsViewPagerAdapter mFragmentPagerAdapter;
    private ViewPager mViewPager;

    public MainFluxActivityViewModel(AppCompatActivity activity, ViewPager viewPager) {
        mActivity = activity;
        mFragmentPagerAdapter = new StepsViewPagerAdapter(activity.getSupportFragmentManager(), this);
        mViewPager = viewPager;
    }

    @Override
    public void destroy() {
        mActivity = null;

    }

    public FragmentPagerAdapter getViewPagerAdapter() {
        return mFragmentPagerAdapter;
    }

    @Override
    public void onNextClicked() {

        if (mViewPager.getCurrentItem() + 1 < mFragmentPagerAdapter.getCount())
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);

        else {
            // get all restrictions, finish the activity
            // and start the result activity!

            List<Restriction> restrictionList =
                    mFragmentPagerAdapter.getRestrictions();

            PokemonOptimizationProblem pokemonOptimizationProblem =
                    new PokemonOptimizationProblem(restrictionList);

            OptimizationResultActivity.start(mViewPager.getContext(), pokemonOptimizationProblem);
            mActivity.finish();

        }

    }
}
