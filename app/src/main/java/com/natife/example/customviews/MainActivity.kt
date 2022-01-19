package com.natife.example.customviews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test = findViewById<CustomLinearLayout>(R.id.custom_layout)

        test.addItem("item1")
        test.addItem("item2")
        test.addItem("item3")
        test.addItem("item4")
        test.addItem("item5")
    }

}