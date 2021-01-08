package com.example.listadepeliculas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ListaPeliculasAdapter extends RecyclerView.Adapter<ListaPeliculasAdapter.ListaPeliculasViewHolder> {

    private static List<Pelicula> listaPeliculas;
    private Context context;

    public ListaPeliculasAdapter(List<Pelicula> peliculas, Context context) {
        this.listaPeliculas = peliculas;
        this.context = context;
    }

    @NonNull
    @Override
    public ListaPeliculasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View peliculasItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movies, parent, false);
        return new ListaPeliculasViewHolder(peliculasItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPeliculasViewHolder holder, int position) {
        Pelicula pelicula = listaPeliculas.get(position);

        holder.tvNombre.setText(pelicula.getPeliculaNombre());
        holder.tvGenero.setText(pelicula.getPeliculaGenero());


        String url = listaPeliculas.get(position).getPeliculaImagen();

        Glide.with(holder.itemView.getContext())
                .load(url)
                .apply(new RequestOptions().override(450, 400))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }



    public class ListaPeliculasViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        private TextView tvNombre;
        private TextView tvGenero;

        private ImageButton eliminarPelicula;
        private ImageButton irWebPelicula;

        final ListaPeliculasAdapter peliculasAdapter;

        public ListaPeliculasViewHolder(@NonNull View itemView, ListaPeliculasAdapter adapter) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);

            tvNombre = (TextView) itemView.findViewById(R.id.textViewNombrePelicula);
            tvGenero = (TextView) itemView.findViewById(R.id.textViewGeneroPelicula);


            this.peliculasAdapter = adapter;


            eliminarPelicula = itemView.findViewById(R.id.eliminarPelicula);
            eliminarPelicula.setOnClickListener(v -> {
                int position = getLayoutPosition();

                listaPeliculas.remove(position);

                peliculasAdapter.notifyDataSetChanged();
            });

            irWebPelicula = itemView.findViewById(R.id.irWebPelicula);
            irWebPelicula.setOnClickListener(v -> {
                int position = getLayoutPosition();

                String url = listaPeliculas.get(position).getPeliculaWeb();

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                v.getContext().startActivity(browserIntent);

                peliculasAdapter.notifyDataSetChanged();
            });

            imageView.setOnClickListener(v -> {
                int position = getLayoutPosition();
                int code = 1;


                String nombrePelicula = listaPeliculas.get(position).getPeliculaNombre();
                String generoPelicula = listaPeliculas.get(position).getPeliculaGenero();
                String webPelicula = listaPeliculas.get(position).getPeliculaWeb();
                String imagenPelicula = listaPeliculas.get(position).getPeliculaImagen();


                Intent intent = new Intent(v.getContext(), SecondActivity.class);

                intent.putExtra("nombrePelicula", nombrePelicula);
                intent.putExtra("generoPelicula", generoPelicula);
                intent.putExtra("webPelicula", webPelicula);
                intent.putExtra("imagenPelicula", imagenPelicula);
                intent.putExtra("position", position);

                ((Activity) v.getContext()).startActivityForResult(intent, code);
                // v.getContext().startActivity(intent);

            });
        }
    }
}