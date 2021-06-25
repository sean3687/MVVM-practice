package com.tassiecomp.mvvmtistory

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tassiecomp.mvvmtistory.Source

@Entity(
    tableName = "articles"
)
data class Article(
    //추가 시작
    @PrimaryKey(autoGenerate = true)//primaryey
    // key들을 implementation을 신경쓰지 않아도된다. 룸이 자동으로 만들어줌
    var id: Int? = null, //모든 기사가 id가 있지않으므로
    //추가끝
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)