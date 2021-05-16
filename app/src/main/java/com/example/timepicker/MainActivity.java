package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnclick;
    static  int hour,minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar c= Calendar.getInstance();
        hour=c.get(Calendar.HOUR);
        minute=c.get(Calendar.MINUTE);

        btnclick=findViewById(R.id.btnclick);

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new TimepickerFragment();
                dialogFragment.show(getSupportFragmentManager(),"timepicker");
            }
        });
    }

    public static class TimepickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState)
        {
            return  new TimePickerDialog(getActivity(),this,MainActivity.hour,MainActivity.minute,true);
        }
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            Toast.makeText(getActivity(), "time" + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();

        }
    }
}