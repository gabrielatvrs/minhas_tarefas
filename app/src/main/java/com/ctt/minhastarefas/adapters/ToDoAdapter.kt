package com.ctt.minhastarefas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.ctt.minhastarefas.R
import com.ctt.minhastarefas.model.Tarefa

class ToDoAdapter(
    private val listaTarefas: MutableList<Tarefa>) : RecyclerView.Adapter<ToDoAdapter.TarefaHolder>() {

    class TarefaHolder(view: View) : RecyclerView.ViewHolder(view){
        val tituloTarefa: TextView = view.findViewById(R.id.txtTituloTarefa)
        val descricaoTarefa: TextView = view.findViewById(R.id.txtDescricaoTarefa)
    }

    fun adicionarTarefa(novaTarefa: Tarefa) {
        listaTarefas.add(novaTarefa)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaHolder {
        val view = LayoutInflater.from(parent.context).
                inflate(R.layout.item_tarefa, parent, false)

        return TarefaHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaHolder, position: Int) {
        holder.tituloTarefa.text = listaTarefas[position].titulo
        holder.descricaoTarefa.text = listaTarefas[position].descricao
    }

    override fun getItemCount(): Int = listaTarefas.size
}