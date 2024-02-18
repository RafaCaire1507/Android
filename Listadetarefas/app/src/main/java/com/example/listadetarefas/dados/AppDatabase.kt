package com.example.listadetarefas.dados

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Tarefa::class])
abstract class AppDatabase: RoomDatabase() {

   abstract fun getTarefasDao(): TarefasDao
}