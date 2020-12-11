package com.app.appentrada.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.appentrada.R;
import com.app.appentrada.entidad.Concierto;

import java.util.ArrayList;

public class AdaptadorFavoritos extends BaseAdapter {
    private ArrayList<Concierto> lista;
    private Context context;

    public AdaptadorFavoritos(ArrayList<Concierto> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row;
        TextView tvCodigo,tvNombre,tvArtista;

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        row=inflater.inflate(R.layout.activity_datafavoritos,viewGroup,false);
        tvCodigo=row.findViewById(R.id.tvCodConcierto_Favoritos);
        tvNombre=row.findViewById(R.id.tvNombreConc_Favoritos);
        tvArtista=row.findViewById(R.id.tvArtista_Favoritos);
        tvCodigo.setText(""+lista.get(i).getCodConcierto());
        tvNombre.setText(lista.get(i).getNombre());
        tvArtista.setText(lista.get(i).getArtista());

        return row;
    }
}
