package com.example.appenfermedades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appenfermedades.negocio.ArbolBinario;
import com.example.appenfermedades.negocio.Datos;
import com.example.appenfermedades.negocio.Enfermedad;
import com.google.android.material.chip.Chip;

import java.util.LinkedList;

public class ViewQuestion1 extends AppCompatActivity {
    Button btnSiguiente;
    Chip siChip;
    Chip noChip;
    TextView preguntaTxtView;
    Bundle bundle = new Bundle();

    LinkedList<String> p;
    LinkedList<String> e;

    LinkedList<Enfermedad> enfermedades;
    LinkedList<String> nombreEnf;

    ArbolBinario A;
    boolean segundaRonda;
    int i = 0;
    int posMayor = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_question1);

        A = new ArbolBinario();

        // Widgets
        btnSiguiente = findViewById(R.id.btnSiguienteEscala1);
        siChip = findViewById(R.id.siChip);
        noChip = findViewById(R.id.noChip);
        preguntaTxtView = findViewById(R.id.preguntaTxtView);

        // Preguntas y Enfermedades
        p = new LinkedList<>();
        e = new LinkedList<>();

        enfermedades = new LinkedList<>();
        nombreEnf = new LinkedList<>();

        cargarDatosPrimerEtapa();


        // Preguntas
        segundaRonda = false;
        preguntar(i);

        // Listeners
        btnSiguiente.setOnClickListener(view -> siguientePregunta());

    }

    // Datos

    public void cargarDatosPrimerEtapa() {
        Datos.sintomasPrimerEtapa(e, p);
    }

    public void cargarDatosSegundaEtapa() {
        p = new LinkedList<>();
        e = new LinkedList<>();
        switch (posMayor) {
            case 0:
                Datos.sintomasEnfermedadesRespiratorias(e, p);
                break;
            case 1:
                Datos.sintomasEnfermedadesCardiacas(e, p);
                break;
            case 2:
                Datos.sintomasEnfermedadesVirales(e, p);
                break;
            case 3:
                Datos.sintomasEnfermedadesInstetinales(e, p);
                break;
            case 4:
                Datos.sintomasEnfermedadesExternas(e, p);
                break;
            default:
        }

        i = 0;
        segundaRonda = true;
        preguntar(i);
    }

    public void cargarEnfermedades() {
        enfermedades = new LinkedList<>();
        nombreEnf = new LinkedList<>();
        switch (posMayor) {
            case 0:
                Datos.enfermedadesRespiratorias(enfermedades, nombreEnf);
                break;
            case 1:
                Datos.enfermedadesCardiacas(enfermedades, nombreEnf);
                break;
            case 2:
                Datos.enfermedadesVirales(enfermedades, nombreEnf);
                break;
            case 3:
                Datos.enfermedadesIntestinales(enfermedades, nombreEnf);
                break;
            case 4:
                Datos.enfermedadesExternas(enfermedades, nombreEnf);
                break;
            default:
        }
    }

    // Validaciones

    public boolean tieneRespuesta() {
        return siChip.isChecked() || noChip.isChecked();
    }

    // Preguntas

    public void preguntar(int i) {
        siChip.setChecked(false);
        noChip.setChecked(false);
        if (i < p.size()) {
            preguntaTxtView.setText(p.get(i));
        } else {
            if (!segundaRonda) {
                Evaluar1();
            } else {
                Evaluar2();
            }
        }
    }

    public void siguientePregunta() {
        if (tieneRespuesta()) {
            boolean respuesta = siChip.isChecked();
            if (respuesta) {
                A.insertar(true, e.get(i));
            } else {
                A.insertar(false, e.get(i));
            }

            i++;
            preguntar(i);
        }
    }

    // Evaluaciones

    public void Evaluar1() {
        LinkedList<Enfermedad> enfermedades = new LinkedList<>();
        LinkedList<String> nombreEnf = new LinkedList<>();
        Datos.enfermedadesPrimerEtapa(enfermedades, nombreEnf);
        int a;
        int mayor = 0;
        posMayor = -1;
        for (int i = 0; i < enfermedades.size(); i++) {
            a = A.valoracion(enfermedades.get(i));
            posMayor = (a > mayor) ? i : posMayor;
            mayor = (a > mayor) ? a : mayor;
        }

        cargarDatosSegundaEtapa();
    }

    public void Evaluar2() {
        cargarEnfermedades();

        int a;
        int mayor = 0;
        posMayor = -1;
        int posEnfermedad=0;
        for (int i = 0; i < enfermedades.size(); i++) {
            a = A.valoracion(enfermedades.get(i));
            if (a>mayor) {
                posMayor=i;
                posEnfermedad=i;
            }
            mayor = (a > mayor) ? a : mayor;
        }
        float porcentaje = mayor/enfermedades.get(posEnfermedad).sumatoriaPesos()*100;

        darDiagnostico(nombreEnf.get(posMayor), Float.toString(porcentaje));
    }

    public void darDiagnostico(String diagnostico, String percentage) {
        Intent intent = new Intent(this, FinalResult.class);
        intent.putExtra("diagnostico", diagnostico);
        intent.putExtra("porcentaje", percentage);
        startActivity(intent);
    }
}