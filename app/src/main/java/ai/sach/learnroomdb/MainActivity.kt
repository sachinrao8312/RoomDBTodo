package ai.sach.learnroomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ai.sach.learnroomdb.ui.theme.LearnRoomDbTheme
import android.os.Build
import androidx.activity.viewModels
import androidx.annotation.RequiresApi

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val todoViewModel: TodoViewModel by viewModels()


        enableEdgeToEdge()
        setContent {
            LearnRoomDbTheme {
                TodoListScreen(todoViewModel)
            }
        }
    }
}

