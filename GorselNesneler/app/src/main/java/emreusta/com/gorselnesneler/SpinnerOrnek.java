 package emreusta.com.gorselnesneler;

 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;
 import android.widget.AdapterView;
 import android.widget.ArrayAdapter;
 import android.widget.Button;
 import android.widget.Spinner;
 import android.widget.TextView;
 import android.widget.Toast;

 import java.util.ArrayList;

 public class SpinnerOrnek extends AppCompatActivity {

    private Button buttonGoster;
    private TextView textGoster;
    private Spinner spinner;
    private ArrayList<String> veriler = new ArrayList<>();
        private ArrayAdapter<String> veriAdaptoru;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_ornek);


        spinner = findViewById(R.id.spinner);
        buttonGoster = findViewById(R.id.buttonGoster);
        textGoster = findViewById(R.id.textGoster);


        veriler.add("Galatasaray");
        veriler.add("Fenerbahçe");
        veriler.add("Beşiktaş");
        veriler.add("Trabzonspor");
        veriler.add("Kayserispor");
        veriler.add("Malatyaspor");
        veriler.add("Sivasspor");
        veriler.add("Konyaspor");
        veriler.add("Rizespor");
        veriler.add("Bursaspor");

        veriAdaptoru = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,android.R.id.text1,veriler);
        spinner.setAdapter(veriAdaptoru);


        buttonGoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alinanVeri = spinner.getSelectedItem().toString();
                textGoster.setText(alinanVeri);
                Toast.makeText(getApplicationContext(),"Alınan Veri : " +alinanVeri,Toast.LENGTH_SHORT).show();

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String alinan = veriler.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
