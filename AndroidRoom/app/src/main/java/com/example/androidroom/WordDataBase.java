package com.example.androidroom;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/*使用注解来声明 @Database(entities = {Word.class},version = 1,exportSchema = false)
entities = {Word.class}的{}中来填写entity，可添加多个。
version 是当前数据库版本*/

@Database(entities = {Word.class}, version = 1, exportSchema = false)

    public abstract class WordDataBase extends RoomDatabase {

    private static WordDataBase INSTANCE;

    static synchronized WordDataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            /*Room.databaseBuilder(context.getApplicationContext(),WordDatabase.class,"word_database").build
第一个参数是activity，第二个参数为database的映射，第三个参数为数据库名称。*/

            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordDataBase.class, "word_database").addCallback(DatabaseCallback)
                    .build();


        }

        return INSTANCE;
    }
    //不用我们实现，room会帮我们实现
    public abstract WordDao getWordDao();

    private static RoomDatabase.Callback DatabaseCallback = new RoomDatabase.Callback(){
        private WordViewModel mmWordViewModel;
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

           class  FirstAsyncTask extends AsyncTask<Word, Void, Void> {


                @Override
                protected Void doInBackground(Word... words) {
                    WordDao dao = INSTANCE.getWordDao();
                    dao.delete();

                    dao.insert(words);
                    return null;
                }

            }
            Word word = new Word("Hello");
           Word word1=new Word("World");
            new FirstAsyncTask().execute(word,word1);








    }};

}

