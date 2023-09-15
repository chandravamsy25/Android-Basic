package main.android.com.example.guessthenumber


import main.android.com.example.guessthenumber.ui.theme.GuessTHEnumberTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.Rgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessNumberGame()   //call the main page
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuessNumberGame() {
    var targetNumber by remember { mutableStateOf(Random.nextInt(1, 101)) }     //initialize random value
    var userGuess by remember { mutableStateOf("") }        //store value guessed by user
    var guessResult by remember { mutableStateOf("") }      //store result after comparing initial value & userGuess


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(       //Heading
            text = "Guess the number",
            style = TextStyle(fontSize = 24.sp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )

        OutlinedTextField(      //Accept Input
            value = userGuess,
            colors=TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.hsl(210f, 1f, 0.85f),
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Black),
            onValueChange = {
                userGuess = it
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done),
            textStyle = TextStyle(fontSize = 18.sp),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            )

        Button(     //compare the guess
            onClick = {
                val guess = userGuess.toIntOrNull()
                if (guess != null) {
                    guessResult = when {        //update the result
                        guess < targetNumber -> "Guess Higher"
                        guess > targetNumber -> "Guess Lower"
                        else -> "Correct! The number was $targetNumber"
                    }
                } else {
                    guessResult = "Enter a valid number."
                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        ) {
            Text(text = "Check ? 🤔", style = TextStyle(fontSize = 24.sp))
        }

        Text(       //display the result after comparison
            text = guessResult,
            color = if (guessResult.contains("Correct")) Color.Green else Color.Red,
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGuessNumberGame() {
    GuessNumberGame()
}