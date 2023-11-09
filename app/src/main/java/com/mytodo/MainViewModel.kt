package com.mytodo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytodo.model.TodoEntity
import com.mytodo.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val list = mutableSetOf<TodoEntity>()

    //stateIn을 사용해서 비동기 작업을 수행하고 작업결과를 변환
    val todoList = todoRepository.loadTodoList()
        .stateIn(
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5000),
            scope = viewModelScope
        )

    private val _completeList =MutableLiveData<Set<TodoEntity>>()
    val completeList : LiveData<Set<TodoEntity>> = _completeList


    fun deleteItem(item: TodoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.delete(item)
        }
    }

    fun updateItem(item: TodoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.modify(item)
        }
        if(item.isDone){
            list.add(item)
        }else {
            list.remove(item.copy(isDone = true))
        }
        _completeList.value = list
    }


}