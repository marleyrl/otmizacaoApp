package me.cassiano.betterxp.model;

import java.util.Arrays;

public class Egg2KmRestriction extends Restriction {

    public Egg2KmRestriction() {

        setType("LT");
        Double[] coeff = {0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
        setCoefficients(Arrays.asList(coeff));
        setValue(null);
    }

}
