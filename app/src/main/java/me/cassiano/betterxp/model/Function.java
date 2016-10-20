package me.cassiano.betterxp.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.Arrays;
import java.util.List;

@Parcel(Parcel.Serialization.BEAN)
public class Function {

    @SerializedName("coefficients")
    private List<Double> coefficients;
    @SerializedName("operation")
    private String operation;

    public static Function fromArray(String operation, Double[] coefficients) {

        Function function = new Function();
        function.operation = operation;
        function.coefficients = Arrays.asList(coefficients);

        return function;
    }

    public List<Double> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(List<Double> coefficients) {
        this.coefficients = coefficients;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}
