package tops.technologies.firebaseimage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import tops.technologies.firebaseimage.Model.User;

public class UploadActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private Button chooseImageBtn;
    private Button uploadBtn;
    private EditText nameEditText;
    private EditText descriptionEditText;
    private ImageView chosenImageView;
    private ProgressBar uploadProgressBar;

    private Uri mImageUri;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    private StorageTask mUploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        chooseImageBtn=findViewById(R.id.chooseimg);
        uploadBtn=findViewById(R.id.uploadimg);
        nameEditText=findViewById(R.id.name);
        descriptionEditText=findViewById(R.id.description);
        chosenImageView=findViewById(R.id.imageView);
        uploadProgressBar=findViewById(R.id.pb);

        mStorageRef= FirebaseStorage.getInstance().getReference("users_uploads");
        mDatabaseRef= FirebaseDatabase.getInstance().getReference("users_uploads");

        chooseImageBtn.setOnClickListener(v -> openFileChooser());
        uploadBtn.setOnClickListener(view -> {
            if (mUploadTask!=null && mUploadTask.isInProgress())
                Toast.makeText(this, "Uploading Image", Toast.LENGTH_SHORT).show();
            else
                uploadFile();
        }
        );

    }

    private void uploadFile() {
        if(mImageUri!=null)
        {
            StorageReference storageReference = mStorageRef.child(System.currentTimeMillis()+".jpg");
            mUploadTask=storageReference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Task<Uri> uriTask = taskSnapshot.getMetadata().getReference().getDownloadUrl();

                    uriTask.addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            String link = uri.toString();
                            User user = new User(nameEditText.getText().toString(),
                            link,
                            descriptionEditText.getText().toString());

                    String UploadID=mDatabaseRef.push().getKey();
                    mDatabaseRef.child(UploadID).setValue(user);
                    openImageActivity();
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(UploadActivity.this, "Upload Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    private void openImageActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null)
        {
            mImageUri = data.getData();
            Picasso.with(this).load(mImageUri).into(chosenImageView);
        }
    }

}