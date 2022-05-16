package com.example.codenwin.utils

import android.util.Log
import com.example.codenwin.utils.Constants.OPEN_GOOGLE
import com.example.codenwin.utils.Constants.OPEN_SEARCH
import java.security.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object GeneralMessage {
    fun basicResponse(_message:String):String{
        val random = (0..2).random()
        val message = _message.toLowerCase()
        return when{
            message.contains("hello",ignoreCase = true) -> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Buongiorno!"
                    else -> "error" }
            }
            message.contains("hi",ignoreCase = true) -> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Buongiorno!"
                    else -> "error" }
            }
            message.contains("hey",ignoreCase = true) -> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Buongiorno!"
                    else -> "error" }
            }
            message.contains("Tringapps Domains",ignoreCase = true) -> {
                "Android,QA,WEB,IOS,Inside Sales"
            }
            message.contains("Tringapps HR",ignoreCase = true) -> {
                "Eswari"
            }
            message.contains("ENews reporting manager",ignoreCase = true) -> {
                "Uvnesh Kumar"
            }
            message.contains("Tringapps TeamLead",ignoreCase = true) -> {
                "Android:Sankar ,Manual QA:Lakshmi,Automation QA:Rafi,Web:Prabha,IOS:Gowri Shankar"
            }
            message.contains("Tringapps CEO",ignoreCase = true) -> {
                "Shaun Kumar"
            }
            message.contains("Tringapps location",ignoreCase = true)  -> {
                "Chennai,New York,Madurai,California"
            }
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }
            message.contains("time") && message.contains("?")-> {
                val timeStamp = java.sql.Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }
            message.contains("search")-> {
                OPEN_SEARCH
            }
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}