package com.example.listadetarefas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadetarefas.dados.Tarefa

class TarefaAdapter: RecyclerView.Adapter<TarefaViewHolder>() {


    var tarefas:List<Tarefa> = listOf()

    fun setNovasTarefas(novasTarefas: List<Tarefa>) {
        tarefas= novasTarefas
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        var view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarefa, parent,false)

        return TarefaViewHolder(view)
    }

    override fun getItemCount(): Int {
       return tarefas.size
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        holder.textViewTarefa.text = tarefas[position].nome
    }
}