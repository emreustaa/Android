package emreusta.com.gorselnesneler;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class DateTimeOrnek extends AppCompatActivity {

    private EditText editTextSaat;
    private EditText editTextTarih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_ornek);

        editTextSaat = findViewById(R.id.editTextSaat);
        editTextTarih = findViewById(R.id.editTextTarih);

        editTextSaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();

                int saat= c.get(Calendar.HOUR_OF_DAY);
                int dakika = c.get(Calendar.MINUTE);

                TimePickerDialog timePicker;

                timePicker = new TimePickerDialog(DateTimeOrnek.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        editTextSaat.setText(hourOfDay+ " : " + minute);
                    }
                },saat,dakika,true);

                timePicker.setTitle("Saat Seçiniz ");
                timePicker.setButton(TimePickerDialog.BUTTON_POSITIVE,"Ayarla",timePicker);
                timePicker.setButton(TimePickerDialog.BUTTON_NEGATIVE,"İptal",timePicker);
                timePicker.show();


            }
        });

        editTextTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();

                int yil = c.get(Calendar.YEAR);
                int ay = c.get(Calendar.MONTH);
                int gun = c.get(Calendar.DAY_OF_MONTH);




                DatePickerDialog datePickerDialog = new DatePickerDialog(DateTimeOrnek.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editTextTarih.setText(dayOfMonth+ " : " + month + " : " + year);
                    }
                },yil,ay,gun);

                datePickerDialog.setTitle("Tarih Seçiniz");
                datePickerDialog.setButton(DatePickerDialog.BUTTON_POSITIVE,"Ayarla",datePickerDialog);
                datePickerDialog.setButton(DatePickerDialog.BUTTON_NEGATIVE,"İptal",datePickerDialog);
                datePickerDialog.show();
            }
        });
    }
}
