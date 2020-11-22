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

        ingresarDatos();
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
            else
                mensaje("No se encontro usuario");
        }
        else{
            Intent intent = new Intent(this, RegistroActivity.class);
            startActivity(intent);
        }
    }

    void ingresarDatos(){
        int salida;
        TipoUsuario bean = new TipoUsuario();
        bean.setUsuario("Cliente");
        salida = daoTipoUsuario.adicionarTipoUsuario(bean);
        bean = new TipoUsuario();
        bean.setUsuario("Administrador");
        salida = daoTipoUsuario.adicionarTipoUsuario(bean);

        Usuario bean1 = new Usuario();
        bean1.setNickname("arturo");
        bean1.setContrasena("123456");
        bean1.setNombre("Arturo");
        bean1.setApellidos("Carbajal");
        bean1.setCorreo("arturo@gmail.com");
        bean1.setDni("12345678");
        bean1.setTipo(2);
        salida = daoUsuario.adicionarUsuario(bean1);
        bean1 = new Usuario();
        bean1.setNickname("gustavo");
        bean1.setContrasena("123456");
        bean1.setNombre("Gustavo");
        bean1.setApellidos("Teropa");
        bean1.setCorreo("gustavo@gmail.com");
        bean1.setDni("12345678");
        bean1.setTipo(1);
        salida = daoUsuario.adicionarUsuario(bean1);
        bean1 = new Usuario();
        bean1.setNickname("enrique");
        bean1.setContrasena("123456");
        bean1.setNombre("Enrique");
        bean1.setApellidos("Soto");
        bean1.setCorreo("enrique@gmail.com");
        bean1.setDni("12345678");
        bean1.setTipo(1);
        salida = daoUsuario.adicionarUsuario(bean1);

        Zona bean2 = new Zona();
        bean2.setNombre("VIP");
        bean2.setPrecio(500.0);
        salida = daoZona.adicionarZona(bean2);
        bean2 = new Zona();
        bean2.setNombre("General");
        bean2.setPrecio(350.0);
        salida = daoZona.adicionarZona(bean2);
        bean2 = new Zona();
        bean2.setNombre("Tribuna");
        bean2.setPrecio(120.0);
        salida = daoZona.adicionarZona(bean2);

        Local bean3 = new Local();
        bean3.setNombre("Estadio Nacional");
        bean3.setDireccion("Calle Jose Diaz, Cercado de Lima");
        salida = daoLocal.adicionarLocal(bean3);
        bean3 = new Local();
        bean3.setNombre("Estadio Monumental");
        bean3.setDireccion("Ate");
        salida = daoLocal.adicionarLocal(bean3);
        bean3 = new Local();
        bean3.setNombre("Jockey Club");
        bean3.setDireccion("Santiago de Surco");
        salida = daoLocal.adicionarLocal(bean3);
        bean3 = new Local();
        bean3.setNombre("Estadio San Marcos");
        bean3.setDireccion("Universidad San Marcos");
        salida = daoLocal.adicionarLocal(bean3);

        Concierto bean4 = new Concierto();
        bean4.setNombre("Guns n roses en Lima");
        bean4.setArtista("Guns n Roses");
        bean4.setFecha("2021-10-10");
        bean4.setDescrip("Guns n Roses vuelva a Lima");
        bean4.setCodLocal(1);
        bean4.setFoto(1);
        salida = daoConcierto.adicionarConcierto(bean4);
        bean4 = new Concierto();
        bean4.setNombre("Rolling Stones en Lima");
        bean4.setArtista("Rolling Stones");
        bean4.setFecha("2021-10-09");
        bean4.setDescrip("Rolling Stones vuelve a lima");
        bean4.setCodLocal(2);
        bean4.setFoto(2);
        salida = daoConcierto.adicionarConcierto(bean4);
        if (salida > 0)
            mensaje("Bienvenido");
        else
            mensaje("Hubo un Error");
    }

    void mensaje(String m){
        Toast.makeText(this,m,Toast.LENGTH_LONG).show();
    }
}
