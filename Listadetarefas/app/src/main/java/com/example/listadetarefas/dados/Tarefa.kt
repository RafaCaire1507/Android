package com.example.listadetarefas.dados

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Tarefa (
    @PrimaryKey
    var id: Int,
    var nome: String,
    var concluida: Boolean
)