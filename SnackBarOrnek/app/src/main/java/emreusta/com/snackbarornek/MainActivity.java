package emreusta.com.snackbarornek;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        private Button buttonNormal,buttonFeedBack,buttonOzel;
        private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFeedBack = findViewById(R.id.buttonFeedBack);
        buttonNormal = findViewById(R.id.buttonNormal);
        buttonOzel = findViewById(R.id.buttonOzel);
        constraintLayout = findViewById(R.id.constratintLayout);

        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(constraintLayout,"Merhabalar",Snackbar.LENGTH_SHORT).show();


            }
        });
        buttonFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Mesaj Silinsin mi?",Snackbar.LENGTH_SHORT)
                        .setAction("Evet", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(v,"Mesaj başaryıla silinmiştir",Snackbar.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
        buttonOzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v,"İnternet bağlantısı yok!",Snackbar.LENGTH_SHORT)
                        .setAction("Tekrar Dene", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(v,"İnternet Bağlantısı geldi",Snackbar.LENGTH_SHORT).show();
                            }
                        });

                snackbar.setActionTextColor(Color.RED);

                View view = snackbar.getView();
                TextView  textView = view.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.GREEN);
                snackbar.show();

            }
        });
    }
}
