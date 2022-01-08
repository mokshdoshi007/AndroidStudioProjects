package tops.technologies.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    String n,e,p,g="Male",sharedpreffile="data";
    EditText name,email,password;
    TextView olduser;
    RadioGroup gender;
    RadioButton radiobutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        gender= (RadioGroup) findViewById(R.id.gender);
        olduser=findViewById(R.id.olduser);
        olduser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent loginmove = new Intent(register.this, Login.class);
                startActivity(loginmove);
            }
        });
    }

    public void genderclick(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId())
        {
            case R.id.male:
                if(checked)
                g="Male";
                break;
            case R.id.female:
                if(checked)
                g="Female";
                break;
        }
        Toast.makeText(getApplicationContext(), g, Toast.LENGTH_SHORT).show();
    }

    public void registerclick(View view) {
        SharedPreferences preferences = getSharedPreferences(sharedpreffile,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        n=name.getText().toString();
        e=email.getText().toString();
        p=password.getText().toString();
        /*int i=gender.getCheckedRadioButtonId();
        radiobutton=(RadioButton)findViewById(i);*/
        int i=-1;
        if (i!=-1)
            editor.putString("gender",radiobutton.getText().toString());
        else
            editor.putString("gender","Male");
        editor.putString("name",n);
        editor.putString("email",e);
        editor.putString("password",p);
        editor.commit();
        Intent registermove = new Intent(register.this, MainActivity.class);
        startActivity(registermove);
    }
}