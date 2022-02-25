package com.example.appenfermedades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ViewQuestion2 extends AppCompatActivity {
    Button btnSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_question2);
        btnSiguiente = findViewById(R.id.btnSiguienteEscala2);
        btnSiguiente.setOnClickListener(view -> Pantalla_escala2());

    }
    public void Pantalla_escala2() {
        Intent intent = new Intent(this, ViewEscala2.class);
        startActivity(intent);
    }
}