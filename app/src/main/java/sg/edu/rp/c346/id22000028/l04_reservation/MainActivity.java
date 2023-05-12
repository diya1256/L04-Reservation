package sg.edu.rp.c346.id22000028.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

        public class MainActivity extends AppCompatActivity {

            EditText name;
            EditText phone_number;
            EditText number_pax;
            Button reset;
            Button confirm;
            TextView textViewDisplay;
            RadioButton smokeCheckbox;
            RadioButton nonSmokeCheckbox;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                Button buttonDisplayDate = findViewById(R.id.date);
                Button buttonDisplayTime = findViewById(R.id.timePicker);
                name = findViewById(R.id.name);
                phone_number = findViewById(R.id.phone_number);
                number_pax = findViewById(R.id.pax);
                reset = findViewById(R.id.resetBtn);
                confirm = findViewById(R.id.confirmBtn);
                textViewDisplay = findViewById(R.id.textViewDisplay);
                smokeCheckbox = findViewById(R.id.smoking);
                nonSmokeCheckbox = findViewById(R.id.non_smoking);

                buttonDisplayDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePicker datePicker = findViewById(R.id.date);
                        int year = datePicker.getYear();
                        int month = datePicker.getMonth() + 1;
                        int day = datePicker.getDayOfMonth();
                        String date = year + "-" + month + "-" + day;
                        textViewDisplay.setText("Selected Date: " + date);
                    }
                });

                buttonDisplayTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePicker timePicker = findViewById(R.id.timePicker);
                        int hour = timePicker.getCurrentHour();
                        int minute = timePicker.getCurrentMinute();
                        String time = hour + ":" + minute;
                        textViewDisplay.setText("Selected Time: " + time);
                    }
                });

                reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePicker timePicker = findViewById(R.id.timePicker);
                        timePicker.setCurrentHour(19);
                        timePicker.setCurrentMinute(30);

                        DatePicker datePicker = findViewById(R.id.date);
                        datePicker.updateDate(2020, 5, 1);

                        textViewDisplay.setText("TextView");
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText editTextName = findViewById(R.id.name);
                        EditText editTextPhone = findViewById(R.id.phone_number);
                        EditText editTextSize = findViewById(R.id.pax);
                        String name = editTextName.getText().toString();
                        String phone = editTextPhone.getText().toString();
                        String size = editTextSize.getText().toString();

                        DatePicker datePicker = findViewById(R.id.date);
                        int year = datePicker.getYear();
                        int month = datePicker.getMonth() +
                        int day = datePicker.getDayOfMonth();
                        TimePicker timePicker = findViewById(R.id.timePicker);
                        int hour = timePicker.getCurrentHour();
                        int minute = timePicker.getCurrentMinute();

                        boolean isSmokeChecked = smokeCheckbox.isChecked();
                        boolean isNonSmokeChecked = nonSmokeCheckbox.isChecked();
                        StringBuilder cfmMsg = new StringBuilder();
                        cfmMsg.append("Name: ").append(name).append("\n");
                        cfmMsg.append("Phone: ").append(phone).append("\n");
                        cfmMsg.append("Size: ").append(size).append("\n");
                        cfmMsg.append("Date: ").append(year).append("-").append(month).append("-").append(day).append("\n");
                        cfmMsg.append("Time: ").append(hour).append(":").append(minute).append("\n");
                        cfmMsg.append("Smoke: ").append(isSmokeChecked).append("\n");
                        cfmMsg.append("Non-Smoke: ").append(isNonSmokeChecked);

                        Toast.makeText(sg.edu.rp.c346.id22000028.l04_reservation.MainActivity.this, cfmMsg.toString(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        }

