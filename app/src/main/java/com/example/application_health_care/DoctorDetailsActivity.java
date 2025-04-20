package com.example.application_health_care;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 = {
            {"Doctor Name", "Amit Kumar", "Hospital Address", "NIGHT", "Phone", "Exp Years", "Mobile No", "9810576928", "200"},
            {"Doctor Name", "Prasad Kale", "Hospital Address", "PUNE", "Phone", "Exp Years", "Mobile No", "9810576928", "300"},
            {"Doctor Name", "Ankita Panda", "Hospital Address", "KEM", "Phone", "Exp Years", "Mobile No", "9810576928", "600"},
            {"Doctor Name", "Ankita Panda", "Hospital Address", "KEM", "Phone", "Exp Years", "Mobile No", "9810576928", "5 years"}
    };
    private String[][] doctor_details2 = {
            {"Doctor Name", "Amit Kumar", "Hospital Address", "NIGHT", "Phone", "Exp Years", "Mobile No", "9810576928", "200"},
            {"Doctor Name", "Prasad Kale", "Hospital Address", "PUNE", "Phone", "Exp Years", "Mobile No", "9810576928", "300"},
            {"Doctor Name", "Ankita Panda", "Hospital Address", "KEM", "Phone", "Exp Years", "Mobile No", "9810576928", "600"},
            {"Doctor Name", "Ankita Panda", "Hospital Address", "KEM", "Phone", "Exp Years", "Mobile No", "9810576928", "5 years"}
    };
    private String[][] doctor_details3 = {
            {"Doctor Name", "Amit Kumar", "Hospital Address", "NIGHT", "Phone", "Exp Years", "Mobile No", "9810576928", "200"},
            {"Doctor Name", "Prasad Kale", "Hospital Address", "PUNE", "Phone", "Exp Years", "Mobile No", "9810576928", "300"},
            {"Doctor Name", "Ankita Panda", "Hospital Address", "KEM", "Phone", "Exp Years", "Mobile No", "9810576928", "600"},
            {"Doctor Name", "Ankita Panda", "Hospital Address", "KEM", "Phone", "Exp Years", "Mobile No", "9810576928", "5 years"}
    };
    private String[][] doctor_details4 = {
            {"Doctor Name", "Amit Kumar", "Hospital Address", "NIGHT", "Phone", "Exp Years", "Mobile No", "9810576928", "200"},
            {"Doctor Name", "Prasad Kale", "Hospital Address", "PUNE", "Phone", "Exp Years", "Mobile No", "9810576928", "300"},
            {"Doctor Name", "Ankita Panda", "Hospital Address", "KEM", "Phone", "Exp Years", "Mobile No", "9810576928", "600"},
            {"Doctor Name", "Ankita Panda", "Hospital Address", "KEM", "Phone", "Exp Years", "Mobile No", "9810576928", "5 years"}
    };
    private String[][] doctor_details5 = {
            {"Doctor Name", "Amit Kumar", "Hospital Address", "NIGHT", "Phone", "Exp Years", "Mobile No", "9810576928", "200"},
            {"Doctor Name", "Prasad Kale", "Hospital Address", "PUNE", "Phone", "Exp Years", "Mobile No", "9810576928", "300"},
            {"Doctor Name", "Ankita Panda", "Hospital Address", "KEM", "Phone", "Exp Years", "Mobile No", "9810576928", "600"},
            {"Doctor Name", "Ankita Panda", "Hospital Address", "KEM", "Phone", "Exp Years", "Mobile No", "9810576928", "5 years"}
    };

    TextView tv ;
    Button btn ;
    String[][] doctor_details = {} ;
    HashMap<String,String> item ;
    ArrayList list ;
    SimpleAdapter sa ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this , FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int i = 0;i<doctor_details.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:" + doctor_details[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2", "line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst =findViewById(R.id.listViewDD);
        lst.setAdapter(sa);



    }
}