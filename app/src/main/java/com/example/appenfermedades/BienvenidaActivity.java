package com.example.appenfermedades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class BienvenidaActivity extends AppCompatActivity {
    Button btnHola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        btnHola = findViewById(R.id.btnSiguienteBienvenida);
        btnHola.setOnClickListener(view -> PantallaPregunta1());
    }
    public void PantallaPregunta1(){
        Intent intent = new Intent(this, ViewQuestion1.class);
        startActivity(intent);
    }
}