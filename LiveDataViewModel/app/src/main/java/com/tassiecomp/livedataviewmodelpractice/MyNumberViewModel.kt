package com.tassiecomp.livedataviewmodelpractice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


enum class ActionType{
    PLUS,MINUS
}

//any data change work here
class MyNumberViewModel: ViewModel() {

    companion object{
        const val TAG:String = "로그"
    }

    // 2 types of Data
    // mutable live data - editable
    // live data - value can't be change

    private val _currentValue = MutableLiveData<Int>() //when you want to bring MutableLiveData bring mutablelivedata

    val currentValue:LiveData<Int> // bring liveData when you just want to read it
        get() = _currentValue

//    초기값 설정
    init{
        Log.d(TAG,"MyNumberViewModel - 생성자 호출 ")
        //초기값 생성 mutuable list 로 생성했기때문에 value를 바꿀수있다.
        _currentValue.value = 0
    }

    fun updateValue(actionType: ActionType,input:Int){
        when(actionType){
            ActionType.PLUS ->_currentValue.value = _currentValue.value?.plus(input)//mutableList
            ActionType.MINUS -> _currentValue.value = _currentValue.value?.minus(input)

        }
    }


}