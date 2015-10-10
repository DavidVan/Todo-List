package net.davidvan.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by David on 10/10/2015.
 */
public class AddTask extends Activity {

    Intent myIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);

        Button next = (Button) findViewById(R.id.task_back_button);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                myIntent = new Intent(view.getContext(), MainActivity.class);
                // Get EditText text.
                EditText taskName = (EditText) findViewById(R.id.task_name_edit_text);
                String taskNameContents = taskName.getText().toString();
                myIntent.putExtra("taskName", taskNameContents);
                startActivityForResult(myIntent, 0);
            }

        });
    }


    @Override
    public void onStart() {
        // Add task when received from AddTask.java
        if(getIntent().getExtras() != null) {
            ArrayList<String> taskList = getIntent().getExtras().getStringArrayList("taskList");
            myIntent.putStringArrayListExtra("taskList", taskList);
        }
        super.onStart();
    }

}
