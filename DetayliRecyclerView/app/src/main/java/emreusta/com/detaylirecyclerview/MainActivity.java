package emreusta.com.detaylirecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        private RecyclerView rv;
        private ArrayList<Filmler> filmlerArrayList;
        private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        Filmler f1 = new Filmler("Django",15.99,"django");
        Filmler f2 = new Filmler("Bir Zamanlar Anadoluda",7.99,"birzamanlaranadoluda");
        Filmler f3 = new Filmler("Inception",6.99,"inception");
        Filmler f4 = new Filmler("Interstellar",16.99,"interstellar");
        Filmler f5 = new Filmler("The Hataful Eight",15.00,"thehatefuleight");
        Filmler f6 = new Filmler("The Pianist",11.99,"thepianist");

        filmlerArrayList = new ArrayList<>();
        filmlerArrayList.add(f1);
        filmlerArrayList.add(f2);
        filmlerArrayList.add(f3);
        filmlerArrayList.add(f4);
        filmlerArrayList.add(f5);
        filmlerArrayList.add(f6);

        adapter = new MyAdapter(this,filmlerArrayList);

        rv.setAdapter(adapter);

    }
}
