package com.alex.wma;

import android.app.DatePickerDialog;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etDob; // Declare EditText globally

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi EdgeToEdge jika perlu (Pastikan EdgeToEdge sudah diimpor dan dikonfigurasi dengan benar)
        EdgeToEdge.enable(this);

        // Inisialisasi Spinner dan Adapter
        Spinner spinnerGender = findViewById(R.id.spinnerGender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter);

        // Mengatur padding menggunakan ViewCompat
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi EditText dan Button
        EditText editTextFullName = findViewById(R.id.editTextFullName);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        etDob = findViewById(R.id.etDob); // Initialize here
        Button buttonCreate = findViewById(R.id.buttonCreate);

        // Mengatur aksi klik untuk tombol Create
        buttonCreate.setOnClickListener(v -> {
            // Mengambil nilai dari EditText
            String fullName = editTextFullName.getText().toString();
            String email = editTextEmail.getText().toString();
            String dateOfBirth = etDob.getText().toString();

            // Menampilkan notifikasi dengan informasi pengguna
            String message = "Halo, nama saya " + fullName + " dengan email saya " + email + " dan tanggal lahir saya " + dateOfBirth;
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        });

        // Set OnClickListener untuk EditText tanggal lahir
        etDob.setOnClickListener(v -> showDatePickerDialog());
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, month1, dayOfMonth) -> {
                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(year1, month1, dayOfMonth);

                    // Format tanggal
                    DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
                    String date = dateFormat.format(selectedDate.getTime());

                    // Set tanggal ke EditText
                    etDob.setText(date);
                }, year, month, day);
        datePickerDialog.show();
    }
}