package com.arjuna.jekardahfight.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.arjuna.jekardahfight.R;

public class DetailActivity extends AppCompatActivity {

    String nama, jabatan, wilayah, alamat, login, telepon;
    TextView txtnama, txtjabatan, txtwilayah, txtalamat, txtlogin;
    Button callbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //TODO get data parse
        nama = getIntent().getStringExtra("nama");
        jabatan = getIntent().getStringExtra("jabatan");
        wilayah = getIntent().getStringExtra("wilayah");
        alamat = getIntent().getStringExtra("alamat");
        login = getIntent().getStringExtra("login");
        telepon = getIntent().getStringExtra("phone");


        txtnama = (TextView) findViewById(R.id.namapetugas);
        txtalamat = (TextView) findViewById(R.id.namaalamat);
        txtjabatan = (TextView) findViewById(R.id.namajabatan);
        txtlogin = (TextView)  findViewById(R.id.namalogin);
        txtwilayah = (TextView) findViewById(R.id.namawilayah);

        ///
        txtnama.setText(nama);
        txtalamat.setText(alamat);
        txtwilayah.setText(wilayah);
        txtlogin.setText(login);
        txtjabatan.setText(jabatan);


        //
        callbutton = (Button) findViewById(R.id.btncall);

        callbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPermissionGranted()) {
                    call_action();
                }
            }
        });


    }
    public void call_action(){
        Intent iCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telepon));
        startActivity(iCall);
    }
    //TODO Check Self Permission
    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                    call_action();
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
