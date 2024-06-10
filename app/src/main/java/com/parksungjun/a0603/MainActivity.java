package com.parksungjun.a0603;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void onClicked(View view) {
        EditText text = findViewById(R.id.number);
        if (view.getId() == R.id.convert); {
            RadioButton celcius = findViewById(R.id.radiobutton1);
            RadioButton fahrenheit = findViewById(R.id.radiobutton2);
            if (text.getText().length() == 0) {
                Toast.makeText(this, "정확한 값을 입력하시오.", Toast.LENGTH_SHORT).show();
                return;
            }
            float inputValue = Float.parseFloat(text.getText().toString());
            if (celcius.isChecked()) {
                text.setText(String.valueOf(convertFahrenheitToCelcius(inputValue)));
                celcius.setChecked(false);
                fahrenheit.setChecked(true);
            } else {
                text.setText(String.valueOf(convertCelciusToFahrenheit(inputValue)));
                fahrenheit.setChecked(false);
                celcius.setChecked(true);
            }
        }
    }

    private float convertFahrenheitToCelcius(float fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }
    private float convertCelciusToFahrenheit(float celcius) {
        return ((celcius * 9) / 5) + 32;
    }
}