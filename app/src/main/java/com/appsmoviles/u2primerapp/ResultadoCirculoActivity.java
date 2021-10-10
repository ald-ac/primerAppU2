package com.appsmoviles.u2primerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoCirculoActivity extends AppCompatActivity {

    TextView tvArea, tvPerimetro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_circulo);

        //Obtener bundle de la actividad con los datos
        Intent intent = getIntent();
        Bundle data = intent.getBundleExtra("data");
        Double area = data.getDouble("area");
        Double perimetro = data.getDouble("perimetro");

        //Instanciar
        tvArea = findViewById(R.id.tv_area);
        tvPerimetro = findViewById(R.id.tv_perimetro);

        //Asignar resultados
        tvArea.setText(String.format("%.4f", area));
        tvPerimetro.setText(String.format("%.4f", perimetro));
    }
}