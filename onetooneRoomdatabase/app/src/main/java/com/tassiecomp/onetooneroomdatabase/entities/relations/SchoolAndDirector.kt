package com.tassiecomp.onetooneroomdatabase.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.tassiecomp.onetooneroomdatabase.entities.Director
import com.tassiecomp.onetooneroomdatabase.entities.School

data class SchoolAndDirector(
    @Embedded val school:School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director:Director
)