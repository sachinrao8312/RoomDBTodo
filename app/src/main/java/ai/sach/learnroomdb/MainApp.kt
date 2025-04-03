package ai.sach.learnroomdb

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase

class MainApp :Application(){

    companion object{
        lateinit var todoDatabase: TodoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        Room.databaseBuilder(applicationContext,
            TodoDatabase::class.java,"Todo_room_db")
            .build()
    }
}