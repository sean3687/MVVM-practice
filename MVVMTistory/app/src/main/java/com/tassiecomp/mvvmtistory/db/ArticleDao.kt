package com.tassiecomp.mvvmtistory.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tassiecomp.mvvmtistory.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //기사가 추가나 업데이트되는 기능을 넣어주겠습니다.
    suspend fun upsert(article: Article):Long //만약 기사가 업데이트되거나 생기면 바꾸게 됩니다.
    //반환값이 long인 이유는 대체될 article의 id가 들어오기때문입니다.

    @Query("SELECT * FROM articles")
    fun getAllArticle():LiveData<List<Article>>
    //라이브데이터를 반환 하기때문에 기사가 추가되거나 바뀔때 UI에 업데이트됩니다.

    @Delete
    suspend fun deleteArticle(article: Article)
}