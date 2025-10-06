package com.example.kiemtratuoiapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtAge;
    Button btnCheck;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        btnCheck = findViewById(R.id.btnCheck);
        txtResult = findViewById(R.id.txtResult);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();
                String ageStr = edtAge.getText().toString().trim();

                if (name.isEmpty() || ageStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int age = Integer.parseInt(ageStr);
                String category;

                if (age > 65) {
                    category = "Người già";
                } else if (age >= 6) {
                    category = "Người lớn";
                } else if (age >= 2) {
                    category = "Trẻ em";
                } else {
                    category = "Em bé";
                }

                txtResult.setText("Họ tên: " + name + "\nTuổi: " + age + "\nPhân loại: " + category);
            }
        });
    }
}
