package emreusta.com.gorselnesneler;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class ResimVideoOrnek extends AppCompatActivity {
    private Button buttonDegistir,buttonBasla,buttonDurdur,buttonDevamEt;
    private ImageView imageView;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resim_video_ornek);

        buttonBasla = findViewById(R.id.buttonBasla);
        buttonDegistir= findViewById(R.id.buttonDegistir);
        buttonDurdur = findViewById(R.id.buttonDurdur);
        buttonDevamEt = findViewById(R.id.buttonDevam);
        imageView = findViewById(R.id.imageView);
        videoView = findViewById(R.id.videoView);

        buttonDegistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.fblogo);
            }
        });
        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri adres = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.istiklalmarsi);
                videoView.setVideoURI(adres);
                videoView.start();
            }
        });


        buttonDurdur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.pause();

            }
        });
    buttonDevamEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.start();
            }
        });

    }
}
