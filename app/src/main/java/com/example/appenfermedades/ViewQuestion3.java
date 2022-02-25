package com.example.appenfermedades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ViewQuestion3 extends AppCompatActivity {
    Button btnSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_question1);
        btnSiguiente = findViewById(R.id.btnSiguienteEscala3);
        btnSiguiente.setOnClickListener(view -> Pantalla_escala3());

    }
    public void Pantalla_escala3() {
        Intent intent = new Intent(this, ViewEscala3.class);
        startActivity(intent);
    }
}