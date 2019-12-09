package emreusta.com.firebaseornek;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class FirebaseOrnegi extends AppCompatActivity {

    EditText input_ad,input_email;
    ProgressBar circularProgressBar;
    ListView lst_data;
    Toolbar toolbar;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference listeVeri;

    private List<Kullanici> list_kullanicilar = new ArrayList<>();

    private Kullanici seciliKullanici; //ListView'da bir kullanıcı tıklandığında tutacak.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_ornegi);

        toolbar =  findViewById(R.id.toolbar_menu);
        toolbar.setTitle("Firebase Örneği");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        input_ad = findViewById(R.id.name);
        input_email = findViewById(R.id.email);
        lst_data = findViewById(R.id.list_data);
        circularProgressBar = findViewById(R.id.circular_progress);

        //Firebase Kodları

        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        listeVeri = firebaseDatabase.getReference();

        //Progress

        circularProgressBar.setVisibility(View.VISIBLE);
        lst_data.setVisibility(View.INVISIBLE);

        lst_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Kullanici listedekiKullanici = (Kullanici) parent.getItemAtPosition(position);
                seciliKullanici = listedekiKullanici;
                input_ad.setText(listedekiKullanici.getAd());
                input_email.setText(listedekiKullanici.getEmail());
            }
        });


        //Firebase Listener

        listeVeri.child("kullanicilar").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(list_kullanicilar.size()>0){
                    list_kullanicilar.clear();

                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){

                        Kullanici kullanici = postSnapshot.getValue(Kullanici.class);
                        list_kullanicilar.add(kullanici);
                    }

                    ListViewAdapter adapter = new ListViewAdapter(FirebaseOrnegi.this,list_kullanicilar);
                    lst_data.setAdapter(adapter);

                    circularProgressBar.setVisibility(View.INVISIBLE);
                    lst_data.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu_firebase,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menu_ekle){
            kullaniciEkle();
        }

        else if(item.getItemId() == R.id.menu_guncelle){
            kullaniciGuncelle();
        }
        else if(item.getItemId() == R.id.menu_sil){

            kullaniciSil(seciliKullanici);
        }

        return true;
    }

    private void kullaniciSil(Kullanici seciliKullanici) {

        //Silme Kodları

        listeVeri.child("kullanicilar").child(seciliKullanici.getUid()).removeValue();
        kontrolTemizle();

    }


    private void kullaniciGuncelle() {

        //Güncelleme kodları

        Kullanici kullanici = new Kullanici(seciliKullanici.getUid(),input_ad.getText().toString(),input_email.getText().toString());
        listeVeri.child("kullanicilar").child(kullanici.getUid()).child("ad").setValue(kullanici.getAd());
        listeVeri.child("kullanicilar").child(kullanici.getUid()).child("email").setValue(kullanici.getEmail());
        kontrolTemizle();


    }

    private void kullaniciEkle() {

        //Kullanıcı Ekleme Kod Kısmı

        Kullanici kullanici = new Kullanici(UUID.randomUUID().toString(),input_ad.getText().toString(),input_email.getText().toString());

        //Veritabanına gönderme

        listeVeri.child("kullanicilar").child(kullanici.getUid()).setValue(kullanici);

        kontrolTemizle();
    }

    private void kontrolTemizle() {
        input_ad.setText("");
        input_email.setText("");
    }
}
