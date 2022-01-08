package tops.technologies.menus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class A3 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);
        loadFragment(new GalleryFragment());
        bottomNavigationView=findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            switch(item.getItemId())
            {
                case R.id.gallery:
                    fragment = new GalleryFragment();
                    break;
                case R.id.audio:
                    fragment = new AudioFragment();
                    break;
                case R.id.video:
                    fragment = new VideoFragment();
                    break;
            }
            return loadFragment(fragment);
        });

    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment!=null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
            return true;
        }
        return false;
    }

}