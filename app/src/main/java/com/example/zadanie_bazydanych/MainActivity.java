package com.example.zadanie_bazydanych;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText tytul;
    private EditText autor;
    private EditText cena;
    private EditText iloscStron;
    private Button dodajButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tytul = findViewById(R.id.tytul);
        autor = findViewById(R.id.autor);
        cena = findViewById(R.id.cena);
        iloscStron = findViewById(R.id.iloscStron);
        dodajButton = findViewById(R.id.dodaj);
    }

}