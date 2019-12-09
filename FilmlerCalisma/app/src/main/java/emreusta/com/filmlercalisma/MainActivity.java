package emreusta.com.filmlercalisma;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import emreusta.com.filmlercalisma.dao.DatabaseCopyHelper;
import emreusta.com.filmlercalisma.dao.Filmlerdao;
import emreusta.com.filmlercalisma.dao.VeritabaniYardimcisi;
import emreusta.com.filmlercalisma.objects.Filmler;

public class MainActivity extends AppCompatActivity {

    private VeritabaniYardimcisi vt = new VeritabaniYardimcisi(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kopyala();

        ArrayList<Filmler> filmlerArrayList = new Filmlerdao().tumFilmler(vt);
        for (Filmler f : filmlerArrayList){

            Log.e("********","*********");
            Log.e("Film id",String.valueOf(f.getFilm_id()));
            Log.e("Film ad",f.getFilm_ad())  ;
            Log.e("Film yıl",String.valueOf(f.getFilm_yil()));
            Log.e("Film resim",f.getFilm_resim());
            Log.e("Film kategori",f.getKategori().getKategori_ad());
            Log.e("Film yonetmen",f.getYonetmen().getYonetmen_adi());


            Log.e("********","*********");

        }

    }
    public void kopyala(){
        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        helper.openDataBase();

    }
}
