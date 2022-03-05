package com.example.appenfermedades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class FinalResult extends AppCompatActivity {

    TextView diagnosticoTextView;
    TextView porcentajeTextView;
    Bundle bundle;
    Button empezarDeNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);

        diagnosticoTextView = findViewById(R.id.diagnosticoTextView);
        porcentajeTextView = findViewById(R.id.porcentajeTextView);

        bundle = getIntent().getExtras();
        diagnosticoTextView.setText(bundle.getString("diagnostico").toUpperCase());
        porcentajeTextView.setText("Probabilidad: " + bundle.getString("porcentaje") + "%");

        empezarDeNuevo = findViewById(R.id.btnStart1);
        empezarDeNuevo.setOnClickListener(view -> Start());
    }

    public void Start() {
        Intent intent = new Intent(this, BienvenidaActivity.class);
        startActivity(intent);
    }

}