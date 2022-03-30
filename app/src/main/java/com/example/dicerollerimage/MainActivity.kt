package com.example.dicerollerimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.bnt)
        button.setOnClickListener{rollDice()}
    }

    private fun rollDice(){
        val number = (1..6).random()
        val edit: EditText = findViewById(R.id.edtNumber)

        //val text: TextView = findViewById(R.id.txt)
        //text.text = number.toString()

        //Toast.makeText(this, text.text, Toast.LENGTH_SHORT).show()

        val image: ImageView = findViewById(R.id.image)

        val drawableResource = when (number) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        if(edit.length() != 0) {
            if (number == Integer.parseInt(edit.text.toString())) {
                Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Your loser...", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(this, "Preencha o campo.", Toast.LENGTH_SHORT).show()
        }

        image.setImageResource(drawableResource)
    }
}