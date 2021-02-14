package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun makeColored(view: View){
        when(view.id){
            binding.boxOneText.id -> view.setBackgroundColor(Color.RED)
            binding.boxTwoText.id  -> view.setBackgroundColor(Color.GRAY)
            binding.boxThreeText.id  -> view.setBackgroundColor(Color.BLUE)
            binding.boxFourText.id  -> view.setBackgroundColor(Color.MAGENTA)
            binding.boxFiveText.id -> view.setBackgroundColor(Color.BLUE)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners(){
        val boxOne = binding.boxOneText
        val boxTwo = binding.boxTwoText
        val boxThree = binding.boxThreeText
        val boxFour = binding.boxFourText
        val boxFive = binding.boxFiveText

        val rootConstraintLayout = binding.constraintLayout

        val clickableViews: List<View> =
           listOf(boxOne, boxTwo, boxThree, boxFour, boxFive, rootConstraintLayout)

        for (veiw in clickableViews){
            veiw.setOnClickListener {makeColored(it)}
        }
    }
}