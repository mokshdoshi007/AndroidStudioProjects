package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void i1(View view) { startActivity(new Intent(MainActivity.this,I1.class)); }
    public void i2(View view) { startActivity(new Intent(MainActivity.this,I2.class)); }
    public void i3(View view) { startActivity(new Intent(MainActivity.this,i3.class)); }
    public void i4(View view) { startActivity(new Intent(MainActivity.this,I4.class)); }
    public void i5i6(View view) { startActivity(new Intent(MainActivity.this,I5I6.class)); }
    public void i7(View view) { startActivity(new Intent(MainActivity.this,I7.class)); }
    public void i8(View view) { startActivity(new Intent(MainActivity.this,I8.class)); }
    public void i9(View view) {startActivity(new Intent(MainActivity.this,I9.class)); }
    public void a2(View view) {startActivity(new Intent(MainActivity.this,A2.class)); }
    public void a3(View view) {startActivity(new Intent(MainActivity.this,A3.class)); }
    public void a4(View view) {startActivity(new Intent(MainActivity.this,A4.class)); }
    public void a5(View view) {startActivity(new Intent(MainActivity.this,A5.class)); }
    public void a6(View view) {startActivity(new Intent(MainActivity.this,A6.class)); }
    public void a7(View view) {startActivity(new Intent(MainActivity.this,A7.class)); }
    public void a8(View view) {startActivity(new Intent(MainActivity.this,A8.class)); }
    public void a9(View view) {startActivity(new Intent(MainActivity.this,A9.class)); }

    public void WVI1(View view) {startActivity(new Intent(MainActivity.this,WVI1.class)); }
    public void WVI2(View view) {startActivity(new Intent(MainActivity.this,WVI2.class)); }
    public void AI1(View view) {startActivity(new Intent(MainActivity.this,A_I1.class)); }
    public void AI2(View view) {startActivity(new Intent(MainActivity.this,A_I2.class)); }
    public void DI3(View view) {startActivity(new Intent(MainActivity.this,DI3.class)); }
    public void DI4(View view) {startActivity(new Intent(MainActivity.this,DI4.class)); }
    public void DA1(View view) {startActivity(new Intent(MainActivity.this,DA1.class)); }
    public void DA3(View view) {startActivity(new Intent(MainActivity.this,DA3.class)); }
}