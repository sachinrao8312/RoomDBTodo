package ai.sach.learnroomdb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.time.Instant
import java.util.Date

class TodoViewModel {

    val todoDao = MainApp.todoDatabase.getTodoDao()

    val todoList: LiveData<List<Todo>> = todoDao.getAllTodo()


    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title:String){
        todoDao.addTodo(Todo(,title,
            createdTime = Date.from(Instant.now()))

        )
        todoDao.getAllTodo()
    }

    fun delTodo(id:Int){
        todoDao.delTodo(id)
        todoDao.getAllTodo()

    }

}