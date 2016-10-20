package me.cassiano.betterxp.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VettselSolutionResponse {


    @SerializedName("status")
    private String status;
    @SerializedName("values")
    private List<Double> values;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Double> getValues() {
        return values;
    }

    public void setValues(List<Double> values) {
        this.values = values;
    }

    public int totalXP() {
        return Math.abs(values.get(0).intValue());
    }

    public int getCatches() {
        return (int) Math.max(values.get(1), 0.0);
    }

    public int getEvolutions() {
        return (int) Math.max(values.get(2), 0.0);
    }

    public int getTransfers() {
        return (int) Math.max(values.get(3), 0.0);
    }

    public int getTwokmEggs() {
        return (int) Math.max(values.get(4), 0.0);
    }

    public int getFivekmEggs() {
        return (int) Math.max(values.get(5), 0.0);
    }

    public int getTenkmEggs() {
        return (int) Math.max(values.get(6), 0.0);
    }
}
