package emreusta.com.firebaseexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;


public class FileStorageExample extends AppCompatActivity {

    Button buttonDownload;
    ImageView imageGelen;
    FirebaseStorage storage =FirebaseStorage.getInstance();
    StorageReference storageReference=storage.getReference();
    final File localFile = File.createTempFile("images","png");
    public FileStorageExample() throws IOException{

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage_example);
        buttonDownload = findViewById(R.id.buttonDownload);
        imageGelen = findViewById(R.id.imageGelen);

        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StorageReference indir = storageReference.child("orhankemal.png");
                indir.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                        imageGelen.setImageBitmap(bitmap);
                    }
                });
            }
        });







    }



}
