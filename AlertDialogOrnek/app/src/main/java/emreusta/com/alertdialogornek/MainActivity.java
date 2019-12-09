package emreusta.com.alertdialogornek;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonNormal,buttonOzel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNormal = findViewById(R.id.buttonNormal);
        buttonOzel = findViewById(R.id.buttonOzel);


        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert =new AlertDialog.Builder(MainActivity.this);

                alert.setIcon(R.drawable.insan);
                alert.setTitle("Uyarı!");
                alert.setMessage("Lütfen dikkatlice Okuyunuz");

                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Kullanıcı Olumlu Dönüş Yaptı",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Kullanıcı Olumsuz Dönüş Yaptı ", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.create().show();

            }
        });

        buttonOzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View tasarim = getLayoutInflater().inflate(R.layout.alert_tasarim,null);

                final EditText editTextAlert = tasarim.findViewById(R.id.editTextAlert);

                AlertDialog.Builder ao = new AlertDialog.Builder(MainActivity.this);
                ao.setTitle("Uyarı!");
                ao.setMessage("Lütfen Dikkatlice Okuyunuz");
                ao.setView(tasarim);


                ao.setPositiveButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getApplicationContext(),"Kullanıcı İptale Tıkladı",Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                    }
                });
                ao.setNegativeButton("Kaydet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), editTextAlert.getText().toString(), Toast.LENGTH_SHORT).show();


                    }
                });
                ao.create().show();
            }
        });
    }
}
