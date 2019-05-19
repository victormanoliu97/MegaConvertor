package com.example.megaconvertor.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ConversionResults {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String fromUnit;

    private Double fromValue;

    private String toUnit;

    private String resultedValue;

    public ConversionResults() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(String fromUnit) {
        this.fromUnit = fromUnit;
    }

    public Double getFromValue() {
        return fromValue;
    }

    public void setFromValue(Double fromValue) {
        this.fromValue = fromValue;
    }

    public String getToUnit() {
        return toUnit;
    }

    public void setToUnit(String toUnit) {
        this.toUnit = toUnit;
    }

    public String getResultedValue() {
        return resultedValue;
    }

    public void setResultedValue(String resultedValue) {
        this.resultedValue = resultedValue;
    }
}
