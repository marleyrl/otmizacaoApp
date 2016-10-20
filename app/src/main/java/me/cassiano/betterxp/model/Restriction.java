package me.cassiano.betterxp.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.Arrays;
import java.util.List;

@Parcel(Parcel.Serialization.BEAN)
public class Restriction extends BaseObservable {

    @SerializedName("coefficients")
    private List<Double> coefficients;

    @SerializedName("type")
    private String type;

    @SerializedName("value")
    private Double value;

    public static Restriction fromArray(String type, Double[] coefficients, Double value) {

        Restriction restriction = new Restriction();
        restriction.type = type;
        restriction.coefficients = Arrays.asList(coefficients);
        restriction.value = value;

        return restriction;

    }

    public List<Double> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(List<Double> coefficients) {
        this.coefficients = coefficients;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Bindable
    public String getStringValue() {

        if (value == null)
            return null;

        return String.valueOf(value.intValue());
    }

    public void setStringValue(String value) {

        try {
            this.value = Double.valueOf(value);
        } catch (NumberFormatException e) {
            this.value = null;
        }

        notifyPropertyChanged(BR.stringValue);
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
