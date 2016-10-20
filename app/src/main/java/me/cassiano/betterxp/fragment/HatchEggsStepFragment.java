package me.cassiano.betterxp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.cassiano.betterxp.adapter.StepsViewPagerAdapter;
import me.cassiano.betterxp.databinding.FragmentPokemonEggsBinding;
import me.cassiano.betterxp.model.Egg10KmRestriction;
import me.cassiano.betterxp.model.Egg2KmRestriction;
import me.cassiano.betterxp.model.Egg5KmRestriction;
import me.cassiano.betterxp.model.Restriction;


public class HatchEggsStepFragment extends RestrictionComposerFragment {

    private final Egg2KmRestriction restriction2km = new Egg2KmRestriction();
    private final Egg5KmRestriction restriction5km = new Egg5KmRestriction();
    private final Egg10KmRestriction restriction10km = new Egg10KmRestriction();

    private StepsViewPagerAdapter.OnNextClickListener mListener;

    public static HatchEggsStepFragment newInstance(StepsViewPagerAdapter.OnNextClickListener listener) {
        HatchEggsStepFragment fragment = new HatchEggsStepFragment();
        fragment.setListener(listener);
        return fragment;
    }

    @Override
    public List<Restriction> getRestrictions() {

        List<Restriction> restrictionList = new ArrayList<>();

        restrictionList.add(restriction2km);
        restrictionList.add(restriction5km);
        restrictionList.add(restriction10km);

        return restrictionList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentPokemonEggsBinding binding =
                FragmentPokemonEggsBinding.inflate(inflater);

        binding.setRestriction2km(restriction2km);
        binding.setRestriction5km(restriction5km);
        binding.setRestriction10km(restriction10km);
        binding.setListener(mListener);

        return binding.getRoot();
    }

    public void setListener(StepsViewPagerAdapter.OnNextClickListener listener) {
        this.mListener = listener;
    }
}
