package app.aoyagi.makkan.nutrition

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    var red_point: Float=0.0F
    var yellow_point:Float=0.0F
    var green_point=0.0F
    var red_intent = 0.0F


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            onigiri.setOnClickListener { add_nuttrition(1F, 0F, 2F)
            }
            pan.setOnClickListener { add_nuttrition(3F,8F,3F)

            }
            udon.setOnClickListener { add_nuttrition(4F,9F,2F)
            }
            soba.setOnClickListener { add_nuttrition(5F,1F,5F)
            }
            ramen.setOnClickListener { add_nuttrition(6F,1F,2F)
            }
            sakana.setOnClickListener { add_nuttrition(1F,0F,2F)
            }
            pasuta.setOnClickListener { add_nuttrition(0F,0F,1F)
            }
            piza.setOnClickListener { add_nuttrition(0F,0F,1F)
            }
            clear.setOnClickListener {
                red_point = 0F
                green_point = 0F
                yellow_point = 0F
                red.text = red_point.toString()
                green.text = green_point.toString()
                yellow.text = yellow_point.toString()
            }
            project.setOnClickListener {
                val toEditActivityIntent= Intent(this,edit::class.java)
                startActivity(toEditActivityIntent)
                val requestCode: Int = 1000
                startActivityForResult(intent, requestCode)
            }
            free.setOnClickListener {
                val red_edit: String = red_field.text.toString()
                val yellow_edit = yellow_field.text.toString()
                val green_edit = green_field.text.toString()
                red.text = (red_point + red_edit.toFloat()).toString()
                yellow.text = (yellow_point + yellow_edit.toFloat()).toString()
                green.text = (green_point + green_edit.toFloat()).toString()
            }

        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK &&
                requestCode == 1000 && intent != null) {
            red_intent = intent.getStringExtra("redIntent").toFloat()
            red.text = (red_point + red_intent).toString()
        }
    }


    fun add_nuttrition (num1 : Float, num2 :Float,num3 :Float){
        red_point += num1
        green_point += num2
        yellow_point += num3
        red.text = red_point.toString()
        green.text = green_point.toString()
        yellow.text = yellow_point.toString()
    }
}