package com.example.studentdetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnBackToHome;
    ListView listView;
    ArrayAdapter<String> adapter;
    public static int i=0;
    public static ArrayList<String> alist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBackToHome = findViewById(R.id.btnBacktoHome);
        listView = (ListView) findViewById(R.id.ls1);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alist);
        listView.setAdapter(adapter);

        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i=position;

                Intent intent3 = new Intent(MainActivity.this,StuDetails.class);
                startActivity(intent3);
                //finish();

            }
        });
    }
    public void addStudent(View view)
    {
        Intent intent1 = new Intent(this,AddStudent.class);
        startActivity(intent1);
        finish();
    }
}
