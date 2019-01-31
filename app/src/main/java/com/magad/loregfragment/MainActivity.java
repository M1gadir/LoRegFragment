package com.magad.loregfragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.magad.loregfragment.fragmnet.LoginFragment;

public class MainActivity extends AppCompatActivity {

   public static FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.layar, new LoginFragment())
                .addToBackStack("")
                .commit();
    }
}
