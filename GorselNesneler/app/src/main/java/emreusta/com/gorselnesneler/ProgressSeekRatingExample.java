package emreusta.com.gorselnesneler;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class ProgressSeekRatingExample extends AppCompatActivity {

    private ProgressBar progressBar;
    private SeekBar slider;
    private RatingBar ratingBar;
    private TextView textViewSlider;
    private TextView textViewRating;
    private Button buttonBasla;
    private Button buttonBitir;


    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_seek_rating_example);

        progressBar = findViewById(R.id.progressBar);
        slider = findViewById(R.id.slider);
        ratingBar = findViewById(R.id.ratingBar);
        textViewSlider = findViewById(R.id.textViewSlider);
        textViewRating = findViewById(R.id.textViewRating);
        buttonBitir = findViewById(R.id.buttonBitir);
        buttonBasla = findViewById(R.id.buttonBasla);




        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
        buttonBitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSlider.setText("Slider : " + String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textViewRating.setText("Rating : " + String.valueOf(rating));
            }
        });

    }


}
