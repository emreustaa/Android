package emreusta.com.optionpopupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonMenu = findViewById(R.id.buttonMenu);

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MainActivity.this,buttonMenu);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu_tasarim,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){


                            case R.id.action_sil:
                                Toast.makeText(getApplicationContext(),"Sil Özelliği Çalıştı",Toast.LENGTH_SHORT).show();
                                return  true;
                            case  R.id.action_duzenle:
                                Toast.makeText(getApplicationContext(),"Düzenle Özelliği Çalıştı",Toast.LENGTH_SHORT).show();
                                return  true;

                                default:
                                    return false;
                        }


                    }
                });
            }
        });

    }
}
