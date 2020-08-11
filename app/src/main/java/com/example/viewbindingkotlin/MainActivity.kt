package com.example.viewbindingkotlin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.apply {
            text = "10"
            textSize = 30f
            isVisible = false
            setTextColor(resources.getColor(R.color.colorPrimaryDark))
        }
        editText.apply {
            setText("saurabh Bisht")

        }
     editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(it: Editable?) {
             Log.i("ViewBinding",it.toString())

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
       button.setOnClickListener {
           Toast.makeText(it.context,"toast generated",Toast.LENGTH_LONG).show()
       }
        button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View) {
                Toast.makeText(v.context,"toast generated from annooymous function",Toast.LENGTH_LONG).show()
            }

        })
        button.setOnClickListener(this)
    }
    override fun onClick(v: View) {

        Toast.makeText(v.context,"toast generated from interface function",Toast.LENGTH_LONG).show()
    }

}


