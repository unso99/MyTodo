package com.mytodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.mytodo.databinding.ActivityMainBinding
import com.mytodo.model.TodoEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val todoListAdapter by lazy { TodoListAdapter(Handler()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this


        val divider = DividerItemDecoration(this, VERTICAL)
        binding.todoRecyclerView.apply {
            adapter = todoListAdapter
            addItemDecoration(divider)
        }

        lifecycleScope.launch {
            viewModel.todoList
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collectLatest {
                    binding.emptyTextView.isVisible = it.isEmpty()
                    binding.todoRecyclerView.isVisible = it.isNotEmpty()
                    todoListAdapter.submitList(it)
                }
        }
    }

    fun onClickAdd() {
        InputActivity.start(this)
    }

    inner class Handler {
        fun onClickItem(item: TodoEntity) {
            InputActivity.start(this@MainActivity, item)
        }

        fun onLongClickItem(item: TodoEntity): Boolean {
            viewModel.deleteItem(item)
            Toast.makeText(this@MainActivity, "todo 삭제", Toast.LENGTH_SHORT).show()
            return false
        }

        fun onCheckedItem(item: TodoEntity) {
            viewModel.updateItem(item.copy(isDone = !item.isDone))
        }
    }
}