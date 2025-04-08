package com.example.workclass.data.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.workclass.data.model.viewmodel.AccountEntity


@Dao
interface AccountDao {
    @Query("SELECT * FROM AccountEntity")
     fun getAll(): List<AccountEntity>

     @Insert (onConflict = OnConflictStrategy.REPLACE)
     fun insert (account:AccountEntity)
}
