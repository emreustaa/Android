package emreusta.com.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        resultText = findViewById(R.id.textView);

        resultText.setText("Sonuç");


    }

    public void sum(View view) {

        if (editText.getText().toString().matches("") || editText2.getText().toString().matches("")) {
            resultText.setText("Please Enter Available Number");
        } else {
            int number1 = Integer.parseInt(editText.getText().toString());
            int number2 = Integer.parseInt(editText2.getText().toString());

            int result = number1 + number2;
            resultText.setText("Result = " + result);
        }


    }

    public void deduct(View view) {
        if (editText.getText().toString().matches("") || editText2.getText().toString().matches("")) {
            resultText.setText("Please Enter Available Number");
        } else {
            int number1 = Integer.parseInt(editText.getText().toString());
            int number2 = Integer.parseInt(editText2.getText().toString());

            int result = number1 - number2;
            resultText.setText("Result = " + result);
        }

    }

    public void multiply(View view) {
        if (editText.getText().toString().matches("") || editText2.getText().toString().matches("")) {
            resultText.setText("Please Enter Available Number");
        } else {
            int number1 = Integer.parseInt(editText.getText().toString());
            int number2 = Integer.parseInt(editText2.getText().toString());

            int result = number1 * number2;

            resultText.setText("Result = " + result);
        }

    }


    public void divide(View view) {
        if (editText.getText().toString().matches("") || editText2.getText().toString().matches("")) {
            resultText.setText("Please Enter Available Number");
            int number1 = Integer.parseInt(editText.getText().toString());
            int number2 = Integer.parseInt(editText2.getText().toString());

            int result = number1 / number2;
            resultText.setText("Result = " + result);
        } else {

        }
    }

}
