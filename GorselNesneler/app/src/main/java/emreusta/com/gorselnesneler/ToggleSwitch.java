package emreusta.com.gorselnesneler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleSwitch extends AppCompatActivity {

    private Button buttonYap;
    private ToggleButton toggleButton;
    private Switch mSwitch;
    private TextView textView;
    private TextView textToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_switch);

        buttonYap = findViewById(R.id.buttonYap);
        toggleButton = findViewById(R.id.toggleButton2);
        mSwitch = findViewById(R.id.mSwitch);
        textView=findViewById(R.id.textView);
        textToggle=findViewById(R.id.textView2);

        buttonYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean switchDurum=mSwitch.isChecked();
                boolean toggleDurum= toggleButton.isChecked();

                Toast.makeText(ToggleSwitch.this,"SD : "+ switchDurum + "TD : "+toggleDurum,Toast.LENGTH_SHORT).show();
            }
        });
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                textView.setText(String.valueOf(isChecked));
            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                textToggle.setText(String.valueOf(isChecked));
            }
        });
    }
}
