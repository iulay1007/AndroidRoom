package com.example.androidroom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface WordDao {

    @Insert
 (onConflict = OnConflictStrategy.REPLACE)
    void insert (Word... words);

    @Query("DElETE FROM table_word")
    void delete();

    @Query("SELECT * FROM table_word ORDER BY word  ")
    LiveData<List<Word>> getAllWordsLive();

}

