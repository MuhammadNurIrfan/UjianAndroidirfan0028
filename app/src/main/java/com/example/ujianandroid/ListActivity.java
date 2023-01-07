package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lvNama = (ListView) findViewById(R.id.lvNama);

        ArrayList<String> daftar_nama = getIntent().getExtras().getStringArrayList("daftar_nama");

        if(daftar_nama.isEmpty()){
            daftar_nama.add("data masih kosong");
        }

        ArrayAdapter<String> ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftar_nama);

        lvNama.setAdapter(ad_nama);

    }
}