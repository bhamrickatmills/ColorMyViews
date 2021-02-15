package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

private lateinit var binding: ActivityMainBinding

private lateinit var boxes: List<TextView>
private val randomColors: List<Int> = listOf(Color.RED, Color.GRAY, Color.BLUE, Color.MAGENTA, Color.LTGRAY, Color.CYAN, Color.GREEN, Color.BLACK)
private var RED: Int = 0
private var YELLOW: Int = 0
private var GREEN: Int = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        boxes = listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText, binding.boxFourText, binding.boxFiveText)
        setColors()
        setListeners()
    }

    /*
     * Set color values.
     */
    private fun setColors() {
        RED = R.color.my_red
        YELLOW = R.color.my_yellow
        GREEN = R.color.my_green
    }

    /*
     * Randomly assigns a color to a text box.
     */
    private fun makeColored(view: View) {
        val randInt = Random.nextInt(randomColors.indices)
        when (view.id) {
            boxes[0].id, boxes[1].id, boxes[2].id, boxes[3].id, boxes[4].id -> view.setBackgroundColor(randomColors[randInt])
            else ->  view.setBackgroundColor(randomColors[randInt])
        }
    }

    /*
     * Initialize listeners.
     */
    private fun setListeners() {
        binding.apply {
            redButton.setOnClickListener { clickToColor(RED) }
            yellowButton.setOnClickListener { clickToColor(YELLOW) }
            greenButton.setOnClickListener { clickToColor(GREEN) }
            constraintLayout.setOnClickListener { makeColored(constraintLayout) }
        }
        boxes.forEach { it.setOnClickListener { makeColored(it) } }
    }

    /*
     * Change the color of a random text box on screen and randomize box size.
     */
    private fun clickToColor(c: Int) {
        boxes[Random.nextInt(boxes.indices)].apply {
            setTextColor(if (c == YELLOW) Color.BLACK else Color.WHITE)
            setBackgroundResource(c)
            scaleX = Random.nextFloat() + Random.nextInt(0..2)
            scaleY = Random.nextFloat() + Random.nextInt(0..2)
        }
    }
}