package ai.sach.learnroomdb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel() {  // Extend ViewModel

    val todoDao = MainApp.todoDatabase.getTodoDao()

    // LiveData automatically updates when database changes
    val todoList: LiveData<List<Todo>> = todoDao.getAllTodo()

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String) {
        viewModelScope.launch {  // Run in coroutine
            todoDao.addTodo(
                Todo(
                    title = title,
                    createdTime = Date.from(Instant.now())
                )
            )
            // No need to call getAllTodo() - LiveData updates automatically
        }
    }

    fun delTodo(id: Int) {
        viewModelScope.launch {  // Run in coroutine
            todoDao.delTodo(id)
            // No need to call getAllTodo() - LiveData updates automatically
        }
    }
}