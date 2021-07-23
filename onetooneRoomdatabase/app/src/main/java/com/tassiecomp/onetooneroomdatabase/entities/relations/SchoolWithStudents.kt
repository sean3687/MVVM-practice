package com.tassiecomp.onetooneroomdatabase.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.tassiecomp.onetooneroomdatabase.entities.School
import com.tassiecomp.onetooneroomdatabase.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val studnets: List<Student>


    )