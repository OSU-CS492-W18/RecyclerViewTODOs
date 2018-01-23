package com.example.android.recyclerviewtodos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mTodoListRecyclerView;
    private EditText mTodoEntryEditText;

    private TodoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTodoListRecyclerView = (RecyclerView)findViewById(R.id.rv_todo_list);

        mTodoListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTodoListRecyclerView.setHasFixedSize(true);

        mAdapter = new TodoAdapter();
        mTodoListRecyclerView.setAdapter(mAdapter);

        mTodoEntryEditText = (EditText)findViewById(R.id.et_todo_entry);

        Button addTodoButton = (Button)findViewById(R.id.btn_add_todo);
        addTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoText = mTodoEntryEditText.getText().toString();
                if (!TextUtils.isEmpty(todoText)) {
                    mAdapter.addTodo(todoText);
                    mTodoEntryEditText.setText("");
                }
            }
        });

    }
}
