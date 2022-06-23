package com.example.cleanarcherrorhandling.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarcherrorhandling.domain.SubmitEmailUseCase
import com.example.cleanarcherrorhandling.util.Resource
import com.example.cleanarcherrorhandling.util.UiText
import kotlinx.coroutines.launch

class MyViewModel(
    private val submitEmailUseCase: SubmitEmailUseCase = SubmitEmailUseCase()
) : ViewModel() {

    var email by mutableStateOf("")
        private set

    var error by mutableStateOf<UiText?>(null) /* null => no error */
        private set

    fun onEmailChanged(email: String) {
        this.email = email
    }

    fun submitEmail() {
        viewModelScope.launch {
            val result = submitEmailUseCase.execute(email)
            when(result) {
                is Resource.Success -> {

                }
                is Resource.Error -> {
                    error = result.message
                }
            }
        }
    }
}