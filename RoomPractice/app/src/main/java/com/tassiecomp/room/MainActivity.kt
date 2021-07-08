package com.tassiecomp.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabaseDao::class.java, "database-name"
        ).allowMainThreadQueries()
            .build()


        result_test.text = db.TodoDao().getAll().toString()

        add_button.setOnClickListener{
            db.TodoDao().insert(Todo(todo_edit.text.toString()))
            result_test.text = db.TodoDao().getAll().toString()
        }
    }
}