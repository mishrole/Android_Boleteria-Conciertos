package com.app.appentrada.adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.app.appentrada.DetalleEventoActivity;
import com.app.appentrada.R;
import com.app.appentrada.entidad.Concierto;

import java.util.ArrayList;
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
        List<Integer> listaimagenes = new ArrayList<>();
        listaimagenes.add(R.drawable.i1);
        listaimagenes.add(R.drawable.i2);
        listaimagenes.add(R.drawable.i3);
        listaimagenes.add(R.drawable.i4);
        
        int codigo = data.get(i).getCodConcierto();
        String evento = data.get(i).getNombre();
        String artista = data.get(i).getArtista();
        String fecha = data.get(i).getFecha();
        String descripcion = data.get(i).getDescrip();
        int idLocal = data.get(i).getCodLocal();
        int foto = data.get(i).getFoto();

        viewholder.codConcierto = codigo;
        viewholder.tvEvento.setText(evento);
        viewholder.tvArtista.setText(artista);
        viewholder.tvFecha.setText(fecha);
        viewholder.descrip = descripcion;
        viewholder.codLocal = idLocal;
        viewholder.foto = ""+foto;
        viewholder.imvImagen.setImageResource(listaimagenes.get(i));

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
        ImageView imvImagen;

        int codConcierto, codLocal;
        String descrip, foto;

        Imagenes img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            tvEvento = itemView.findViewById(R.id.tvNombre_cardView);
            tvArtista = itemView.findViewById(R.id.tvArtista_cardView);
            tvFecha = itemView.findViewById(R.id.tvFecha_cardView);
            imvImagen = itemView.findViewById(R.id.imgCardView);
            linearLayout = itemView.findViewById(R.id.linearCardView);

            img = new Imagenes(context);
        }

        void setOnClickListeners(){
            linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(view.getId()== R.id.linearCardView){
                Intent intent = new Intent(context, DetalleEventoActivity.class);
                //pasar los datos con la activity
                intent.putExtra("codConcierto", codConcierto);
                intent.putExtra("nomConcierto", tvEvento.getText());
                intent.putExtra("artista", tvArtista.getText());
                intent.putExtra("fecha", tvFecha.getText());
                intent.putExtra("descripcion", descrip);
                intent.putExtra("codLocal", codLocal);
                intent.putExtra("foto", foto);
                context.startActivity(intent);
            }
        }

        public class Imagenes extends AppCompatActivity{

            Context context;

            public Imagenes(Context c){
                this.context = c;
            }
            public int cargarImagen(String img){
                int id = this.getResources().getIdentifier("i"+img, "drawable", this.getPackageName());
                return id;
            }
        }
    }


}
