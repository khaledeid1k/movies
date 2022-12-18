package com.example.movies;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.movies.fragment.Favoritrs.favorites;
import com.example.movies.fragment.Rack.refresh.Ranck;
import com.example.movies.fragment.explore.Explore;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView =findViewById(R.id.mainBottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        
    }
    private  BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment  seletetfragment =null;
                    switch (item.getItemId()){
                        case R.id.Explore_page:
                        seletetfragment=new Explore();
                            break;
                        case R.id.rank_page:
                            seletetfragment=new Ranck();
                            break;
                        case R.id.Favorite_page:
                            seletetfragment=new favorites();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,seletetfragment)
                            .commit();
                    return true;
                }
            };
}