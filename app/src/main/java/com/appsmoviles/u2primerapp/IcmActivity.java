package com.appsmoviles.u2primerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.appsmoviles.u2primerapp.model.Persona;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IcmActivity extends AppCompatActivity {

    Spinner spNombres;
    CheckBox cbEstatura, cbPeso, cbProcedencia, cbImc;
    RadioGroup rgColores;
    RadioButton rbColorSelect;
    Button btnConsultar;

    //Contenedor personas
    List<Persona> personas = new ArrayList<>();

    ArrayAdapter<Persona> adPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icm);

        //Componentes GUI
        spNombres = findViewById(R.id.sp_nombres);
        cbEstatura = findViewById(R.id.cb_estatura);
        cbPeso = findViewById(R.id.cb_peso);
        cbProcedencia = findViewById(R.id.cb_imc);
        cbImc = findViewById(R.id.cb_imc);
        rgColores = findViewById(R.id.rg_colores);
        btnConsultar = findViewById(R.id.btn_consultar);

        lecturaDatosTxt();

        //Cargar datos en spinner
        //METODO toString en Persona.class: ayuda a acceder solamente al nombre de las personas
        //Se personalizo el layout con que se muestran los items
        adPersonas = new ArrayAdapter<Persona>(this, R.layout.spinner_item, personas);
        //Layout para item seleccionado
        adPersonas.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spNombres.setAdapter(adPersonas);

        //Consultar informacion de item select
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultado = "";
                //Persona seleccionada basado en su posicion de array (aplica a ambos)
                Persona personaSelec = personas.get(spNombres.getSelectedItemPosition());

                //Informacion deseada
                resultado = "Nombre: " + personaSelec.getNombre() + "\n";
                if (cbEstatura.isChecked()) resultado += "Estatura: " + personaSelec.getEstatura() + "\n";
                if (cbPeso.isChecked()) resultado+= "Peso: " + personaSelec.getPeso() + "\n";
                if (cbProcedencia.isChecked()) resultado += "Procedencia: " + personaSelec.getProcedencia() + "\n";
                if (cbImc.isChecked()) resultado += String.format("IMC: %.4f", personaSelec.getImc());

                //Color texto elegido
                String colorTexto = "#000000"; //Default negro
                int selectRadio = rgColores.getCheckedRadioButtonId();
                switch (selectRadio) {
                    case R.id.rb_verde:
                        colorTexto = "#20C3A5";
                        break;
                    case R.id.rb_azul:
                        colorTexto = "#3F51B5";
                        break;
                }

                //Bundle con datos
                Bundle data = new Bundle();
                data.putString("resultado", resultado);
                data.putString("colorTexto", colorTexto);

                //Ir a actividad resultado
                Intent intent = new Intent(getApplicationContext(), ResultadoImcActivity.class);
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });
    }

    public void lecturaDatosTxt() {
        //LECTURA DATOS TXT
        try {
            InputStream flujo = getResources().openRawResource(R.raw.datos);
            InputStreamReader lector = new InputStreamReader(flujo);
            BufferedReader buffer = new BufferedReader(lector);

            //Comprobar que existe una linea cuando menos
            String linea = buffer.readLine();
            while(linea != null) {
                Persona persona = new Persona();
                //Datos de cada persona
                String[] campos = linea.split(":");
                persona.setNombre(campos[0]);
                persona.setEstatura(Double.parseDouble(campos[1]));
                persona.setPeso(Integer.parseInt(campos[2]));
                persona.setProcedencia(campos[3]);
                persona.setImc(persona.getPeso()/(persona.getEstatura()*persona.getEstatura()));

                //Guardar persona
                personas.add(persona);
                linea = buffer.readLine();
            }

            //Cerrar flujos
            buffer.close();
            lector.close();
            flujo.close();
        }catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}