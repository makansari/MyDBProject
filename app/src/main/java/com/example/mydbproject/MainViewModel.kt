package com.example.mydbproject

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    lateinit var timer : CountDownTimer

   /* var numb = 0

    fun incNumber(){
        numb ++
    }*/

    var sec = MutableLiveData<Int>()
    var countfinish= MutableLiveData<Boolean>()

    fun startTimer(){
        timer  = object  : CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                var timeleft = p0/1000
                sec.value = timeleft.toInt()
            }

            override fun onFinish() {
                countfinish.value = true
            }

        }.start()
    }

    fun stopTimer(){
        timer.cancel()
    }

}