package ai.sach.learnroomdb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoListScreen(viewModel: TodoViewModel){

    val todolistItems by viewModel.todoList.observeAsState()
    var inputText by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it }
            )

            Button(
                onClick = {viewModel.addTodo(inputText)
                inputText = " "
                }
            ) {
                Text(text = "Add", fontSize = 18.sp)
            }
        }

        todolistItems?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it){ _:Int, item:Todo ->
                        TodoItemsUI(item, onDelete = {
                            viewModel.delTodo(item.id)
                        })

                    }

                }

            )
        }?: Text(text = "No Items in List")


    }
}

@Composable
fun TodoItemsUI(item: Todo, onDelete: () -> Unit ){
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = SimpleDateFormat(
                "HH:mm:aa, dd/mm",
                Locale.ENGLISH
            ).format(item.createdTime), fontSize = 16.sp)

            Text(
                text = item.title,
                fontSize = 32.sp
            )

        }

        IconButton(onClick = {
            onDelete
        }) {
            Icon(painterResource(R.drawable.baseline_delete_24),
                contentDescription = "Delete Button",
            )
        }


    }
}


