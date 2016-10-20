package me.cassiano.betterxp.model;

import java.util.Arrays;

public class Egg10KmRestriction extends Restriction {

    public Egg10KmRestriction() {

        setType("LT");
        Double[] coeff = {0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        setCoefficients(Arrays.asList(coeff));
        setValue(null);
    }

}
