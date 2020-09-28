package com.spatel.customeadapterpart1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView ls;
    private CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ls = findViewById(R.id.lsView);

        adapter = new CustomAdapter(this,getjsonString());

        ls.setAdapter(adapter);

    }

    private JSONArray getjsonString() {
        JSONObject jobj;
        JSONArray jarr = null;
        InputStream is;
        try {

            is = this.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String jsonString = new String(buffer,"UTF-8");

            jobj = new JSONObject(jsonString);
            jarr = jobj.getJSONArray("Formula");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jarr;
    }
}