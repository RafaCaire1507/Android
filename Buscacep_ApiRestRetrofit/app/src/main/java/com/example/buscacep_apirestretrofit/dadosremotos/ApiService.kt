package com.example.buscacep_apirestretrofit.dadosremotos

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val URL_BASE: String = "https://viacep.com.br/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(URL_BASE)
    .build()

val retrofitService : ViaCepApiService by lazy {
    retrofit.create(ViaCepApiService::class.java)
}