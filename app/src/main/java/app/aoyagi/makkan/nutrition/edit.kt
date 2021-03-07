package app.aoyagi.makkan.nutrition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*

class edit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        add.setOnClickListener {
            if (editText.text != null) {
                textView.text = editText.text.toString()
                val mainIntent = Intent(this,MainActivity::class.java)
                mainIntent.putExtra("redIntent",editText.text.toString())
                startActivity(mainIntent)
            }
        }
    }


}


