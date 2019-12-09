package emreusta.com.bottomnavigationornek;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_nav);

        getFragmentManager().beginTransaction().add(R.id.fragment_tutucu, new BirinciFragment()).commit();

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment fragment = null;

                if (menuItem.getItemId() == R.id.action_profil) {
                    fragment = new BirinciFragment();
                } else if (menuItem.getItemId() == R.id.action_work) {
                    fragment = new IkinciFragment();
                } else if (menuItem.getItemId() == R.id.action_shop) {
                    fragment = new UcuncuFragment();
                }

                getFragmentManager().beginTransaction().replace(R.id.fragment_tutucu, fragment).commit();

                return true;
            }
        });
    }
}
