package com.ctt.minhastarefas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ctt.minhastarefas.model.Tarefa

class TarefasViewModel : ViewModel() {
    val tarefaAFazer: MutableLiveData<Tarefa> by lazy {
        MutableLiveData<Tarefa>()
    }

    fun msgTarefaAFazer(toDo: Tarefa) {
        tarefaAFazer.value = toDo
    }

    val tarefaEmProgresso: MutableLiveData<Tarefa> by lazy {
        MutableLiveData<Tarefa>()
    }

    fun msgTarefaEmProgresso(inProgress: Tarefa) {
        tarefaEmProgresso.value = inProgress
    }

    val tarefaFeita: MutableLiveData<Tarefa> by lazy {
        MutableLiveData<Tarefa>()
    }

    fun msgTarefaFeita(done: Tarefa) {
        tarefaFeita.value = done
    }
}