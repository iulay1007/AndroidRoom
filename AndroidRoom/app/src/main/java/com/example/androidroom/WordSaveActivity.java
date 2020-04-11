package com.example.androidroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WordSaveActivity extends AppCompatActivity {
    public static final String REPLY = "REPLY";
    private EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_save);
        mEditText = findViewById(R.id.edit);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent reply = new Intent();
                if (TextUtils.isEmpty(mEditText.getText())) {
                    setResult(RESULT_CANCELED, reply);
                } else {
                    String word = mEditText.getText().toString();
                    reply.putExtra(REPLY, word);
                    setResult(RESULT_OK, reply);
                }
                finish();
            }
        });

    }
}
