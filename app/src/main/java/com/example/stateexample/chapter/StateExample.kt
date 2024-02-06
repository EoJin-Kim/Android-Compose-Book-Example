package com.example.stateexample.chapter

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.stateexample.ui.theme.StateExampleTheme

@Composable
fun DemoScreen(){
    var textState by rememberSaveable {
        mutableStateOf("")
    }
    val onTextChange = { text : String ->
        textState = text
    }
    MyTextField(text = textState, onTextChange = onTextChange)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(text : String, onTextChange : (String) -> Unit){
    TextField(value = text, onValueChange = onTextChange)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    StateExampleTheme {
        DemoScreen()
    }
}