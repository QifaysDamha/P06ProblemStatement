package com.example.a16033760.p06problemstatement;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTasks;
    Button btnAdd;
    ArrayList<Task> al;
    ArrayList<String> alString;
    ArrayAdapter<String> aa;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTasks = (ListView)findViewById(R.id.TaskList);
        btnAdd = (Button)findViewById(R.id.button2Adding);

        db = new DBHelper(this);
        db.getWritableDatabase();

        alString = db.getTaskContent();

        db.close();

        al = new ArrayList<>();

        for(int i = 0; i < al.size(); i++){
            String task = al.get(i).getTname();
            task += "\n" + al.get(i).getDesc();
            alString.add(task);
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, alString);
        lvTasks.setAdapter(aa);


    }
}
