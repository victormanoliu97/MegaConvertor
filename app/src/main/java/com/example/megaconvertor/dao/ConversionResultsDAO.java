package com.example.megaconvertor.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.megaconvertor.entity.ConversionResults;

import java.util.List;

@Dao
public interface ConversionResultsDAO {

    @Insert
    void insertResult(ConversionResults entity);

    @Query("SELECT * FROM ConversionResults ORDER BY id LIMIT 2")
    List<ConversionResults> getMostRecent();
}
