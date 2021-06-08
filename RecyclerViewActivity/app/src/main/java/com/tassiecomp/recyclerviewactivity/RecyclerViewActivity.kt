package com.tassiecomp.recyclerviewactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity:AppCompatActivity() {
    lateinit var recyclerViewAdapter:RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        initRecyclerView()
        createData()
    }

    private fun initRecyclerView() {
        recyclerView.apply{
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

        }
    }

    fun createData(){
        val item = ArrayList<String>()

        item.add("Java")
        item.add("C+")
        item.add("android")
        item.add("IOS")
        item.add("PHP")
        item.add("Kotlin")

        recyclerViewAdapter.setListData(item)
        recyclerViewAdapter.notifyDataSetChanged()



    }
}