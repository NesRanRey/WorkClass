package com.example.workclass.data.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.workclass.data.model.dao.AccountDao
import com.example.workclass.data.model.viewmodel.AccountEntity

@Database(entities = [AccountEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun accountDao(): AccountDao
}