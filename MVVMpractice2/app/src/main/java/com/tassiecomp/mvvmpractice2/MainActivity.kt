package com.tassiecomp.mvvmpractice2

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tassiecomp.mvvmpractice2.databinding.ActivityMainBinding
import com.tassiecomp.mvvmpractice2.databinding.ItemTodoBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = TodoAdapter(
            emptyList(),
            onClickDeleteIcon = { //onBindViewHolder에서 listposition을 전달받고 이 함수를 실행하게 된다.
                viewModel.deleteTask(it) //it은 list position이기때문에 그 포지션의 항목이 delete task가 실행되면서 제거된다.
                binding.recyclerView.adapter?.notifyDataSetChanged()
            }

        )

        binding.addButton.setOnClickListener {
            val todo = Todo(binding.editText.text.toString())
            viewModel.addTask(todo)
            binding.recyclerView.adapter?.notifyDataSetChanged()
        }

        //관찰UI업데이트
        viewModel.todoLiveData.observe(this, Observer { //viewmodel에서 만든 변경관찰 가능한todoLiveData를 가져온다.
            (binding.recyclerView.adapter as TodoAdapter).setData(it)
        })

    }




}

data class Todo(
    val text: String,
    var isDone: Boolean = false,
)

class TodoAdapter(
    private var mydataSet: List<Todo>,
    val onClickDeleteIcon: (todo: Todo) -> Unit
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
        val listposition = mydataSet[position]
        todoViewHolder.binding.todoText.text = listposition.text
        todoViewHolder.binding.deleteImage.setOnClickListener {
            onClickDeleteIcon.invoke(listposition) //눌렀을때 listposition를 전달하면서 함수를 실행한다.
        }


    }

    override fun getItemCount() = mydataSet.size

    fun setData(newData:List<Todo>){
        mydataSet = newData
        notifyDataSetChanged()
    }



}


class MyViewModel : ViewModel() {
    val todoLiveData = MutableLiveData<List<Todo>>() //변경/관찰가능한 List<Todo>타입에 LiveData

    private val data = arrayListOf<Todo>()

    fun addTask(todo:Todo) {
        data.add(todo)
        todoLiveData.value = data //todoLiveData를 add된 데이터로 변경
    }

    fun deleteTask(todo: Todo) {
        data.remove(todo)
        todoLiveData.value = data //todoLiveData를 remove된 데이터로 변경, 이제 TodoLiveData로 UI값을 변경해줘야한다.
    }

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