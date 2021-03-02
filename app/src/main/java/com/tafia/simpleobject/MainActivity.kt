package com.tafia.simpleobject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.TextView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val windowwidth = windowManager.defaultDisplay.width;
        val windowheight = windowManager.defaultDisplay.height;

        val ballObject = findViewById<TextView>(R.id.ballObject)
        
        ballObject.setOnTouchListener { v, event ->
            val lp = ballObject.layoutParams as LinearLayout.LayoutParams
            when(event.action){
                MotionEvent.ACTION_DOWN -> {

                }
                MotionEvent.ACTION_MOVE -> {
                    var x = event.rawX.toInt()
                    var y = event.rawY.toInt()

                    if(x > windowwidth)
                        x = windowwidth
                    else if(x < 0)
                        x = 0

                    if(y > windowheight)
                        y = windowheight
                    else if(y < 0)
                        y = 0

                    lp.leftMargin = x - 25
                    lp.rightMargin = y - 75
                    ballObject.layoutParams = lp
                }
            }
            return@setOnTouchListener true
        }
    }
}