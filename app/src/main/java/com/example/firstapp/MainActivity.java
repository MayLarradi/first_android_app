package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText editTextNumber = findViewById(R.id.editTextNumber);
        Button buttonCompute = findViewById(R.id.buttonCompute);
        TextView textViewResult=findViewById(R.id.textViewResults);
        ListView listViewResults= findViewById(R.id.listViewResults);
        List<String> data=new ArrayList<>();
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        listViewResults.setAdapter(stringArrayAdapter);
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount =Double.parseDouble(editTextNumber.getText().toString());
                double result=amount*65;
                textViewResult.setText(String.valueOf(result));
                data.add(amount+"=>"+result);
                stringArrayAdapter.notifyDataSetChanged();
                editTextNumber.setText("");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
    }
}