package me.cassiano.betterxp.fragment;

import android.support.v4.app.Fragment;

import java.util.List;

import me.cassiano.betterxp.model.Restriction;

public abstract class RestrictionComposerFragment extends Fragment {

    public abstract List<Restriction> getRestrictions();
}
