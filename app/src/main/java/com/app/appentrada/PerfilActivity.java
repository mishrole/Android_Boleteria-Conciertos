package com.app.appentrada;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.appentrada.dao.MySqlUsuario;
import com.app.appentrada.entidad.Usuario;

public class PerfilActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;

    EditText edtNickname, edtPassword, edtNombre, edtApellidos, edtCorreo, edtDni;
    Button btnGuardar;

    MySqlUsuario daoUsuario = new MySqlUsuario(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        toolbar = (Toolbar) findViewById(R.id.toolbarPersonalizado);
        setSupportActionBar(toolbar);

        edtNickname = (EditText) findViewById(R.id.edtNickname_Perfil);
        edtPassword = (EditText) findViewById(R.id.edtPassword_Perfil);
        edtNombre = (EditText) findViewById(R.id.edtNombre_Perfil);
        edtApellidos = (EditText) findViewById(R.id.edtApellidos_Perfil);
        edtCorreo = (EditText) findViewById(R.id.edtCorreo_Perfil);
        edtDni = (EditText) findViewById(R.id.edtDni_Perfil);
        btnGuardar = (Button) findViewById(R.id.btnGuardar_Perfil);
        btnGuardar.setOnClickListener(this);

        edtNickname.setText(""+daoUsuario.objetoUsuario.getNickname());
        edtPassword.setText(""+daoUsuario.objetoUsuario.getContrasena());
        edtNombre.setText(""+daoUsuario.objetoUsuario.getNombre());
        edtApellidos.setText(""+daoUsuario.objetoUsuario.getApellidos());
        edtCorreo.setText(""+daoUsuario.objetoUsuario.getCorreo());
        edtDni.setText(""+daoUsuario.objetoUsuario.getDni());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.opcion1) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.opcion2) {
            Intent intent = new Intent(this, PerfilActivity.class);
            startActivity(intent);
        } else if (id == R.id.opcion3) {
            Toast.makeText(this, "OPCION 3", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.opcion4) {
            Toast.makeText(this, "OPCION 4", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.opcion5) {
            Toast.makeText(this, "OPCION 5", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.opcion6) {
            Toast.makeText(this, "OPCION 6", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.opcion7) {
            Intent intent = new Intent(this, IniciarSesionActivity.class);
            startActivity(intent);
        }

        return true;
    }

    @Override
    public void onClick(View v) {

    }
}
