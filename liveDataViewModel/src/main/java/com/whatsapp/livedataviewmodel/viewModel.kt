package com.whatsapp.livedataviewmodel

import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class viewModel : ViewModel() {
  var i= MutableLiveData<Int>()
    init{
        i.value=0;
    }
    fun click(){

        i.value=(i.value?:0)+1
    }
}