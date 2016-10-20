package me.cassiano.betterxp.model;

import java.util.Arrays;

public class Egg5KmRestriction extends Restriction {

    public Egg5KmRestriction() {

        setType("LT");
        Double[] coeff = {0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
        setCoefficients(Arrays.asList(coeff));
        setValue(null);
    }

}
