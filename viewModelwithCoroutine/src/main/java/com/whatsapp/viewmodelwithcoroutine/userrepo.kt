package com.whatsapp.viewmodelwithcoroutine

import kotlinx.coroutines.delay

class userrepo {
    suspend fun getUsers():List<user>{
        delay(8000)
        val users:List<user> =listOf(user(1,"basu"),user(2,"sourjya"),user(3,"bose"))

     return users
    }
}