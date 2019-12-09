package emreusta.com.toastmesaj;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonMesaj,buttonOzel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMesaj = findViewById(R.id.buttonMesaj);
        buttonOzel = findViewById(R.id.buttonOzel);


        buttonMesaj.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Normal Toast Mesaj verilmiştir.",Toast.LENGTH_SHORT).show();
            }
        });

        buttonOzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View tasarim = getLayoutInflater().inflate(R.layout.toast_mesaj_tasarim,null);

                TextView textViewMesaj = tasarim.findViewById(R.id.textViewMesaj);
                textViewMesaj.setText("Merhaba Özel Toast ");

                Toast ozel = new Toast(getApplicationContext());
                ozel.setView(tasarim);
                ozel.setDuration(Toast.LENGTH_SHORT);
                ozel.show();

            }
        });
    }
}
