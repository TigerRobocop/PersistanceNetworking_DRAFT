package com.tigerrobocop.liv.localpersistence.Util;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tigerrobocop.liv.localpersistence.Model.Article;
import com.tigerrobocop.liv.localpersistence.R;

import java.util.List;

public class HttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
    }

    public class OkHTTPAsyncTask extends AsyncTask<String, Void, List<Article>> {


        @Override
        protected List<Article> doInBackground(String... strings) {
            return null;
        }
    }
}
