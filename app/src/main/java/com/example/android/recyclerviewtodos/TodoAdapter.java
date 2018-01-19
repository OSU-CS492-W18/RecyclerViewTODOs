package com.example.android.recyclerviewtodos;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hessro on 1/18/18.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private ArrayList<String> mTodoList;

    public TodoAdapter() {
        mTodoList = new ArrayList<String>();
    }

    public void addTodo(String todo) {
        mTodoList.add(todo);
        notifyDataSetChanged();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {

        private TextView mTodoText;

        public TodoViewHolder(View itemView) {
            super(itemView);
            mTodoText = (TextView)itemView.findViewById(R.id.tv_todo_text);
        }

        public void bind(String todo) {
            mTodoText.setText(todo);
        }
    }

}
