package com.example.listadepeliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        recogerDatos();
    }

    public void recogerDatos() {
        Intent intent = getIntent();

        String nombrePelicula = intent.getStringExtra("nombrePelicula");
        EditText nombrePeliculaTexto = findViewById(R.id.editTextNombrePelicula);
        nombrePeliculaTexto.setText(nombrePelicula);

        String generoPelicula = intent.getStringExtra("generoPelicula");
        EditText generoPeliculaTexto = findViewById(R.id.editTextGeneroPelicula);
        generoPeliculaTexto.setText(generoPelicula);

        String webPelicula = intent.getStringExtra("webPelicula");
        EditText webPeliculaTexto = findViewById(R.id.editTextURLIMDB);
        webPeliculaTexto.setText(webPelicula);

        String imagenPelicula = intent.getStringExtra("imagenPelicula");
        EditText imagenPeliculaTexto = findViewById(R.id.editTextURLImagen);
        imagenPeliculaTexto.setText(imagenPelicula);


    }


    public void submit(View view) {
        Intent intent = getIntent();

        EditText nombrePeliculaTexto = findViewById(R.id.editTextNombrePelicula);
        String nombrePelicula = nombrePeliculaTexto.getText().toString();
        intent.putExtra("nuevoNombrePelicula", nombrePelicula);

        EditText generoPeliculaTexto = findViewById(R.id.editTextGeneroPelicula);
        String generoPelicula = generoPeliculaTexto.getText().toString();
        intent.putExtra("nuevoGeneroPelicula", generoPelicula);

        EditText webPeliculaTexto = findViewById(R.id.editTextURLIMDB);
        String webPelicula = webPeliculaTexto.getText().toString();
        intent.putExtra("nuevoURLWebPelicula", webPelicula);

        EditText imagenPeliculaTexto = findViewById(R.id.editTextURLImagen);
        String imagenPelicula = imagenPeliculaTexto.getText().toString();
        intent.putExtra("nuevoURLImagenPelicula", imagenPelicula);

        int position = intent.getIntExtra("position", -1);
        intent.putExtra("position", position);

        setResult(RESULT_OK, intent);
        finish();

    }
}