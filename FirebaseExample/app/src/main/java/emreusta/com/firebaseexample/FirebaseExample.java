package emreusta.com.firebaseexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseExample extends AppCompatActivity {

    EditText edit_veri,edt_veri_goster;
    Button btn_veri_gonder,btn_veri_goster;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mesaj = database.getReference("Mesaj");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_example);

        edit_veri = findViewById(R.id.edt_veri);
        edt_veri_goster = findViewById(R.id.edt_veri_goster);
        btn_veri_gonder = findViewById(R.id.btn_veri_gonder);
        btn_veri_goster = findViewById(R.id.btn_veri_goster);

        btn_veri_gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String veri = edit_veri.getText().toString();
                mesaj.setValue(veri);

            }
        });

        btn_veri_goster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mesaj.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String gelenVeri = dataSnapshot.getValue(String.class);
                        edt_veri_goster.setText(gelenVeri);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
