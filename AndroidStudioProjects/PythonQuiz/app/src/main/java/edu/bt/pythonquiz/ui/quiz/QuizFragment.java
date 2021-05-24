package edu.bt.pythonquiz.ui.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import edu.bt.pythonquiz.R;

public class QuizFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }
}

//public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//    private DrawerLayout drawer;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        drawer = findViewById(R.id.drawer_layout);
//        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
//                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container,
//                    new HomeFragment()).commit();
//            navigationView.setCheckedItem(R.id.nav_home);
//        }
//
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.nav_home:
//                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container,
//                        new HomeFragment()).commit();
//                break;
//            case R.id.nav_profile:
//                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container,
//                        new ProfileFragment()).commit();
//                break;
//            case R.id.nav_python:
//                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container,
//                        new PythonFragment()).commit();
//                break;
//            case R.id.nav_quiz:
//                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container,
//                        new QuizFragment()).commit();
//                break;
//            case R.id.nav_event:
//                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container,
//                        new EventFragment()).commit();
//                break;
//            case R.id.nav_share:
//                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.nav_about:
//                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.isDrawerOpen(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//
//
//    }
//}