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
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tassiecomp.mvvmlivedata.databinding.ActivityMainBinding
import com.tassiecomp.mvvmlivedata.databinding.ItemTodoBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

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
            adapter = TodoAdapter(
                emptyList(),
                onClickDeleteIcon = {
                    viewModel.deleteTodo(it)
                },
                onClickItem = {
                    viewModel.toggleTodo(it) //toggle todo를 it을 넣어서 실행

                }
            )
        }

        binding.addButton.setOnClickListener {
            val todo = Todo(binding.editText.text.toString())
            viewModel.addTodo(todo)
        }

        // 관찰 UI 업데이트
        viewModel.todoLiveData.observe(this, Observer{
            //livedata에 저장된 값이 바뀔때마다. viewmodel에 있는 함수가 실행된다.
            //이제 우리는 adapter의 값을 갱신해주면된다.
            (binding.recyclerView.adapter as TodoAdapter).setData(it)
        })


    }

}

data class Todo(
    val text: String,
    var isDone: Boolean = false
) //기본값 생성


class TodoAdapter(
    private var myDataset: List<Todo>,
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

    fun setData(newData: List<Todo>) {
        myDataset = newData
        notifyDataSetChanged() //newdata가 바뀔떄마다 이기능이 실행되도록 했다.

    }
}

class MainViewModel: ViewModel(){
    val todoLiveData = MutableLiveData<List<Todo>>()


    //mainactivity에 데이터 관련된 애들을 여기로 옮기는 작업을할것이다.
    private val data = arrayListOf<Todo>()

    fun toggleTodo(todo:Todo){
        todo.isDone = !todo.isDone
        todoLiveData.value = data //이걸로인해 data값들이 업데이트된다. 이제 이걸 layout에 적용시켜야한다.
    }

    fun addTodo(todo:Todo) {
        data.add(todo)
        todoLiveData.value = data
    }

    fun deleteTodo(todo: Todo) {
        data.remove(todo)
        todoLiveData.value = data
    }
}
