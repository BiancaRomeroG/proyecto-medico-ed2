package com.example.appenfermedades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSiguiente = findViewById(R.id.btnMain);
        btnSiguiente.setOnClickListener(view -> SiguientePantalla());
    }
    public void SiguientePantalla() {
        Intent intent = new Intent(this, BienvenidaActivity.class);
        startActivity(intent);
    }
}