package com.ctt.minhastarefas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProviders
import com.ctt.minhastarefas.R
import com.ctt.minhastarefas.model.Tarefa
import com.ctt.minhastarefas.viewmodel.TarefasViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewTaskFragment : BottomSheetDialogFragment() {

    private var model: TarefasViewModel? = null
    private lateinit var btnCriarTarefa: Button
    private lateinit var edtTitulo: EditText
    private lateinit var edtDescricao: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.menu_novatarefa, container, false)

        model = ViewModelProviders.of(activity!!).get(TarefasViewModel::class.java)

        btnCriarTarefa = view.findViewById(R.id.btnCriarNovaTarefa)
        edtTitulo = view.findViewById(R.id.edtTitulo)
        edtDescricao = view.findViewById(R.id.edtDesc)

        btnCriarTarefa.setOnClickListener {
            val titulo = edtTitulo.text.toString()
            val descricao = edtDescricao.text.toString()

            model!!.msgTarefaAFazer(
                Tarefa(titulo = titulo, descricao = descricao)
            )
            dismiss()
        }
        return view
    }
}