package emreusta.com.tablayoutornek;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabs = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());


        adapter.FragmentEkle(new BirinciFragment(),"Bir");
        adapter.FragmentEkle(new IkinciFragment(),"İki");
        adapter.FragmentEkle(new UcuncuFragment(),"Üç");

        viewPager.setAdapter(adapter);

        tabs.setupWithViewPager(viewPager);

    }

    class MyAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentListe = new ArrayList<>();
        private final List<String> fragmentBaslikListe = new ArrayList<>();

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentListe.get(position);
        }

        @Override
        public int getCount() {
            return fragmentListe.size();
        }



        public void FragmentEkle(Fragment fragment,String baslik){
            fragmentListe.add(fragment);
            fragmentBaslikListe.add(baslik);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentBaslikListe.get(position);
        }
    }
}
