package com.app.appentrada.adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.appentrada.DetalleEventoActivity;
import com.app.appentrada.R;
import com.app.appentrada.entidad.Concierto;

import java.util.List;

public class CardViewAdaptador extends RecyclerView.Adapter<CardViewAdaptador.ViewHolder>{

    private LayoutInflater layoutInflador;
    private List<Concierto> data;

    public CardViewAdaptador(Context context, List<Concierto> data){
        this.layoutInflador = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = layoutInflador.inflate(R.layout.evento_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int i) {
        String evento = data.get(i).getNombre();
        String artista = data.get(i).getArtista();
        String fecha = data.get(i).getFecha();
        viewholder.tvEvento.setText(evento);
        viewholder.tvArtista.setText(artista);
        viewholder.tvFecha.setText(fecha);

        //Eventos
        viewholder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //Contexto
        Context context;

        TextView tvEvento, tvArtista, tvFecha;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            tvEvento = itemView.findViewById(R.id.tvNombre_cardView);
            tvArtista = itemView.findViewById(R.id.tvArtista_cardView);
            tvFecha = itemView.findViewById(R.id.tvFecha_cardView);

            linearLayout = itemView.findViewById(R.id.linearCardView);
        }

        void setOnClickListeners(){
            linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(view.getId()== R.id.linearCardView){
                Intent intent = new Intent(context, DetalleEventoActivity.class);
                //pasar los datos con la activity
                intent.putExtra("nomConcierto", tvEvento.getText());
                intent.putExtra("artista", tvArtista.getText());
                intent.putExtra("fecha", tvFecha.getText());
                context.startActivity(intent);
            }
        }
    }


}
