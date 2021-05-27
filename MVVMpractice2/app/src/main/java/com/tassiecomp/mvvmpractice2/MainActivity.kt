package com.tassiecomp.mvvmpractice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tassiecomp.mvvmpractice2.databinding.ActivityMainBinding
import com.tassiecomp.mvvmpractice2.databinding.ItemTodoBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val data = arrayListOf<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = TodoAdapter(data)



//        linearLayoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = linearLayoutManager

        add_button.setOnClickListener{
            addTask()


        }
        delete_image.setOnClickListener{
            deleteTask()
        }

    }

    fun addTask(){
        val todo = Todo(binding.editText.text.toString())
        data.add(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()

    }

    fun deleteTask(){

        binding.recyclerView.adapter?.notifyDataSetChanged()
    }





}

data class Todo(val text:String, var isDone:Boolean = false)

class TodoAdapter(private val dataSet: List<Todo>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) { //아이템을 만들때 여러 뷰가있기때문에 itemTodobinding으로 가져온다.
        val todoText: TextView
            get() {
                TODO()
            }

    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_todo, viewGroup, false) //내가 각아이템에 사용하는 view

        return TodoViewHolder(ItemTodoBinding.bind(view))
    }

    override fun onBindViewHolder(todoViewHolder: TodoViewHolder, position: Int) {//item을 화면에 표시해주는
        todoViewHolder.binding.todoText.text = dataSet[position].text
    }

    override fun getItemCount() = dataSet.size

}

class MyViewModel : ViewModel() {
//    private val task:MutableLiveData<Todo>
//    private val users: MutableLiveData<List<User>> by lazy {
//        MutableLiveData<List<User>>().also {
//            loadUsers()
//        }
//    }
//
//    fun getUsers(): LiveData<List<User>> {
//        return users
//    }
//
//    private fun loadUsers() {
//        // Do an asynchronous operation to fetch users.
//    }
}