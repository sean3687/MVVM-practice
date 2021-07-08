package com.tassiecomp.roomdatabasepractice.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table") //데이터를 불러올때 테이블의 이름을 정합니다.
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName:String,
    val lastName:String,
    val age:Int
) {
}