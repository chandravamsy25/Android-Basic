package main.android.com.example.state_hoisting_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import main.android.com.example.state_hoisting_project.ui.theme.State_hoisting_projectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            State_hoisting_projectTheme {
                MYapp()
            }

        }
    }
}


@Composable
fun DollarCounter(){

    val counter =remember{
        mutableStateOf(1)
    }
    Column(modifier=Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,Alignment.CenterHorizontally){
        Text(text="$${counter.value*100}",style =MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(180.dp))

        CustomButton{
            counter.value++
        }



    }
}
@Composable
fun MYapp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color=MaterialTheme.colorScheme.background
    ){
        DollarCounter()
    }

}

@Composable
fun CustomButton(onClick:()->Unit){
    Card (modifier = Modifier
        .size(120.dp)
        .clickable(){
                    onClick.invoke()


        }, shape = CircleShape,  colors = CardDefaults.cardColors(
        containerColor = Color.Yellow,
    )  ){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Text(text = "TAP", style = TextStyle(color = Color.Black, fontSize = 20.sp,fontWeight = FontWeight.Bold))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    State_hoisting_projectTheme {
        MYapp()

    }
}