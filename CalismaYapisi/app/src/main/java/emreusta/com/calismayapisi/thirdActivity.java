package emreusta.com.calismayapisi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class thirdActivity extends AppCompatActivity {
    TextView textAktar;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textAktar = findViewById(R.id.textAktar);

        String gelenBilgi = getIntent().getStringExtra("Bilgi");
        textAktar.setText(gelenBilgi);

        button = findViewById(R.id.buton4Git);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(thirdActivity.this,forthActivity.class);
                startActivity(i);
            }
        });
    }
}
