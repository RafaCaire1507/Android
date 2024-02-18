package com.example.listadetarefas.dados

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TarefasDao {

    @Insert
    fun insere(tarefa: Tarefa)

    @Update
    fun atualiza(tarefa: Tarefa)

    @Delete
    fun delete(tarefa: Tarefa)

    @Query( "SELECT * FROM tarefa")
    fun getTarefas(): List<Tarefa>
}