package com.tigerrobocop.liv.localpersistence;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tigerrobocop.liv.localpersistence.Data.DAO;
import com.tigerrobocop.liv.localpersistence.Model.Article;
import com.tigerrobocop.liv.localpersistence.Model.Car;
import com.tigerrobocop.liv.localpersistence.Util.Util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String API_URL = "https://newsapi.org/v1/articles?source=techcrunch&sortBy=top&apiKey=64986f7d415e4b9c8760350f723f235d";


    Button mBtnInsert;
    Button mBtnListALl;

    EditText mInputName;
    EditText mInputYear;

    DAO mDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDAO = new DAO(this);

        mBtnInsert = (Button) findViewById(R.id.btn_add_item);
        mBtnListALl = (Button) findViewById(R.id.btn_list_all);
        mInputName = (EditText) findViewById(R.id.input_new_item_name);
        mInputYear = (EditText) findViewById(R.id.input_new_item_year);

        mBtnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertCar();
            }
        });

        mBtnListALl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(it);
            }
        });


        if (Util.isConnected(MainActivity.this)) {
            LoadArticleTask task = new LoadArticleTask();
            task.execute(API_URL);
        }
    }


    private void InsertCar() {

        String name = mInputName.getText().toString();
        String year = mInputYear.getText().toString();

        int id = mDAO.GetCount();

        mDAO.Insert(new Car(id, name, year));


        mInputName.setText("");
        mInputYear.setText("");

        Toast.makeText(this
                , R.string.insert_success
                , Toast.LENGTH_SHORT).show();
    }


    public class LoadArticleTask extends AsyncTask<String, Void, List<Article>> {

        @Override
        protected List<Article> doInBackground(String... strings) {
            List<Article> result = new ArrayList<>();

            String url = strings[0];
            // connects to internet and places request
            InputStream stream = Util.getStream(url);

            // cast stream to string
            String body = Util.streamToString(stream);

            // parses string to json, then json as object
            result = Util.parse(body);

            return result;
        }

        @Override
        protected void onPostExecute(List<Article> articles) {
            super.onPostExecute(articles);

            for(Article obj: articles){
                Log.d("ARTliv", "Author name:" + obj.author);
            }
        }
    }


}


