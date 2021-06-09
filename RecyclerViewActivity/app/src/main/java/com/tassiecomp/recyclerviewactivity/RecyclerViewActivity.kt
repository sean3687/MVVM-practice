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
        val item = ArrayList<RecyclerData>()

        item.add(RecyclerData("Java","Java description"))
        item.add(RecyclerData("C++","C++ description"))
        item.add(RecyclerData("Android","Android Description"))
        item.add(RecyclerData("iOS","ios descrip"))
        item.add(RecyclerData("php","php descrip"))
        item.add(RecyclerData("Kotlin","Kotlin descrip"))

        recyclerViewAdapter.setListData(item)
        recyclerViewAdapter.notifyDataSetChanged()



    }
}