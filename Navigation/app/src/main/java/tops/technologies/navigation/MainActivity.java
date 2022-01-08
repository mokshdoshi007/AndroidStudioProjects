    package tops.technologies.navigation;

    import android.os.Bundle;
    import android.os.Handler;
    import android.view.MenuItem;
    import android.widget.FrameLayout;


    import androidx.annotation.NonNull;
    import androidx.appcompat.app.ActionBarDrawerToggle;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.appcompat.widget.Toolbar;
    import androidx.core.view.GravityCompat;
    import androidx.drawerlayout.widget.DrawerLayout;
    import androidx.fragment.app.Fragment;

    import com.google.android.material.navigation.NavigationView;

    public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FrameLayout frameLayout;
    Fragment fragment;
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation_view);
        frameLayout = findViewById(R.id.framelayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        loadFragment(new home());
        navigationView.setNavigationItemSelectedListener(this);
    }
        private boolean loadFragment(Fragment fragment){
            if(fragment!=null)
            {
                getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framelayout, fragment)
                .commit();
                return true;
            }
            return false;
        }


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        fragment = null;

        switch (item.getItemId())
        {
            case R.id.home_id:
                fragment = new home();
                break;
            case R.id.setting_id:
                fragment = new setting();
                break;
            case R.id.about_id:
                fragment = new about();
                break;
            case R.id.logout_id:
                fragment = new home();
                break;
            case R.id.share_id:
                fragment = new setting();
                break;
            case R.id.search_id:
                fragment = new about();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
            return loadFragment(fragment);
        }
    }
