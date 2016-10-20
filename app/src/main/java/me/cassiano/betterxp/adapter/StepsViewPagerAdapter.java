package me.cassiano.betterxp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import me.cassiano.betterxp.fragment.EvolutionsStepFragment;
import me.cassiano.betterxp.fragment.HatchEggsStepFragment;
import me.cassiano.betterxp.fragment.RestrictionComposerFragment;
import me.cassiano.betterxp.fragment.TransferStepFragment;
import me.cassiano.betterxp.model.Restriction;


public class StepsViewPagerAdapter extends FragmentPagerAdapter {

    private List<RestrictionComposerFragment> mFragmentsList = new ArrayList<>();

    public StepsViewPagerAdapter(FragmentManager fm, StepsViewPagerAdapter.OnNextClickListener listener) {
        super(fm);

        mFragmentsList.add(EvolutionsStepFragment.newInstance(listener));
        mFragmentsList.add(TransferStepFragment.newInstance(listener));
        mFragmentsList.add(HatchEggsStepFragment.newInstance(listener));
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentsList.size();
    }

    public List<Restriction> getRestrictions() {

        List<Restriction> restrictionList = new ArrayList<>();

        for (RestrictionComposerFragment fragment : mFragmentsList) {
            for (Restriction restriction : fragment.getRestrictions()) {

                if (restriction.getValue() == null)
                    restriction.setValue(0.0);

                restrictionList.add(restriction);
            }
        }

        return restrictionList;
    }

    public interface OnNextClickListener {
        void onNextClicked();
    }
}
