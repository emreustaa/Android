package emreusta.com.recyclerviewcardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);

        rv.setHasFixedSize(true);
        //rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));

        ArrayList<String>ulkeler = new ArrayList<>();

        ulkeler.add("Türkiye");
        ulkeler.add("Almanya");
        ulkeler.add("Fransa");
        ulkeler.add("İtalya");
        ulkeler.add("Hollanda");
        ulkeler.add("İngiltere");

        mAdapter = new MyAdapter(this,ulkeler);
        rv.setAdapter(mAdapter);


    }
}
