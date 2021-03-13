package com.ctt.minhastarefas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.minhastarefas.R
import com.ctt.minhastarefas.adapters.DoneAdapter
import com.ctt.minhastarefas.model.Tarefa
import com.ctt.minhastarefas.viewmodel.TarefasViewModel
import kotlinx.android.synthetic.main.fragment_tarefas.*

class DoneFragment : Fragment() {

    private var model: TarefasViewModel? = null
    private lateinit var doneView: View
    private lateinit var rvTarefas: RecyclerView
    private lateinit var doneAdapter: DoneAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        doneView = inflater.inflate(R.layout.done_tarefas, container, false)
        model = ViewModelProviders.of(activity!!).get(TarefasViewModel::class.java)

        model!!.tarefaFeita.observe(this, object : Observer<Tarefa> {
            override fun onChanged(tarefa: Tarefa) {
                if (emptyTarefa.visibility != View.GONE){
                    mostrarRV()
                }
                ToDoFragment.listaDeTarefas.add(tarefa)
                doneAdapter!!.notifyDataSetChanged()
            }
        })

        return doneView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (listaDeTarefas.isNotEmpty()) {
            mostrarRV()
        }
    }

    fun mostrarRV(){

        emptyTarefa.visibility = View.GONE
        rvTarefas = doneView.findViewById(R.id.listaTarefas)
        doneAdapter = DoneAdapter(listaDeTarefas)
        rvTarefas.adapter = doneAdapter

        rvTarefas.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
        var listaDeTarefas = mutableListOf<Tarefa>()
    }

}