package ai.sach.learnroomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDAO {

    @Query("SELECT * FROM TODO ORDER BY createdTime DESC")
    fun getAllTodo() : LiveData<List<Todo>>

    @Insert
    suspend fun addTodo(todo: Todo)

    @Query("DELETE FROM Todo WHERE id =:id")
    suspend fun delTodo(id:Int)
}