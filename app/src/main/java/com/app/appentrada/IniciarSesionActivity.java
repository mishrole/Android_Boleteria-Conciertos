package com.app.appentrada;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.appentrada.dao.MySqlConcierto;
import com.app.appentrada.dao.MySqlLocal;
import com.app.appentrada.dao.MySqlTipoUsuario;
import com.app.appentrada.dao.MySqlUsuario;
import com.app.appentrada.dao.MySqlZona;
import com.app.appentrada.entidad.Concierto;
import com.app.appentrada.entidad.Local;
import com.app.appentrada.entidad.TipoUsuario;
import com.app.appentrada.entidad.Usuario;
import com.app.appentrada.entidad.Zona;

public class IniciarSesionActivity extends AppCompatActivity implements View.OnClickListener{

    MySqlTipoUsuario daoTipoUsuario = new MySqlTipoUsuario(this);
    MySqlUsuario daoUsuario = new MySqlUsuario(this);
    MySqlZona daoZona = new MySqlZona(this);
    MySqlLocal daoLocal = new MySqlLocal(this);
    MySqlConcierto daoConcierto = new MySqlConcierto(this);

    EditText edtUsusario, edtContraseña;
    Button btnIngresar, btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);

        edtUsusario = (EditText) findViewById(R.id.edtUsuarioInicio);
        edtContraseña =(EditText) findViewById(R.id.edtContrasenaInicio);
        btnIngresar = findViewById(R.id.btnIngresarInicio);
        btnRegistrar = findViewById(R.id.btnRegistrarInicio);
        btnIngresar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == btnIngresar){
            String usuario = edtUsusario.getText().toString();
            String contrasena = edtContraseña.getText().toString();
            int salida = daoUsuario.buscarUsuario(usuario, contrasena);
            if(salida>0){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else {
                mensaje("No se encontro usuario");
            }
        }
        else{
            Intent intent = new Intent(this, RegistroActivity.class);
            startActivity(intent);
        }
    }

    void mensaje(String m){
        Toast.makeText(this,m,Toast.LENGTH_LONG).show();
    }
}
