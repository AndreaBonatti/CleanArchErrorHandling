package com.example.cleanarcherrorhandling.data

import com.example.cleanarcherrorhandling.domain.MyRepository
import com.example.cleanarcherrorhandling.util.Resource
import com.example.cleanarcherrorhandling.util.UiText
import kotlinx.coroutines.delay
import kotlin.random.Random

class MyRepositoryImpl : MyRepository{
    // Email sending simulation
    override suspend fun submitEmail(email: String): Resource<Unit> {
        delay(500L)
        return if(Random.nextBoolean()) {
             Resource.Success(Unit)
        } else {
            if(Random.nextBoolean()){
                Resource.Error(UiText.DynamicString("Server error"))
            } else {
                Resource.Error(UiText.DynamicString("Not authenticated error"))
            }
        }
    }
}