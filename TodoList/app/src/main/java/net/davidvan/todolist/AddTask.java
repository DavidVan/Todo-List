package net.davidvan.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by David on 10/10/2015.
 */
public class AddTask extends Activity {

    /* Variables */
    public EditText memo1;
    public CheckBox alert;
    public String memo2;
    public boolean setAlert = false;

    public void initTasks(){
        memo1 = (EditText)findViewById(R.id.task_name_edit_text);
        alert = (CheckBox)findViewById(R.id.task_alert_button);
    }
    public void setValues(){
        memo2 = memo1.getText().toString();
        setAlert = alert.isChecked();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);
        Button next = (Button) findViewById(R.id.task_done_button);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                initTasks();
                setValues();
                Bundle b = new Bundle();
                b.putString("tasks", memo2);
                b.putBoolean("alert", setAlert);

                Intent in = new Intent(AddTask.this, MainActivity.class);
                in.putExtras(b);
                startActivity(in);
            }

        });
        Button back = (Button) findViewById(R.id.task_back_button);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent in = new Intent(AddTask.this, MainActivity.class);
                startActivityForResult(in, 0);
            }
        });
    }


//    @Override
//    public void onStart() {
////        // Add task when received from AddTask.java
////        if(getIntent().getExtras() != null) {
////            ArrayList<String> taskList = getIntent().getExtras().getStringArrayList("taskList");
////            myIntent.putStringArrayListExtra("taskList", taskList);
////        }
//        super.onStart();
//    }

}
