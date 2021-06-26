package com.tassiecomp.mvvmtistory.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tassiecomp.mvvmtistory.models.Article

@Database(
    entities = [Article::class],//만들어 주었던 entity 클래스 를 연결해줍니다.
    version = 1 //
)

@TypeConverters(Converters::class)
abstract class ArticleDatabase:RoomDatabase() {

    abstract fun getArticleDao():ArticleDao

    companion object{
        @Volatile// other thread can immidatly see when thread changes the instance
        private var instance:ArticleDatabase? = null//articledatabase를 인스턴스 할때 씀
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) { // this invoke will be called when class is initailized or instaqnciate
            instance ?: createDatabase(context).also{ //if there is no instance return instance in synchronized block
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java, //we need to refer to our database class
                "article_db.db" //give name of article db
            ).build()
    }
}