package com.tassiecomp.mvvmlivedata

import android.graphics.Paint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tassiecomp.mvvmlivedata.databinding.ActivityMainBinding
import com.tassiecomp.mvvmlivedata.databinding.ItemTodoBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val data = arrayListOf<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.adapter = TodoAdapter(data,
//            onClickDeleteIcon = {
//                deleteTodo(it)
//            }
//        )
        //위에 코드를 아래처럼 간편하게 만들수있다.

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TodoAdapter(data,
                onClickDeleteIcon = {
                    deleteTodo(it)
                },
                onClickItem = {
                    toggleTodo(it)
                }
            )
        }

        binding.addButton.setOnClickListener {
            addTodo()
        }


    }

    private fun toggleTodo(todo:Todo){
        todo.isDone = !todo.isDone
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun addTodo() {
        val todo = Todo(binding.editText.text.toString())
        data.add(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun deleteTodo(todo: Todo) {
        data.remove(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
}

data class Todo(
    val text: String,
    var isDone: Boolean = false
) //기본값 생성


class TodoAdapter(
    private val myDataset: List<Todo>,
    val onClickDeleteIcon: (todo: Todo) -> Unit,//이 함수자체에 return이 없다는 뜻
    val onClickItem: (todo: Todo) -> Unit
) ://이 함수자체에 return이 없다는 뜻
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_todo, viewGroup, false)
        return TodoViewHolder(ItemTodoBinding.bind(view))
    }

    override fun onBindViewHolder(viewHolder: TodoViewHolder, position: Int) {
        val todo = myDataset[position]
        //arraylist로 들어오는 값을 하나하나 처리
        viewHolder.binding.todoText.text = myDataset[position].text
        //하나하나 들어온값을 체크 하는데 그값이 isDone이면?
        if (todo.isDone) {
            viewHolder.binding.todoText.apply {
                paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG //스타라이크 표시apply
                setTypeface(null, Typeface.ITALIC)
            }
        } else {
            viewHolder.binding.todoText.apply {
                paintFlags = 0 // 그냥 normal 표시
                setTypeface(null, Typeface.NORMAL)
            }

        }


        viewHolder.binding.deleteImage.setOnClickListener {
            onClickDeleteIcon.invoke(todo)//deleteimage를 눌렀을때
        }
        viewHolder.binding.root.setOnClickListener {
            onClickItem.invoke(todo)// invoke 함수를 실행시킨다는 뜻
        }
    }

    override fun getItemCount() = myDataset.size

}
