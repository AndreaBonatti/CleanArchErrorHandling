package com.example.cleanarcherrorhandling.domain

import com.example.cleanarcherrorhandling.R
import com.example.cleanarcherrorhandling.data.MyRepositoryImpl
import com.example.cleanarcherrorhandling.util.Resource
import com.example.cleanarcherrorhandling.util.UiText

class SubmitEmailUseCase(
    private val repository: MyRepository = MyRepositoryImpl()
) {

    suspend fun execute(email: String): Resource<Unit> {
        if(!email.contains("@")) {
//            throw InvalidEmailException() /* we use the Resource instead */
            return Resource.Error(UiText.StringResource(R.string.error_invalid_email))
        }
        return repository.submitEmail(email)
    }

//    class InvalidEmailException: Exception("That is not a valid email")
}