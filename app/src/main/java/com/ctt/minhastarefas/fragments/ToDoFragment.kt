package com.ctt.minhastarefas.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.minhastarefas.R
import com.ctt.minhastarefas.adapters.ToDoAdapter
import com.ctt.minhastarefas.model.Tarefa
import com.ctt.minhastarefas.viewmodel.TarefasViewModel
import kotlinx.android.synthetic.main.fragment_tarefas.*

class ToDoFragment : Fragment() {

    private var model: TarefasViewModel? = null
    private lateinit var toDoView: View
    private lateinit var rvTarefas: RecyclerView
    private lateinit var toDoAdapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        toDoView = inflater.inflate(R.layout.fragment_tarefas, container, false)
        model = ViewModelProviders.of(activity!!).get(TarefasViewModel::class.java)

        model!!.tarefaAFazer.observe(this, object : Observer<Tarefa> {
            override fun onChanged(tarefa: Tarefa) {
                if (emptyTarefa.visibility != View.GONE){
                    mostrarRV()
                }
                listaDeTarefas.add(tarefa)
                toDoAdapter!!.notifyDataSetChanged()
            }
        })

        return toDoView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (listaDeTarefas.isNotEmpty()) {
            mostrarRV()
        }
    }

    fun mostrarRV(){

        emptyTarefa.visibility = View.GONE
        rvTarefas = toDoView.findViewById(R.id.listaTarefas)
        toDoAdapter = ToDoAdapter(listaDeTarefas)
        rvTarefas.adapter = toDoAdapter

        rvTarefas.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
        var listaDeTarefas = mutableListOf<Tarefa>()
    }
}
