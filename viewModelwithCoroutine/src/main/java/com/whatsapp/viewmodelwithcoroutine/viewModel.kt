package com.whatsapp.viewmodelwithcoroutine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class viewModel: ViewModel() {
    var usrs: MutableLiveData<List<user>> = MutableLiveData()
    private var userRepo=userrepo()
   // private val myJob= Job()
    //private val myscope= CoroutineScope(Dispatchers.IO+myJob)
    fun getUserData(){
        viewModelScope.launch{
            var result:List<user>?=null
            withContext(Dispatchers.IO){
                result=userRepo.getUsers()
            }
            usrs.value=result
        }
    }
 /*   override fun onCleared(){
        super.onCleared()
        myJob.cancel()
    }*/



}
