package ai.sach.learnroomdb

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date
import kotlin.collections.listOf

data class Todo(
    var id:Int,
    var title:String,
    var createdTime:Date
)


@RequiresApi(Build.VERSION_CODES.O)
fun getFakeTodo() : List<Todo>{
    return listOf(
        Todo(id = 1, title = "Gd", createdTime = Date.from(Instant.now())),
        Todo(2, "Gdsad",createdTime= Date.from(Instant.now())),
        Todo(3, "Gdsad", Date.from(Instant.now())),
        Todo(34, "dasdaGd", Date.from(Instant.now())),

    )
}
