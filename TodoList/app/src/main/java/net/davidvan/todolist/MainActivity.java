package net.davidvan.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> taskList;

    public static ArrayAdapter<String> taskAdapter;

    public static int counter = 0;

    public void addTask(View view)
    {
        String thing = "Hello World";
        taskList.add(thing);
        int place = counter++;
        taskAdapter.notifyDataSetChanged();
        Intent myIntent = new Intent(view.getContext(), AddTask.class);
        myIntent.putStringArrayListExtra("taskList", taskList);
        startActivityForResult(myIntent, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ListView
        taskList = new ArrayList<String>();
        taskAdapter = new ArrayAdapter<String>(this, R.layout.tasks_list_view, R.id.list_item_task_textview, taskList);

        ListView tasks = (ListView) findViewById(R.id.list_view_task);

        tasks.setAdapter(taskAdapter);

    }

    @Override
    public void onStart() {
        // Add task when received from AddTask.java
        if(getIntent().getExtras() != null) {
            String task = getIntent().getExtras().getString("taskName");
            taskList.add(task);
            taskAdapter.notifyDataSetChanged();
        }
        // Doesn't work...
        if (getIntent().getExtras().getStringArrayList("taskList") != null) {
            taskList = getIntent().getExtras().getStringArrayList("taskList");
        }
        super.onStart();
    }

    public void goBack(View view) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
