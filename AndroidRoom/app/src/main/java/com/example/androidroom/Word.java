package com.example.androidroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


    @Entity(tableName = "table_word")
    public class Word {
        //表结构中必须有一个主键，主键的声明为 @PrimaryKey ，而主键递增则在其后添加 (autoGenerate = true)。
        @PrimaryKey
                //(autoGenerate = true)
        //列名的注解使用 @ColumnInfo
        @ColumnInfo(name = "word")
        @NonNull



        private String mWord;

        //必须指定一个构造方法，room框架需要。并且只能指定一个
//，如果有其他构造方法，则其他的构造方法必须添加@Ignore注解
        public Word(@NonNull String word){
            this.mWord=word;
        }
        @NonNull
        public String getWord(){
            return this.mWord;
        }
    }
