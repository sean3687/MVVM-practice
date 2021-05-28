package com.tassiecomp.mvvmpractice2

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
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
        binding.recyclerView.adapter = TodoAdapter(data,
            onClickDeleteIcon = { //onBindViewHolder에서 listposition을 전달받고 이 함수를 실행하게 된다.
                deleteTask(it)//it은 list position이기때문에 그 포지션의 항목이 delete task가 실행되면서 제거된다.
            },
            onClickItem = {
                toggleTodo(it)
            }

        )

        add_button.setOnClickListener {
            addTask()

        }

    }

    fun addTask() {
        val todo = Todo(binding.editText.text.toString())
        data.add(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()

    }

    fun deleteTask(todo: Todo) {
        data.remove(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

    fun toggleTodo(todo:Todo){
        todo.isDone = !todo.isDone
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }


}

data class Todo(
    val text: String,
    var isDone: Boolean = false,
)

class TodoAdapter(
    private val dataSet: List<Todo>,
    val onClickDeleteIcon: (todo: Todo) -> Unit,
    val onClickItem:(todo:Todo)->Unit//delete button이 눌렸을때 onclickDelete Icon을 실행하라는뜻, 0->Unit이기때문에 함수자체에 return없다는뜻
) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) { //아이템을 만들때 여러 뷰가있기때문에 itemTodobinding으로 가져온다.

    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_todo, viewGroup, false) //내가 각아이템에 사용하는 view

        return TodoViewHolder(ItemTodoBinding.bind(view))
    }

    override fun onBindViewHolder(todoViewHolder: TodoViewHolder, position: Int) {//item을 화면에 표시해주는
        val listposition = dataSet[position]
        todoViewHolder.binding.todoText.text = listposition.text
        todoViewHolder.binding.deleteImage.setOnClickListener {
            onClickDeleteIcon.invoke(listposition) //눌렀을때 listposition를 전달하면서 함수를 실행한다.
        }
        if (listposition.isDone) {
//            todoViewHolder.binding.todoText.paintFlags =
//                todoViewHolder.binding.todoText.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            todoViewHolder.binding.todoText.apply {
                paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }
        } else {
            todoViewHolder.binding.todoText.apply {
                paintFlags = 0
            }

        }
        todoViewHolder.binding.root.setOnClickListener {
            onClickItem.invoke(listposition)
        }

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