package main.course.com.example.diceprogram

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.util.*

class MainActivity : ComponentActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var rollButton: Button
    private lateinit var diceImageView: ImageView
    private lateinit var random: MyRandom
    private var resultText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.resultTextView)
        rollButton = findViewById(R.id.rollButton)
        diceImageView = findViewById(R.id.diceImageView)

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        random = MyRandom()
        val randomNumber = random.nextInt(6) + 1
        resultText = "You rolled a $randomNumber"
        resultTextView.text = resultText

        val imageResourceId = when (randomNumber) {
            1 -> R.drawable.onedice
            2 -> R.drawable.twodice
            3 -> R.drawable.threedice
            4 -> R.drawable.fourdice
            5 -> R.drawable.fivedice
            else -> R.drawable.sixdice
        }

        // Set the dice image based on the rolled number
        diceImageView.setImageResource(imageResourceId)
    }
}

class MyRandom : Random() {

}
