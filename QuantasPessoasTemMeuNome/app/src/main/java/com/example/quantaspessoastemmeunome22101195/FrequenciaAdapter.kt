package com.example.quantaspessoastemmeunome22101195

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quantaspessoastemmeunome22101195.dadosremotos.Frequencia

class FrequenciaAdapter : RecyclerView.Adapter<ItemFrequeciacViewHolder>() {


    var frequencias : List<Frequencia> = listOf()

    fun setNovaFrequencias(novasFrequencia: List<Frequencia>) {
        frequencias = novasFrequencia
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFrequeciacViewHolder {
        var view: View =

            LayoutInflater.from(parent.context).inflate(R.layout.item_frequencia, parent, false)

        return ItemFrequeciacViewHolder(view)
    }

    override fun getItemCount(): Int {
        return frequencias.size
    }

    override fun onBindViewHolder(holder: ItemFrequeciacViewHolder, position: Int) {
       holder.textViewFrequencia.text = frequencias[position].frequencia
        holder.textViewPeriodo.text = frequencias[position].periodo

    }
}