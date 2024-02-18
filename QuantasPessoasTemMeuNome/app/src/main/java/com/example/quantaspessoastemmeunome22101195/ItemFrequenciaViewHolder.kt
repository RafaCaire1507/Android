package com.example.quantaspessoastemmeunome22101195

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemFrequeciacViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    var textViewPeriodo: TextView = view.findViewById(R.id.textViewPeriodo)
    var textViewFrequencia: TextView = view.findViewById(R.id.textViewFrequencia)

}