package emreusta.com.detaylirecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CardTasarimTutucu> {

    private Context context;
    private List<Filmler> filmListe;

    public MyAdapter(Context context, List<Filmler> filmListe) {
        this.context = context;
        this.filmListe = filmListe;
    }


        public class CardTasarimTutucu extends RecyclerView.ViewHolder {
            private ImageView film_resim;
            private TextView film_baslik, film_fiyat;
            private Button buttonSepet;

            public CardTasarimTutucu(View view) {
                super(view);

                film_resim = view.findViewById(R.id.film_resim);
                film_baslik = view.findViewById(R.id.film_bilgi);
                film_fiyat = view.findViewById(R.id.film_fiyat);
                buttonSepet = view.findViewById(R.id.buttonSepet);
            }
        }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.film_card_tasarim, viewGroup, false);
        return new CardTasarimTutucu(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardTasarimTutucu cardTasarimTutucu, int i) {

        final Filmler film = filmListe.get(i);

        cardTasarimTutucu.film_baslik.setText(film.getFilm_baslik());
        cardTasarimTutucu.film_fiyat.setText(String.valueOf(film.getFilm_fiyat()));
        cardTasarimTutucu.film_resim.setImageResource(context.getResources().getIdentifier(
                film.getFilm_resim(), "drawable", context.getPackageName()));

        cardTasarimTutucu.buttonSepet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Tıklanan Film : "+ film.getFilm_baslik(),Toast.LENGTH_LONG).show();
            }
        });

        cardTasarimTutucu.film_resim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,FilmDetay.class);
                intent.putExtra("nesne",film);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return filmListe.size();
    }

}

