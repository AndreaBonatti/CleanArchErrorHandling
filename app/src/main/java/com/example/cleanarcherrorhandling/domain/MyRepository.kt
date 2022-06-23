package com.example.cleanarcherrorhandling.domain

import com.example.cleanarcherrorhandling.util.Resource

interface MyRepository {
    suspend fun submitEmail(email: String): Resource<Unit>
}