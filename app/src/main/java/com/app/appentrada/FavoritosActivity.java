package com.app.appentrada;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.appentrada.adaptador.AdaptadorFavoritos;
import com.app.appentrada.dao.MySqlConcierto;
import com.app.appentrada.dao.MySqlFavoritos;
import com.app.appentrada.entidad.Concierto;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private AdaptadorFavoritos adapter;
    private ListView ltsConcierto;

    private MySqlConcierto daoConcierto  = new MySqlConcierto(this);
    private MySqlFavoritos daoFavorito = new MySqlFavoritos(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        ltsConcierto = (ListView) findViewById(R.id.lstFavoritos_Favoritos);
        ltsConcierto.setOnItemClickListener(this);
        cargarDatos();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    void cargarDatos(){
        ArrayList<Concierto> lista = daoConcierto.listarConcierto();
        adapter = new AdaptadorFavoritos(lista,this);
        ltsConcierto.setAdapter(adapter);
    }
}
