package com.appsmoviles.u2primerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IvaActivity extends AppCompatActivity {

    EditText etCosto;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iva);

        //Instanciar
        etCosto = findViewById(R.id.et_costo);
        btnCalcular = findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validar contenido et
                if(etCosto.getText().toString().isEmpty()) {
                    Toast.makeText(getApplication(), "Precio obligatorio", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        Double costo = Double.parseDouble(etCosto.getText().toString());
                        Double iva = (costo*0.16);
                        Double costoOriginal = costo - iva;

                        //Guardar valores para envio
                        Bundle data = new Bundle();
                        data.putDouble("costo", costo);
                        data.putDouble("iva", iva);
                        data.putDouble("costoOriginal", costoOriginal);

                        //Ir a actividad
                        Intent intent = new Intent(getApplicationContext(), ResultadoIvaActivity.class);
                        intent.putExtra("data", data);
                        startActivity(intent);
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplication(), "Precio invalido", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}