package ita.om.intentproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
private final int REQUEST_CODE=1;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        imageView =(ImageView)findViewById(R.id.imageView);
    }

    public void onClick(View view) {

        EditText et1 = (EditText) findViewById(R.id.userid);
        EditText et2 = (EditText) findViewById(R.id.password);
        String userid = et1.getText().toString().replace("", "");
        String password = et2.getText().toString().replace("", "");

        if (TextUtils.isEmpty(userid)) {
            Toast.makeText(this, "set userid", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "set password", Toast.LENGTH_SHORT).show();
        }
        if (password.length() < 6) {
            Toast.makeText(this, "set password", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, SecondScreen.class);
            startActivity(intent);
            finish();
        }
    }

    public void opencamera(View view) {
//       Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
//        startActivity(intent);
        Intent imageView= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(imageView,REQUEST_CODE);

    }
   @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
             if (requestCode== REQUEST_CODE && resultCode== RESULT_OK){
                 Bundle extras= data.getExtras();
               Bitmap bitmap=(Bitmap) extras.get("data");
                Bitmap imageBitmap = bitmap.createScaledBitmap(bitmap, 512, 512,true);
                imageView.setImageBitmap(imageBitmap);

             }
}}


