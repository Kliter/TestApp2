package com.kl.testapp2.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(

    @PrimaryKey
    private var uid: Int,

    @ColumnInfo(name = "first_name")
    private var firstName: String,

    @ColumnInfo(name = "last_name")
    private var lastName: String,
    
    private var age: Int
)