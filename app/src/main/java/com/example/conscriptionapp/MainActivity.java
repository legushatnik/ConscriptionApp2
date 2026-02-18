package com.example.conscriptionapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText fam, name, otch, age;
    Spinner cat;
    Button knopka;
    TextView schetchik;
    ListView spisok;

    ArrayList<String> vse_zapisi;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fam = findViewById(R.id.pole_fam);
        name = findViewById(R.id.pole_name);
        otch = findViewById(R.id.pole_otch);
        age = findViewById(R.id.pole_age);
        cat = findViewById(R.id.pole_cat);
        knopka = findViewById(R.id.knopka);
        schetchik = findViewById(R.id.schetchik);
        spisok = findViewById(R.id.spisok);

        String[] kategorii = {"А", "Б", "В", "Г", "Д"};
        ArrayAdapter<String> catAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, kategorii);
        cat.setAdapter(catAdapter);

        vse_zapisi = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vse_zapisi);
        spisok.setAdapter(adapter);

        knopka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textFam = fam.getText().toString();
                String textName = name.getText().toString();
                String textOtch = otch.getText().toString();
                String textAge = age.getText().toString();
                String textCat = cat.getSelectedItem().toString();

                String date = java.text.DateFormat.getDateInstance().format(new java.util.Date());

                String novaya_zapis = textFam + " " + textName + " " + textOtch + "\n" +
                        textAge + " лет\n" +
                        "Категория: " + textCat + "\n" +
                        "Дата добавления: " + date;

                vse_zapisi.add(novaya_zapis);
                adapter.notifyDataSetChanged();
                schetchik.setText("Записей: " + vse_zapisi.size());

                fam.setText("");
                name.setText("");
                otch.setText("");
                age.setText("");
                cat.setSelection(0);
            }
        });
    }
}