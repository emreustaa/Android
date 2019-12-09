package emreusta.com.gorselnesneler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListGridSpinOrnek extends AppCompatActivity {

    private GridView listView;
    private ArrayList<String>meyveler = new ArrayList<>();
    private ArrayAdapter <String> veriAdaptoru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_grid_spin_ornek);

        listView = findViewById(R.id.liste);

        meyveler.add("Kiraz");
        meyveler.add("Armut");
        meyveler.add("Muz");
        meyveler.add("Portakal");
        meyveler.add("Mandalina");
        meyveler.add("Erik");
        meyveler.add("Çilek");
        meyveler.add("Nar");

        veriAdaptoru = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,meyveler);
        listView.setAdapter(veriAdaptoru);
    

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                meyveler.get(i);

                Toast.makeText(getApplicationContext(),"Meyve : "+ meyveler.get(i),Toast.LENGTH_SHORT).show();
            }
        });





    }
}
