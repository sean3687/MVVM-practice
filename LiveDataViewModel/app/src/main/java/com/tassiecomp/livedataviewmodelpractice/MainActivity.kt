package com.tassiecomp.livedataviewmodelpractice

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val TAG:String = "로그"
    }

    lateinit var myNumberViewModel:MyNumberViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //instance has been created.
        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        //when current value has changed, observe function activated.
        myNumberViewModel.currentValue.observe(this, Observer {
            //when value changed it notify and take action
          Log.d(TAG, "MainActivity - myNumberViewModel - currentValue 라이브 데이터값 변경: $it")
            number_textview.text = it.toString()

        })

        plus_btn.setOnClickListener(this)
        minus_btn.setOnClickListener(this)

    }

    //클릭 이벤트가 들어왔을때 발동
    override fun onClick(view: View?) {
        val userInput = userinput_edittext.text.toString().toInt()

        //뷰 모델에 라이브러리 값을 변경한느
        when(view) {
            plus_btn ->
                myNumberViewModel.updateValue(actionType = ActionType.PLUS, userInput)// 2가지 input을 넣어준다
            minus_btn ->
                myNumberViewModel.updateValue(actionType = ActionType.MINUS, userInput)
        }
    }
}