package com.merlin.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.merlin.task.FileTask;
import com.merlin.task.Task;
import com.merlin.task.TaskGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Task task=new DownloadTask();
        TaskGroup group=new TaskGroup<>();
        group.add(task);
        group.execute(null);
    }
}
