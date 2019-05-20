package com.example.megaconvertor.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.megaconvertor.entity.ExchangeRates;

import java.util.List;

@Dao
public interface ExchangeRatesDAO {

    @Insert
    void insertResult(ExchangeRates entity);

    @Query("SELECT * FROM ConversionResults ORDER BY id LIMIT 1")
    List<ExchangeRates> getMostRecent();
}
