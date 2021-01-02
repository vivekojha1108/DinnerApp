package com.example.dinnerapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val foodList = arrayListOf("Desserts")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //selectedFoodText.text = " Burger King"
        currentList_txt.text = "Current Food List : " + foodList

        decide_btn.setOnClickListener {
//            println("You Clicked me...")

            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            selectedFoodText.text = foodList[randomFood]
        }

        addFood_btn.setOnClickListener {
            val newFood = addFood_text.text.toString()

            //check if the EditText have values or not
            if(newFood.trim().length>0) {
                Toast.makeText(applicationContext, newFood + " : Added", Toast.LENGTH_SHORT).show()
                foodList.add(newFood)
                addFood_text.text.clear()
                currentList_txt.text = "Current list : " + foodList
            }else{
                Toast.makeText(applicationContext, "Add food section should not be empty ", Toast.LENGTH_SHORT).show()
            }

            println(foodList)
        }

    }
}