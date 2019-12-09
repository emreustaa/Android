package emreusta.com.calismayapisi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class secondActivity extends AppCompatActivity {

    private Button butonAktar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        butonAktar = findViewById(R.id.buttonAktar);

        butonAktar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(secondActivity.this,thirdActivity.class);
                intent.putExtra("Bilgi","Başarıyla Aktarılmıştır.");
                startActivity(intent);
            }
        });
    }

    /*@Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(secondActivity.this,MainActivity.class);
        startActivity(intent);
    }*/
}
