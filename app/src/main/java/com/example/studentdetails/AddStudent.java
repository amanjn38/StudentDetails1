package com.example.studentdetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class details{
    String name1;
    String rollno;
    String rank;

    public details(String name1,String rollno,String rank)
    {
        this.name1=name1;
        this.rollno=rollno;
        this.rank=rank;
    }

}

public class AddStudent extends AppCompatActivity {
    public static ArrayList<details> det=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
    }
    //**merge sort**//
    public static void merge(String[] names, String[] left, String[] right) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < names.length; i++) {
            if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)) {
                names[i] = left[a];
                a++;
            } else {
                names[i] = right[b];
                b++;
            }
        }
    }
    public static void mergeSort(String[] names) {
        if (names.length >= 2) {
            String[] left = new String[names.length / 2];
            String[] right = new String[names.length - names.length / 2];

            for (int i = 0; i < left.length; i++) {
                left[i] = names[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = names[i + names.length / 2];
            }

            mergeSort(left);
            mergeSort(right);
            merge(names, left, right);
        }
    }
    public void regdata(View view)
    {

        EditText et1=findViewById(R.id.t_name);         //storing the data
        EditText et2=findViewById(R.id.roll_no);
        EditText et3=findViewById(R.id.rank);


        String name = et1.getText().toString();
        String rollno = et2.getText().toString();
        String rank = et3.getText().toString();


        det.add(new details(name,rollno,rank));
        MainActivity.alist.add(name);

        Collections.sort(det, new Comparator<details>() {
            @Override
            public int compare(details o1, details o2) {
                return o1.name1.compareToIgnoreCase(o2.name1);
            }
        });

        String[] arr=new String[MainActivity.alist.size()];
        for(int i=0;i<MainActivity.alist.size();i++)
        {
            arr[i]=MainActivity.alist.get(i);
        }
        mergeSort(arr);
        for(int i=0;i<MainActivity.alist.size();i++)
        {
            MainActivity.alist.set(i,arr[i]);
        }

        Intent intent2 = new Intent(this,MainActivity.class);    //starting main activity again
        startActivity(intent2);
        finish();
    }
}
