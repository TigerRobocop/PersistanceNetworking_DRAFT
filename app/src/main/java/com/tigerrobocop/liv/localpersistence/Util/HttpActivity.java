package com.tigerrobocop.liv.localpersistence.Util;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tigerrobocop.liv.localpersistence.R;

public class HttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
    }

    public class OkHTTPAsyncTask extends AsyncTask<String, Void, List<Article>>{


    }
}
