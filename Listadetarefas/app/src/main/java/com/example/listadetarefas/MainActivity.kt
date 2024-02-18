package com.example.listadetarefas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.listadetarefas.dados.AppDatabase
import com.example.listadetarefas.dados.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewTarefas: RecyclerView
    lateinit var tarefaAdapter: TarefaAdapter
    lateinit var floatingActionButtonSalvar: FloatingActionButton
    lateinit var editTextTarefas: EditText

    lateinit var db:AppDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(this, AppDatabase::class.java, "App")
            .allowMainThreadQueries()
            .build()

        recyclerViewTarefas = findViewById(R.id.recyclerViewTarefas)
        editTextTarefas = findViewById(R.id.editTextTarefas)
        floatingActionButtonSalvar = findViewById(R.id.floatingActionButtonSalvar)

        tarefaAdapter = TarefaAdapter()

        recyclerViewTarefas.adapter = tarefaAdapter
        recyclerViewTarefas.layoutManager = LinearLayoutManager(this)

        floatingActionButtonSalvar.setOnClickListener {
            var tarefaDigitada: String = editTextTarefas.text.toString()
            salvarTarefa(tarefaDigitada)
            atualizarListaDeTarefas()
        }
    }

    fun salvarTarefa(novaTarefa: String) {
        var tarefa: Tarefa = Tarefa(Random.nextInt(), novaTarefa, false)
        db.getTarefasDao().insere(tarefa)
    }

    fun atualizarListaDeTarefas() {
        var listaDeTarefas: List<Tarefa> = db.getTarefasDao().getTarefas()
        tarefaAdapter.setNovasTarefas(listaDeTarefas)
    }

    fun excluirTarefa(tarefa: Tarefa) {
        db.getTarefasDao().delete(tarefa)
    }

    fun atualizaTarefa(tarefa: Tarefa) {
        db.getTarefasDao().atualiza(tarefa)

    }
}