package me.cassiano.betterxp.model;

import java.util.Arrays;

public class EvolutionsRestriction extends Restriction {

    public EvolutionsRestriction() {

        setType("LT");
        Double[] coeff = {0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
        setCoefficients(Arrays.asList(coeff));
        setValue(null);
    }

}
