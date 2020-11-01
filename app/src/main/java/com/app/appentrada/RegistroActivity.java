package com.app.appentrada;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtUsuario, edtContrasena, edtNombre, edtApellidos, edtCorreo, edtDni, edtEdad;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edtUsuario = findViewById(R.id.edtUsuarioRegistro);
        edtContrasena = findViewById(R.id.edtContraseñaRegistro);
        edtNombre = findViewById(R.id.edtNombreRegistro);
        edtApellidos = findViewById(R.id.edtApellidosRegistro);
        edtCorreo = findViewById(R.id.edtCorreoRegistro);
        edtDni = findViewById(R.id.edtDniRegistro);
        edtEdad = findViewById(R.id.edtEdadRegistro);
        btnRegistrar = findViewById(R.id.btnRegistrarRegistro);
        btnRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnRegistrar){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
