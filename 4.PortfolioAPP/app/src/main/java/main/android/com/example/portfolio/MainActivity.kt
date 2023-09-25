package main.android.com.example.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import main.android.com.example.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            portfolio()
        }
    }
}

@Composable
fun portfolio(){

    val isOpen= remember {
        mutableStateOf(false)

    }
    Surface(tonalElevation =8.dp,
        shape= RoundedCornerShape(12.dp),
        color =MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
        ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier=Modifier.padding(12.dp
            )
        )
        {
            Image(painter = painterResource(id =R.drawable.profile ), contentDescription =null,
                modifier=Modifier.size(60.dp))
            Spacer(modifier=Modifier.height(8.dp))

            Divider()
            Spacer(modifier=Modifier.height(8.dp))

            Text(text = "Chandra Vamsy", style = TextStyle(
                color= Color.Green, fontSize = 20.sp,fontWeight = FontWeight.Bold))


            Text(text="Android Developer",style =MaterialTheme.typography.titleSmall)

            Spacer(modifier=Modifier.height(8.dp))
            Row (){
                Image(painter= painterResource(id = R.drawable.leet),contentDescription = null,
                    modifier = Modifier.size(18.dp))

                Text(text="/chandravamsy123" ,
                    style=MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(horizontal=8.dp)
                )
            }
            Row(){
                Image(painter= painterResource(id = R.drawable.git),contentDescription = null,
                    modifier=Modifier.size(18.dp)
                    )
                Text(text="/chandravamsy25" ,
                    style=MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(horizontal=8.dp)
                )
            }
            Spacer(modifier=Modifier.height(8.dp))

            Button(onClick = { isOpen.value=!isOpen.value}) {
                Text(text = "My projects")

            }
            if(isOpen.value)
            {
                LazyColumn{
                    items(getProjectList()){
                        ProjectItem(it)
                    }
                }
            }


        }


    }
}


@Composable
fun ProjectItem(project: Project){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)){
        Image(painter= painterResource(id = R.drawable.profile),contentDescription = null,
            modifier = Modifier
                .size(65.dp)
                .clip(CircleShape)
        )
        Column (modifier = Modifier.padding(horizontal=8.dp)){
            Text(text=project.name,style=MaterialTheme.typography.bodyLarge)
            Text(text=project.desc,style=MaterialTheme.typography.bodySmall)
        }
    }

}


fun getProjectList():List<Project>{
    return listOf(
        Project(name="Workshop Mangement",desc="Simplify workshop enrollment"),
        Project(name="Portfolio App",desc="Showcase your portfolio"),
        Project(name="Dice Roller",desc="Roll the Dice game"),
        Project(name="Guess Number",desc="Guess the number game"),
    )

}

data class Project(
    val name:String,val  desc:String
)


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PortfolioTheme {
        portfolio()
    }
}