package me.cassiano.betterxp.model;


import android.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.ArrayList;
import java.util.List;

@Parcel(Parcel.Serialization.BEAN)
public class PokemonOptimizationProblem extends BaseObservable {

    @SerializedName("function")
    private Function function;
    @SerializedName("restrictions")
    private List<Restriction> restrictions;


    public PokemonOptimizationProblem(List<Restriction> extraRestrictions) {
        initProblem();
        restrictions.addAll(extraRestrictions);
    }

    @ParcelConstructor
    public PokemonOptimizationProblem(Function function, List<Restriction> restrictions) {
        this.function = function;
        this.restrictions = restrictions;
    }

    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    public void addRestrictions(List<Restriction> restrictions) {
        this.restrictions.addAll(restrictions);
    }

    public Function getFunction() {
        return function;
    }

    private void initProblem() {
        Double[] fCoeff = {200.0, 1000.0, 90.0, 400.0, 1000.0, 2000.0};
        Double[] r1Coeff = {0.36, 0.3333, 0.0525, 0.1905, 0.1905, 0.1905};
        Double[] r2Coeff = {0.0, 0.0, 0.0, 2.0, 5.0, 10.0};

        function = Function.fromArray("MAX", fCoeff);
        restrictions = new ArrayList<>();

        restrictions.add(Restriction.fromArray("LT", r1Coeff, 30.0));
        restrictions.add(Restriction.fromArray("LT", r2Coeff, 10.0));
    }

}
