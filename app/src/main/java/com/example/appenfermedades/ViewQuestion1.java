package com.example.appenfermedades;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ViewQuestion1 extends AppCompatActivity {
    Button btnSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_question1);
        btnSiguiente = findViewById(R.id.btnSiguienteEscala1);
//      btnSiguiente.setOnClickListener(view -> Pantalla_escala1());

    }
//    public void Pantalla_escala1() {
//        Intent intent = new Intent(this, ViewEscala1.class);
//        startActivity(intent);
//    }
}