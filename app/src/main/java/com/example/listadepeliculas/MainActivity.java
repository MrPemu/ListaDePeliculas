package com.example.listadepeliculas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    private RecyclerView rvListaPeliculas;
    private RecyclerView.Adapter adapter;
    private List<Pelicula> peliculas;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initValues();
    }

    private void initViews() {
        rvListaPeliculas = findViewById(R.id.rvLista);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvListaPeliculas.setLayoutManager(manager);

        peliculas = getPeliculas();
        adapter = new ListaPeliculasAdapter(peliculas, context);
        rvListaPeliculas.setAdapter(adapter);
    }




    private List<Pelicula> getPeliculas() {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        peliculas.add(new Pelicula("Blade Runner", "Sci-Fi", "https://m.media-amazon.com/images/M/MV5BNzQzMzJhZTEtOWM4NS00MTdhLTg0YjgtMjM4MDRkZjUwZDBlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg", "https://www.imdb.com/title/tt0083658/?ref_=fn_al_tt_1"));
        peliculas.add(new Pelicula("El club de los poetas muertos", "Drama", "https://m.media-amazon.com/images/M/MV5BOGYwYWNjMzgtNGU4ZC00NWQ2LWEwZjUtMzE1Zjc3NjY3YTU1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_UX182_CR0,0,182,268_AL_.jpg", "https://www.imdb.com/title/tt0097165/?ref_=nv_sr_srsg_0"));
        peliculas.add(new Pelicula("La vida de Brian", "Comedia", "https://m.media-amazon.com/images/M/MV5BMzAwNjU1OTktYjY3Mi00NDY5LWFlZWUtZjhjNGE0OTkwZDkwXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_UX182_CR0,0,182,268_AL_.jpg", "https://www.imdb.com/title/tt0079470/?ref_=fn_al_tt_1"));
        peliculas.add(new Pelicula("Rambo", "Acción", "https://m.media-amazon.com/images/M/MV5BODBmOWU2YWMtZGUzZi00YzRhLWJjNDAtYTUwNWVkNDcyZmU5XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_UX182_CR0,0,182,268_AL_.jpg", "https://www.imdb.com/title/tt0083944/?ref_=fn_al_tt_1"));
        peliculas.add(new Pelicula("Mamma Mia!", "Romance", "https://m.media-amazon.com/images/M/MV5BMTA2MDU0MjM0MzReQTJeQWpwZ15BbWU3MDYwNzgwNzE@._V1_UX182_CR0,0,182,268_AL_.jpg", "https://www.imdb.com/title/tt0795421/?ref_=fn_al_tt_1"));
        return peliculas;
    }

    public void add(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        int position = 2;
        intent.putExtra("position", 2);
        startActivityForResult(intent, position);
    }



    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK) {
            String nuevoNombrePelicula = data.getStringExtra("nuevoNombrePelicula");
            String nuevoGeneroPelicula = data.getStringExtra("nuevoGeneroPelicula");
            String nuevoURLWebPelicula = data.getStringExtra("nuevoURLWebPelicula");
            String nuevoURLImagenPelicula = data.getStringExtra("nuevoURLImagenPelicula");

            peliculas.add(new Pelicula(nuevoNombrePelicula, nuevoGeneroPelicula, nuevoURLImagenPelicula, nuevoURLWebPelicula));
            adapter.notifyDataSetChanged();
        }

        else if (requestCode == 1 && resultCode == RESULT_OK) {
            String nuevoNombrePelicula = data.getStringExtra("nuevoNombrePelicula");
            String nuevoGeneroPelicula = data.getStringExtra("nuevoGeneroPelicula");
            String nuevoURLWebPelicula = data.getStringExtra("nuevoURLWebPelicula");
            String nuevoURLImagenPelicula = data.getStringExtra("nuevoURLImagenPelicula");
            int position = data.getIntExtra("position", -1);

            peliculas.set(position,new Pelicula(nuevoNombrePelicula, nuevoGeneroPelicula, nuevoURLImagenPelicula, nuevoURLWebPelicula));
            adapter.notifyItemChanged(position);
        }
    }
}