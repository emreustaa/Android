package emreusta.com.intent;
//Ekranlar arası geçiş yapmayı sağlayan kod
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = (TextView) findViewById(R.id.textView2);

        Intent intent = getIntent();

        String received =intent.getStringExtra("input");

        textView.setText(received);


    }
    public void changeScreen(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);

        startActivity(intent);
    }
}
