package ai.sach.learnroomdb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import kotlin.collections.listOf

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0 ,
    var title:String,
    var createdTime:Date
)

