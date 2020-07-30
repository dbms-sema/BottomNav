package com.dbmssema.bottomnav;



import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationview);
        drawerLayout = findViewById(R.id.drawerlayout);
        bottomNavigationView=findViewById(R.id.bottomnavigation);



        setbottomnav();
        settoolbar();

    }

    private void settoolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.bottom_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
            case R.id.share:{
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framelayout, new ShareFragment())
                        .addToBackStack(null)
                        .commit();

                return(true);
            }
            case R.id.home:{
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framelayout, new HomeFragment())
                        .addToBackStack(null)
                        .commit();

                return(true);
            }
            case R.id.settings:{
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framelayout, new SettingsFragment())
                        .addToBackStack(null)
                        .commit();

                return(true);
            }


        }
            return(super.onOptionsItemSelected(item));
        }







    private void setbottomnav() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.share:{
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.framelayout, new ShareFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case R.id.home:{
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.framelayout, new HomeFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case R.id.settings:{
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.framelayout, new SettingsFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                }

                return true;
            }
        });
    }


    }


