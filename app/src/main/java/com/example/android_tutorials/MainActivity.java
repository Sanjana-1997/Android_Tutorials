package com.example.android_tutorials;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView bottombar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottombar=findViewById(R.id.bottombar);

      bottombar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              int id=item.getItemId();
              if (id==R.id.home){
                  loadFragment(new HomePageFragment(),false);

              }
              else if (id==R.id.contatus){
                  loadFragment(new Contact_Us_Fragment(),false);
              }
              else{
                  loadFragment(new ProfilePageFragment(),true);
              }
              return true;
          }
      });

    }
    public void loadFragment(Fragment fragment,boolean flag){
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

       if(flag) ft.add(R.id.container,fragment);
       else
           ft.replace(R.id.container,fragment);
           ft.commit();
    }
}