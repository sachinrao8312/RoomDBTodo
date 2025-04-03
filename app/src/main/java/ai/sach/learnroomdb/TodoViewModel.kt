package ai.sach.learnroomdb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TodoViewModel {
    private  var _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> = _todoList

    fun getAllTodo(){
        _todoList.value = TodoManager.getAllTodo().reversed()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title:String){
        TodoManager.addTodo(title)
        getAllTodo()
    }

    fun delTodo(id:Int){
        TodoManager.delTodo(id)
        getAllTodo()
    }

}