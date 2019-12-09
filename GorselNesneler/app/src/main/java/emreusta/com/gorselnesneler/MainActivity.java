package emreusta.com.gorselnesneler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextVeri;
    TextView textViewGoster;
    Button buttonKaydet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextVeri = findViewById(R.id.editTextVeri);
        textViewGoster = findViewById(R.id.textViewGoster);
        buttonKaydet = findViewById(R.id.buttonKaydet);

        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String girilenVeri= editTextVeri.getText().toString();
                editTextVeri.setText("");
                textViewGoster.setText(girilenVeri);

            }
        });

    }
}
