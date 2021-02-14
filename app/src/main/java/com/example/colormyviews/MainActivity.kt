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
private val randomColors: List<Int> = listOf(Color.RED, Color.GRAY, Color.BLUE, Color.MAGENTA, Color.LTGRAY, Color.CYAN, Color.GREEN, Color.BLACK, Color.WHITE)
private var RED: Int = 0
private var YELLOW: Int = 0
private var GREEN: Int = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        RED = R.color.my_red
        YELLOW = R.color.my_yellow
        GREEN = R.color.my_green
        boxes = listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText, binding.boxFourText, binding.boxFiveText)
        setListeners()
    }

    /*
     * Randomly assigns a color to a text box.
     */
    private fun makeColored(view: View) {
        val randInt = Random.nextInt(randomColors.indices)
        when (view.id) {
            binding.boxOneText.id -> view.setBackgroundColor(randomColors[randInt])
            binding.boxTwoText.id -> view.setBackgroundColor(randomColors[randInt])
            binding.boxThreeText.id -> view.setBackgroundColor(randomColors[randInt])
            binding.boxFourText.id -> view.setBackgroundColor(randomColors[randInt])
            binding.boxFiveText.id -> view.setBackgroundColor(randomColors[randInt])
            else ->  view.setBackgroundColor(randomColors[randInt])
        }
    }

    /*
     * Initialize listeners.
     */
    private fun setListeners() {
        val rootConstraintLayout = binding.constraintLayout
        val clickableViews: List<View> = boxes
        rootConstraintLayout.setOnClickListener{makeColored(rootConstraintLayout)}
        clickableViews.forEach { it.setOnClickListener{makeColored(it)}}
        binding.apply {
            redButton.setOnClickListener { clickToColor(RED) }
            yellowButton.setOnClickListener { clickToColor(YELLOW) }
            greenButton.setOnClickListener { clickToColor(GREEN) }
        }
    }

    /*
     * Change the color of a random text box on screen.
     */
    private fun clickToColor(c: Int){
        val randBox = boxes[Random.nextInt(boxes.indices)]
        if(c == YELLOW){
            randBox.setTextColor(Color.BLACK)
        } else {
            randBox.setTextColor(Color.WHITE)
        }
        randBox.setBackgroundResource(c)
        randBox.scaleX = Random.nextFloat() + Random.nextInt(0..2)
        randBox.scaleY = Random.nextFloat() + Random.nextInt(0..2)
    }
}