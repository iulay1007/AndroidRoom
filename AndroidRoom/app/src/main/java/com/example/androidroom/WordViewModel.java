package com.example.androidroom;

import android.app.Application;

import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private LiveData<List<Word>> allWordsLive;
    private WordDao wordDao;
    public WordViewModel(@NonNull Application application) {
        super(application);
        WordDataBase wordDataBase = WordDataBase.getDatabase(application);
        wordDao = wordDataBase.getWordDao();

        allWordsLive = wordDao.getAllWordsLive();
    }
    public LiveData<List<Word>> getAllWordsLive() {
        return allWordsLive;
    }

    void insertWords(Word... words) {
        new InsertAsyncTask(wordDao).execute(words);
    }
    static class InsertAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        public InsertAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {




            wordDao.insert(words);

            return null;
        }
    }
}