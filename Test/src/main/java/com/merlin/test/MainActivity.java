package com.merlin.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.merlin.task.DownloadTask;
import com.merlin.task.TaskGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DownloadTask<>();
        TaskGroup group=new TaskGroup<>();
        group.ad
        group.execute(null);
    }
}
