package com.mytodo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytodo.model.TodoEntity
import com.mytodo.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val _doneTodo = MutableLiveData<Unit>()
    val doneTodo: LiveData<Unit> = _doneTodo

    var todo = MutableLiveData<String>()
    var time = MutableLiveData<String?>()
    var item: TodoEntity? = null

    fun initData(item: TodoEntity) {
        this.item = item
        todo.value = item.todo
        time.value = item.time
    }

    fun insertData() {
        todo.value?.let { todo ->
            viewModelScope.launch(Dispatchers.IO) {
                todoRepository.insert(
                    item?.copy(
                        todo = todo,
                        time = time.value
                    ) ?: TodoEntity(todo = todo, time = time.value)
                )
                _doneTodo.postValue(Unit)
            }
        }
    }
}