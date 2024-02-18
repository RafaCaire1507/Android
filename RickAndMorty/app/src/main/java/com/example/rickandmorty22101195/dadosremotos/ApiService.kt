package com.example.rickandmorty22101195.dadosremotos

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val URL_BASE = "https://rickandmortyapi.com/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(URL_BASE)
    .build()

val retrofitService : RickAndMortyApiService by lazy {
    retrofit.create(RickAndMortyApiService::class.java)
}