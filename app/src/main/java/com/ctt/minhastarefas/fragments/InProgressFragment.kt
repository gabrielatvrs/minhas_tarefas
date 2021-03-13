package com.ctt.minhastarefas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.minhastarefas.R
import com.ctt.minhastarefas.adapters.InProgressAdapter
import com.ctt.minhastarefas.model.Tarefa
import com.ctt.minhastarefas.viewmodel.TarefasViewModel
import kotlinx.android.synthetic.main.fragment_tarefas.*

class InProgressFragment : Fragment() {

    private var model: TarefasViewModel? = null
    private lateinit var rvTarefas: RecyclerView
    private lateinit var inProgressView: View
    private lateinit var inProgressAdapter: InProgressAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inProgressView = inflater.inflate(R.layout.inprogress_tarefa, container, false)
        model = ViewModelProviders.of(activity!!).get(TarefasViewModel::class.java)

        model!!.tarefaEmProgresso.observe(this, object : Observer<Tarefa> {
            override fun onChanged(tarefa: Tarefa) {
                if (emptyTarefa.visibility != View.GONE){
                    mostrarRV()
                }
                ToDoFragment.listaDeTarefas.add(tarefa)
                inProgressAdapter!!.notifyDataSetChanged()
            }
        })
        return inProgressView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (listaDeTarefas.isNotEmpty()) {
            mostrarRV()
        }
    }

    fun mostrarRV(){

        emptyTarefa.visibility = View.GONE
        rvTarefas = inProgressView.findViewById(R.id.listaTarefas)
        inProgressAdapter = InProgressAdapter(listaDeTarefas)
        rvTarefas.adapter = inProgressAdapter

        rvTarefas.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
        var listaDeTarefas = mutableListOf<Tarefa>()
    }
}