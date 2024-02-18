package com.example.listadetarefas

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarefaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var textViewTarefa: TextView = view.findViewById(R.id.textViewTarefa)

}