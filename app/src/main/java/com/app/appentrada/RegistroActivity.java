package com.app.appentrada;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.appentrada.dao.MySqlUsuario;
import com.app.appentrada.entidad.Usuario;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{

    MySqlUsuario daoUsuario = new MySqlUsuario(this);

    EditText edtUsuario, edtContrasena, edtNombre, edtApellidos, edtCorreo, edtDni, edtTipo;
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
        edtTipo = findViewById(R.id.edtTipoRegistro);
        btnRegistrar = findViewById(R.id.btnRegistrarRegistro);
        btnRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnRegistrar){
            Usuario bean = new Usuario();
            bean.setNickname(edtUsuario.getText().toString());
            bean.setContrasena(edtContrasena.getText().toString());
            bean.setNombre(edtNombre.getText().toString());
            bean.setApellidos(edtApellidos.getText().toString());
            bean.setCorreo(edtCorreo.getText().toString());
            bean.setDni(edtDni.getText().toString());
            bean.setTipo(Integer.parseInt(edtTipo.getText().toString()));

            int salida;
            salida = daoUsuario.adicionarUsuario(bean);
            if (salida > 0){
                mensaje("Registro correcto...");
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else
                mensaje("Error en el registro...");

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    void mensaje(String m){
        Toast.makeText(this,m,Toast.LENGTH_LONG).show();
    }
}
