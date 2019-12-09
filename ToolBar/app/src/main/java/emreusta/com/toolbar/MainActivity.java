package emreusta.com.toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar2);

        toolbar.setTitle("Kütüphanem Nerede?");
        toolbar.setSubtitle("Burada");
        toolbar.setLogo(R.drawable.ic_menu_black_24dp);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);


        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        MenuItem item = menu.findItem(R.id.action_ara);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_ekle:
                Toast.makeText(getApplicationContext(),"Ekle Tıklandı",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_ara:
                Toast.makeText(getApplicationContext(),"Sil Tıklandı",Toast.LENGTH_SHORT).show();
                return  true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    public boolean onQueryTextSubmit(String s) {

        Log.e("TextSubmit",s);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("TextChange",newText);
        return true;
    }
}
