package me.cassiano.betterxp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.cassiano.betterxp.adapter.StepsViewPagerAdapter;
import me.cassiano.betterxp.databinding.FragmentPokemonTransfersBinding;
import me.cassiano.betterxp.model.Restriction;
import me.cassiano.betterxp.model.TransfersRestriction;


public class TransferStepFragment extends RestrictionComposerFragment {

    final TransfersRestriction mRestriction = new TransfersRestriction();
    private StepsViewPagerAdapter.OnNextClickListener mListener;

    public static TransferStepFragment newInstance(StepsViewPagerAdapter.OnNextClickListener listener) {
        TransferStepFragment fragment = new TransferStepFragment();
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

        FragmentPokemonTransfersBinding binding =
                FragmentPokemonTransfersBinding.inflate(inflater);

        binding.setRestriction(mRestriction);
        binding.setListener(mListener);

        return binding.getRoot();
    }

    public void setListener(StepsViewPagerAdapter.OnNextClickListener listener) {
        mListener = listener;
    }
}
