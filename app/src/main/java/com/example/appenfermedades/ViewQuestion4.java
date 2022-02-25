package com.example.appenfermedades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ViewQuestion4 extends AppCompatActivity {

    Button btnSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_question1);
        btnSiguiente = findViewById(R.id.btnSiguienteEscala4);
        btnSiguiente.setOnClickListener(view -> Pantalla_escala4());

    }
    public void Pantalla_escala4() {
        Intent intent = new Intent(this, ViewEscala4.class);
        startActivity(intent);
    }
}