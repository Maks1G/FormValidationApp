package com.example.formvalidationapp;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextnazwisko;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private EditText editTextPassword;
    private EditText editTextPassword2;
    private Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Powiązanie widoków z kodem
        editTextName = findViewById(R.id.editTextText);
        editTextnazwisko = findViewById(R.id.editTextText2);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        editTextPassword2 = findViewById(R.id.editTextTextPassword2);
        buttonSubmit = findViewById(R.id.button);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pobranie wprowadzonych danych
                String name = editTextName.getText().toString().trim();
                String surname = editTextnazwisko.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String password2 = editTextPassword2.getText().toString().trim();
                // Walidacja danych
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imię", Toast.LENGTH_SHORT).show();
                } else if (surname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić adres e-mail", Toast.LENGTH_SHORT).show();
                } else if
                (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Niepoprawny adres email", Toast.LENGTH_SHORT).show();
                } else if (phone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nr. telefonu", Toast.LENGTH_SHORT).show();
                } else if
                (!Patterns.PHONE.matcher(phone).matches() || phone.length() < 9) {
                    Toast.makeText(MainActivity.this, "Niepoprawny nr. telefonu", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić hasło", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(MainActivity.this, "Hasło musi być dłuższe niż 5 znaków", Toast.LENGTH_SHORT).show();
                } else if (password2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę potwierdzić hasło", Toast.LENGTH_SHORT).show();
                } else if (!(password2.equals(password))) {
                    Toast.makeText(MainActivity.this, "Proszę potwierdzić hasło", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Formularz przesłany poprawnie", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
