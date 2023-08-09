package com.example.barnavexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.barnavexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int homeId= R.id.iconHome;
        int deleteId= R.id.iconDelete;
        int downloadId= R.id.iconDownload;
        binding.bottonNav.setOnItemSelectedListener(item -> {
            if(item.getItemId()==homeId){
                replaceFragment(new HomeFragment());
            } else if (item.getItemId()==deleteId){
                replaceFragment(new DeleteFragment());
            }else if (item.getItemId()==downloadId){
                replaceFragment(new DownloadFragment());
            }
             return true;
        });
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        transaction.replace(R.id.botton_nav_frame,fragment);
        transaction.commit();
    }



}