package com.example.zadanie_bazydanych;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText autorInput, tytulInput, cenaInput, stronyInput;
    private Button dodajBtn, usunBtn, zapiszBtn;
    private ListView listaKsiazek;
    private Ksiazki edytowanaKsiazka = null;

    private KsiazkiBazaDanych baza;
    private ArrayAdapter<String> adapter;
    private List<Ksiazki> ksiazkiLista = new ArrayList<>();
    private int wybranaPozycja = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autorInput = findViewById(R.id.autor);
        tytulInput = findViewById(R.id.tytul);
        cenaInput = findViewById(R.id.cena);
        stronyInput = findViewById(R.id.strony);

        dodajBtn = findViewById(R.id.dodaj);
        usunBtn = findViewById(R.id.usun);
        zapiszBtn = findViewById(R.id.zapisz);
        listaKsiazek = findViewById(R.id.lista);

        baza = KsiazkiBazaDanych.zwrocInstancjeBazyDanych(this);

        odswiezListe();

        // Dodawanie książki
        dodajBtn.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String autor = autorInput.getText().toString();
                String tytul = tytulInput.getText().toString();
                double cena = Double.parseDouble(cenaInput.getText().toString());
                int strony = Integer.parseInt(stronyInput.getText().toString());

                Ksiazki nowa = new Ksiazki(autor, tytul, cena, strony);
                baza.ksiazkiDao().dodajKsiazke(nowa);

                wyczyscPola();
                odswiezListe();
            }
        });

        // Usuwanie książki
        usunBtn.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wybranaPozycja != -1) {
                    baza.ksiazkiDao().usunKsiazke(ksiazkiLista.get(wybranaPozycja));
                    wybranaPozycja = -1;
                    odswiezListe();
                }
            }
        });

        // Kliknięcie na element listy
        listaKsiazek.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                wybranaPozycja = position;
            }
        });

        // Długie kliknięcie – edycja
        listaKsiazek.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                edytowanaKsiazka = ksiazkiLista.get(position);

                autorInput.setText(edytowanaKsiazka.autor);
                tytulInput.setText(edytowanaKsiazka.tytul);
                cenaInput.setText(String.valueOf(edytowanaKsiazka.cena));
                stronyInput.setText(String.valueOf(edytowanaKsiazka.liczbaStron));

                return true;
            }
        });

        // Zapisanie edytowanej książki
        zapiszBtn.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edytowanaKsiazka != null) {
                    edytowanaKsiazka.autor = autorInput.getText().toString();
                    edytowanaKsiazka.tytul = tytulInput.getText().toString();
                    edytowanaKsiazka.cena = Double.parseDouble(cenaInput.getText().toString());
                    edytowanaKsiazka.liczbaStron = Integer.parseInt(stronyInput.getText().toString());

                    baza.ksiazkiDao().aktualizujKsiazke(edytowanaKsiazka);

                    edytowanaKsiazka = null;

                    wyczyscPola();
                    odswiezListe();
                }
            }
        });
    }

    private void odswiezListe() {
        ksiazkiLista = baza.ksiazkiDao().pobierzWszystkie();

        List<String> daneDoListy = new ArrayList<>();
        for (Ksiazki k : ksiazkiLista) {
            daneDoListy.add(k.autor + " - " + k.tytul + " (" + k.cena + " zł, " + k.liczbaStron + " str.)");
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daneDoListy);
        listaKsiazek.setAdapter(adapter);
    }

    private void wyczyscPola() {
        autorInput.setText("");
        tytulInput.setText("");
        cenaInput.setText("");
        stronyInput.setText("");
    }
}