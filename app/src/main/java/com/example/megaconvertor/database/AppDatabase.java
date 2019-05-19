package com.example.megaconvertor.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.megaconvertor.dao.ConversionResultsDAO;
import com.example.megaconvertor.dao.ExchangeRatesDAO;
import com.example.megaconvertor.entity.ConversionResults;
import com.example.megaconvertor.entity.ExchangeRates;

@Database(entities = {ConversionResults.class, ExchangeRates.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ConversionResultsDAO conversionResultsDAO();
    public abstract ExchangeRatesDAO exchangeRatesDAO();
}
