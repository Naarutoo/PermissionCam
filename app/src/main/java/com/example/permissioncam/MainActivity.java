package com.example.permissioncam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mbtnCamera;
    private final int REQUEST_CODE=9;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtnCamera = findViewById(R.id.btnCamera);
        mbtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] permission ={Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this,permission,REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            showtoast("Camera Permission Granted");
        }else {
            showtoast("Camera Permission Denied");
            if(count <1){
                showtoast("Camera Permission Denied");
                String [] permission ={Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this,permission,REQUEST_CODE);
                count++;
            }}

    }

    private void showtoast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}