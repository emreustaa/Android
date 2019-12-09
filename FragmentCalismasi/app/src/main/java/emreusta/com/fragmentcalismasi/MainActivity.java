package emreusta.com.fragmentcalismasi;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.birinciFragmentTutucu,new BirinciFragment());
        ft.add(R.id.ikinciFragmentTutucu,new IkıncıFragment());

        ft.commit();

    }
}
