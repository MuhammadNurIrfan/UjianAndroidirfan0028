package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lvNama = (ListView) findViewById(R.id.lvNama);

        ArrayList<String> daftar_nama = getIntent().getExtras().getStringArrayList("daftar_nama");

        // Menyiapkan daftar angka ganjil
        ArrayList<String> angkaGanjil = new ArrayList<>();
        for (int i = 1; i <= 20; i += 2) {
            angkaGanjil.add(i + ". ");
        }

        // Menyatukan daftar nama dan angka ganjil
        ArrayList<String> combinedList = new ArrayList<>();
        int maxIndex = Math.min(daftar_nama.size(), angkaGanjil.size());
        for (int i = 0; i < maxIndex; i++) {
            combinedList.add(angkaGanjil.get(i) + daftar_nama.get(i));
        }

        // Menambahkan sisa angka ganjil atau daftar nama jika ada yang lebih panjang
        for (int i = maxIndex; i < angkaGanjil.size(); i++) {
            combinedList.add(angkaGanjil.get(i));
        }
        for (int i = maxIndex; i < daftar_nama.size(); i++) {
            combinedList.add(daftar_nama.get(i));
        }

        ArrayAdapter<String> ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, combinedList);

        lvNama.setAdapter(ad_nama);

    }
}