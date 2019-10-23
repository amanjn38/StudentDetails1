package com.example.studentdetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StuDetails extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    TextView tv3;

    public static String tv_name;
    public static String tv_rollno;
    public static String tv_rank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_details);

        tv1=(TextView)findViewById(R.id.tv_name);
        tv2=(TextView)findViewById(R.id.tv_rollno);
        tv3=(TextView)findViewById(R.id.tv_rank);

        int p=MainActivity.i;

        details d=new details(null,null,null);
        d=AddStudent.det.get(p);

        tv_name=d.name1;
        tv_rollno=d.rollno;
        tv_rank=d.rank;

        tv1.setText(tv_name);
        tv2.setText(tv_rollno);
        tv3.setText(tv_rank);

    }
    public void DeleteStu(View view)
    {
        MainActivity.alist.remove(MainActivity.i);
        AddStudent.det.remove(MainActivity.i);

        Intent intent4=new Intent(this,MainActivity.class);
        startActivity(intent4);
        finish();
    }
}
