package com.app.appentrada;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.appentrada.dao.MySqlFavoritos;
import com.app.appentrada.dao.MySqlLocal;
import com.app.appentrada.dao.MySqlUsuario;
import com.app.appentrada.entidad.Favoritos;
import com.app.appentrada.entidad.Local;

import java.util.List;

public class DetalleEventoActivity  extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    int codConcierto;
    String foto;
    TextView tvNombreEvento, tvArtista, tvFecha, tvLugar, tvDescripcion;
    CheckBox chkFavorito;
    Button btnComprar;
    ImageView imgImagen;

    private List<Local> listaLocales;
    private MySqlLocal daoLocal = new MySqlLocal(this);
    private MySqlFavoritos daoFavorito = new MySqlFavoritos(this);
    private MySqlUsuario daoUsuario = new MySqlUsuario(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalleevento);

        toolbar = (Toolbar) findViewById(R.id.toolbarPersonalizado);
        setSupportActionBar(toolbar);

        tvNombreEvento = findViewById(R.id.tvNombreEvento_DetalleEvento);
        tvArtista = findViewById(R.id.tvArtista_DetalleEvento);
        tvFecha = findViewById(R.id.tvFecha_DetalleEvento);
        tvLugar = findViewById(R.id.tvLugar_DetalleEvento);
        tvDescripcion = findViewById(R.id.tvDescripcion_DetalleEvento);
        chkFavorito = findViewById(R.id.chkFavorito_DetalleEvento);
        imgImagen = findViewById(R.id.imgDetalle);
        btnComprar = findViewById(R.id.btnComprar_DetalleEvento);
        btnComprar.setOnClickListener(this);
        chkFavorito.setOnClickListener(this);

        cargarDatos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.opcion1){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.opcion2){
            Intent intent = new Intent(this, PerfilActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.opcion3){
            Toast.makeText(this, "OPCION 3", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.opcion4){
            Toast.makeText(this, "OPCION 5", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.opcion5){
            Intent intent = new Intent(this, IniciarSesionActivity.class);
            startActivity(intent);
        }

        return true;
    }

    @Override
    public void onClick(View view) {
        if(view==chkFavorito){
            if(chkFavorito.isChecked()){
                int salida = -1;
                Favoritos fav = new Favoritos();
                fav.setIdFavoritos(codConcierto);
                fav.setIdUsuario(daoUsuario.objetoUsuario.getCodUsuario());
                salida = daoFavorito.adicionarFavoritos(fav);
                if (salida>0){
                    mensaje("Se añadio a favoritos");
                }
            }
            else{
                int salida = -1;
                salida = daoFavorito.eliminarFavoritos(codConcierto, daoUsuario.objetoUsuario.getCodUsuario());
                if (salida>0){
                    mensaje("Se elimino de favoritos");
                }
            }
        }
        if(view == btnComprar){
            Intent intent = new Intent(this, CompraEntradaActivity.class);
            intent.putExtra("codConcierto", codConcierto);
            intent.putExtra("nombreConcierto", tvNombreEvento.getText());
            intent.putExtra("foto", foto);
            startActivity(intent);
        }
    }

    void cargarDatos(){
        listaLocales = daoLocal.listarLocal();

        Bundle datos = this.getIntent().getExtras();
        codConcierto = datos.getInt("codConcierto");
        tvNombreEvento.setText(datos.getString("nomConcierto"));
        tvArtista.setText(datos.getString("artista"));
        tvFecha.setText(datos.getString("fecha"));

        int l = datos.getInt("codLocal")-1;

        tvLugar.setText(listaLocales.get(l).getNombre());
        tvDescripcion.setText(datos.getString("descripcion"));
        foto = datos.getString("foto");

        int id = this.getResources().getIdentifier("i"+foto, "drawable", this.getPackageName());
        imgImagen.setImageResource(id);

        favoritos(codConcierto,daoUsuario.objetoUsuario.getCodUsuario());
    }

    void mensaje(String m){
        Toast.makeText(this,m,Toast.LENGTH_LONG).show();
    }

    void favoritos(int codCon, int codUsu){
        List<Favoritos> listfav= daoFavorito.listarFavoritos(codCon, codUsu);
        if(listfav==null){

        }
        else{
            int ch;
            for(int i=0; i>listfav.size(); i++){
                ch = listfav.get(i).getIdFavoritos();
                if(ch == codConcierto){
                    chkFavorito.setChecked(true);
                }
            }
        }


    }

}
