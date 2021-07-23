package com.tassiecomp.onetooneroomdatabase

import androidx.room.*
import com.tassiecomp.onetooneroomdatabase.entities.Director
import com.tassiecomp.onetooneroomdatabase.entities.School
import com.tassiecomp.onetooneroomdatabase.entities.Student
import com.tassiecomp.onetooneroomdatabase.entities.relations.SchoolAndDirector
import com.tassiecomp.onetooneroomdatabase.entities.relations.SchoolWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String):List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>


}