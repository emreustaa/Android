package emreusta.com.detaylirecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FilmDetay extends AppCompatActivity {

    private ImageView film_resim;
    private TextView film_bilgi;
    private  Filmler film;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detay);

        film_resim = findViewById(R.id.film_resim);
        film_bilgi = findViewById(R.id.film_bilgi);

        film = (Filmler)getIntent().getSerializableExtra("nesne");

        film_bilgi.setText(film.getFilm_baslik() + " - " + film.getFilm_fiyat());
        film_resim.setImageResource(getResources().getIdentifier(
                film.getFilm_resim(), "drawable", getPackageName()));


    }
}
