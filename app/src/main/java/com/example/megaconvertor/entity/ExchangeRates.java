package com.example.megaconvertor.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ExchangeRates {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "base")
    private String base;

    @ColumnInfo(name = "symbol")
    private String symbol;

    @ColumnInfo(name = "value")
    private Double value;

    public ExchangeRates() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return base + " -> " + symbol + ":" + value;
    }
}
