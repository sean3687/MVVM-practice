package com.tassiecomp.recyclerviewactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RecyclerViewActivity:AppCompatActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.apply{
            layoutManager =
        }
    }
}