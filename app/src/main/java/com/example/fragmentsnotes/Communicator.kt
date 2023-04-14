package com.example.fragmentsnotes

import android.os.Bundle

interface Communicator {

    fun passTheData(passingText:String, passingText2: String):Bundle

}