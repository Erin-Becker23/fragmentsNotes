package com.example.fragmentsnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.fragmentsnotes.fragments.Fragment1
import com.example.fragmentsnotes.fragments.Fragment2


//fragments package holds our fragments
//can convert frameLayout to a constraintLayout in the fragments
//communicator is a new interface for the fragments

class MainActivity : AppCompatActivity(), Communicator { //add in communicator manually

    lateinit var fragButton1: Button
    lateinit var fragButton2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragButton1 = findViewById(R.id.frag_button1)
        fragButton2 = findViewById(R.id.frag_button2)

        val frag1 = Fragment1()
        val frag2 = Fragment2() //needed to import this in

        //Used to load a fragment at any time into our fragment container
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, frag1)
            commit()
        }

        fragButton1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, frag1)
                addToBackStack(null)
                commit()
            }
        }

        fragButton2.setOnClickListener{
            val userInput = findViewById<EditText>(R.id.data_editText) //creates/saves the text in frag1
            val userInput2 = findViewById<EditText>(R.id.data2_editText)
            frag2.arguments = passTheData(userInput.text.toString(), userInput2.text.toString())
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, frag2)
                addToBackStack(null)
                commit()
            }
//            val userInput2 = findViewById<EditText>(R.id.data2_editText)
//            frag2.arguments=passTheData(userInput2.text.toString())
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.fragmentContainer, frag2)
//                addToBackStack(null)
//                commit()
//            }
        }

    }

//     fun passTheData2(toString: String): Bundle {
//        val bundle2 = Bundle() //a bundle is the saved information
//        bundle2.putString("userText2", toString)
//        return bundle2
//    }

    override fun passTheData(passingText: String, passingText2: String): Bundle {
        val bundle = Bundle() //a bundle is the saved information
        bundle.putString("userText", passingText)
        bundle.putString("userText2", passingText2)
        return bundle
    }



}