package emreusta.com.gorselnesneler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RadioCheckOrnek extends AppCompatActivity {

    private CheckBox checkBoxJava,checkBoxC,checkBoxPhp;
    private RadioButton radioButtonGS,radioButtonFB,radioButtonBJK;
    private TextView textViewDil;
    private TextView textViewTakim;
    private Button buttonSonuc;
    private String dilSonuc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_check_ornek);

        checkBoxJava = findViewById(R.id.checkBoxJava);
        checkBoxC = findViewById(R.id.checkBoxC);
        checkBoxPhp = findViewById(R.id.checkBoxPhp);

        radioButtonGS = findViewById(R.id.radioButtonGS);
        radioButtonFB = findViewById(R.id.radioButtonFB);
        radioButtonBJK = findViewById(R.id.radioButtonBJK);

        textViewDil = findViewById(R.id.textViewDilBilgi);
        textViewTakim = findViewById(R.id.textViewTakimBilgi);

        buttonSonuc = findViewById(R.id.buttonSonuc);




        buttonSonuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxJava.isChecked() ){
                    dilSonuc = dilSonuc + " Java ";
                } if(checkBoxC.isChecked()){
                    dilSonuc = dilSonuc + " C# ";
                } if (checkBoxPhp.isChecked()){
                    dilSonuc = dilSonuc + " PHP ";
                }

                Toast.makeText(RadioCheckOrnek.this,dilSonuc,Toast.LENGTH_SHORT).show();
                dilSonuc="";


            }
        });

        radioButtonBJK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    textViewTakim.setText("Beşiktaş Seçildi");
                }
                Log.e("Beşiktaş",String.valueOf(isChecked));
            }
        });
        radioButtonFB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textViewTakim.setText("Fenerbahçe Seçildi");
                }
                Log.e("Fenerbahçe",String.valueOf(isChecked));
            }
        });
        radioButtonGS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    textViewTakim.setText("Galatasaray Seçildi");
                }

                Log.e("Galatasaray",String.valueOf(isChecked));
            }
        });





    }
}
