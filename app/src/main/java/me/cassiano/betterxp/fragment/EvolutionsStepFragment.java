package me.cassiano.betterxp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.cassiano.betterxp.adapter.StepsViewPagerAdapter;
import me.cassiano.betterxp.databinding.FragmentPokemonEvolutionsBinding;
import me.cassiano.betterxp.model.EvolutionsRestriction;
import me.cassiano.betterxp.model.Restriction;


public class EvolutionsStepFragment extends RestrictionComposerFragment {

    final EvolutionsRestriction mRestriction = new EvolutionsRestriction();
    StepsViewPagerAdapter.OnNextClickListener mListener;


    public static EvolutionsStepFragment newInstance(StepsViewPagerAdapter.OnNextClickListener listener) {
        EvolutionsStepFragment fragment = new EvolutionsStepFragment();
        fragment.setListener(listener);
        return fragment;
    }

    @Override
    public List<Restriction> getRestrictions() {

        List<Restriction> restrictionList = new ArrayList<>();
        restrictionList.add(mRestriction);

        return restrictionList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentPokemonEvolutionsBinding binding =
                FragmentPokemonEvolutionsBinding.inflate(inflater);

        binding.setRestriction(mRestriction);
        binding.setListener(mListener);

        return binding.getRoot();
    }

    private void setListener(StepsViewPagerAdapter.OnNextClickListener listener) {
        mListener = listener;
    }
}
