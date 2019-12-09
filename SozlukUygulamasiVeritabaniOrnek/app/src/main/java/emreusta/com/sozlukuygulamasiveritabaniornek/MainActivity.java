package emreusta.com.sozlukuygulamasiveritabaniornek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  VeritabaniYardimcisi vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vt = new VeritabaniYardimcisi(this);

        /*new Kelimelerdao().kelimeEkle(vt,"door","kapı");
        new Kelimelerdao().kelimeEkle(vt,"window","pencere");
        new Kelimelerdao().kelimeEkle(vt,"sea","deniz");
        new Kelimelerdao().kelimeEkle(vt,"pencil","kalem");
        new Kelimelerdao().kelimeEkle(vt,"computer","bilgisayar");*/

        //new Kelimelerdao().kelimeSil(vt,9);
        //new Kelimelerdao().kelimeGuncelleme(vt,8,"injection","enjeksiyon");

        int sonuc  = new Kelimelerdao().kayitKontrol(vt);
        Log.e("Veri Sayısı ", String.valueOf(sonuc));

        ArrayList<Kelimeler> gelenKelimelerListesi = new Kelimelerdao().tumKelimeler(vt);

        for (Kelimeler k : gelenKelimelerListesi){
            Log.e(String.valueOf(k.getKelime_id()),k.getIngilizce()+" - "+k.getTurkce());

        }

    }
}
