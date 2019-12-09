package emreusta.com.storingdata;
//Apply , yazılan kodların uygulamaya geçmesi için kullanılması gereken komuttur.
//Shared Preferences verilerin tutulmasını sağlar, ilk veri paket ismi , ikinci veri uygulanacak moddur.
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("emreusta.com.storingdata", Context.MODE_PRIVATE);
        int age = 40;

        sharedPreferences.edit().putInt("userAge",age).apply();
        int savedAge = sharedPreferences.getInt("userAge",0);

        System.out.println("Saved Value :" + savedAge);

        age=10;

        sharedPreferences.edit().putInt("userAge",age).apply();

        int savedAge2= sharedPreferences.getInt("userAge",0);
        System.out.println("Saved Changed Value :" + savedAge2);

        sharedPreferences.edit().remove("userAge").apply();

        int savedAge3= sharedPreferences.getInt("userAge",0);
        System.out.println("Saved Least Value :" + savedAge3);
    }
}
