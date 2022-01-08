package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DA3 extends AppCompatActivity {
    TextView date, dateto, year, month, days;
    DatePickerDialog datePickerDialog;
    Button save_btn;
    Calendar c1, c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da3);

        date = findViewById(R.id.date);
        dateto = findViewById(R.id.dateto);
        save_btn = findViewById(R.id.save_btn);

        year = findViewById(R.id.year);
        month = findViewById(R.id.month);
        days = findViewById(R.id.days);

        save_btn.setOnClickListener(v -> {
            try {
                String d1 = date.getText().toString();
                String d2 = dateto.getText().toString();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                Date date1 = simpleDateFormat.parse(d1);
                Date date2 = simpleDateFormat.parse(d2);
                long difference = Math.abs(date1.getTime() - date2.getTime());
                long difftDays = difference / (24 * 60 * 60 * 1000);

                int years = (int) (difftDays/365);
                difftDays-=years*365;
                int months = (int) (difftDays/30);
                difftDays-=months*12;
                year.setText("Years: " + years);
                month.setText("Months: " + months);
                days.setText("Days: " + difftDays);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1 = Calendar.getInstance();
                int mYear = c1.get(Calendar.YEAR);
                int mMonth = c1.get(Calendar.MONTH);
                int mDay = c1.get(Calendar.DAY_OF_MONTH);
                // date picker dialog
                datePickerDialog = new DatePickerDialog(DA3.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                        String mon=MONTHS[monthOfYear];
                        date.setText(dayOfMonth + "-"+(mon)+ "-" + year);

                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        dateto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c2 = Calendar.getInstance();
                int mYear = c2.get(Calendar.YEAR);
                int mMonth = c2.get(Calendar.MONTH);
                int mDay = c2.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(DA3.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                        String mon=MONTHS[monthOfYear];
                        dateto.setText(dayOfMonth + "-" + (mon) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


    }
}
