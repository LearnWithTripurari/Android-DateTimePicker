package com.example.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText dob = findViewById(R.id.dob);
        EditText birthTime = findViewById(R.id.birthTime);


        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Locale lcl = Locale.FRENCH;

                Calendar calendar = Calendar.getInstance();

                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String  selectedDate = DateFormat.getDateInstance(DateFormat.SHORT, lcl).format(calendar.getTime());

                        dob.setText(selectedDate);

                    }
                }, year, month,dayOfMonth).show();
            }
        });


        birthTime.setOnClickListener(new View.OnClickListener() {

            Calendar calendar = Calendar.getInstance();

            int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            @Override
            public void onClick(View view) {
                new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");

                        String selectedTime = simpleDateFormat.format(calendar.getTime());

                        birthTime.setText(selectedTime);

                    }
                },hourOfDay, minute, true).show();
            }
        });
    }
}