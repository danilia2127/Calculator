package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculator extends AppCompatActivity implements View.OnClickListener {
    private EditText edt_width;
    private EditText edt_height;
    private EditText edt_length;
    private Button btn_calculate;
    private TextView tvResult;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        edt_width = findViewById(R.id.edt_width);
        edt_height = findViewById(R.id.edt_height);
        edt_length = findViewById(R.id.edt_length);
        btn_calculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btn_calculate.setOnClickListener(this);

        if(savedInstanceState !=null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    protected void  onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String inputLength = edt_length.getText().toString().trim();
            String inputWidth = edt_width.getText().toString().trim();
            String inputHeight = edt_height.getText().toString().trim();

            boolean isEmptyFields = false;

            if(TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                edt_length.setError("Bagian ini tidak boleh kosong");
            }

            if(TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                edt_width.setError("Bagian ini tidak boleh kosong");
            }

            if(TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edt_height.setError("Bagian ini tidak boleh kosong");
            }

            if(!isEmptyFields) {
                double volume = Double.valueOf(inputLength)*Double.valueOf(inputWidth)*Double.valueOf(inputHeight);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}