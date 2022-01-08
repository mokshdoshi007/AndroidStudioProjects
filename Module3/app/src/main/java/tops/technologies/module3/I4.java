package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class I4 extends AppCompatActivity {
    Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i4);
        login=findViewById(R.id.login);
        register=findViewById(R.id.register);
        LoginFragment loginFragment = new LoginFragment();
        RegisterFragment registerFragment = new RegisterFragment();
        login.setOnClickListener(v -> {
            getFragmentManager().beginTransaction().replace(R.id.framel, new LoginFragment()).addToBackStack(null).commit();
        });
        register.setOnClickListener(v -> {
            getFragmentManager().beginTransaction().replace(R.id.framel, new RegisterFragment()).addToBackStack(null).commit();
        });
    }
}