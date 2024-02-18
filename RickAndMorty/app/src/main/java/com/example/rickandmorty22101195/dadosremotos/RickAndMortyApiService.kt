package com.example.rickandmorty22101195.dadosremotos

import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApiService {

    @GET("character/{id}")
    fun getPersonagem(@Path("id") id:Int) : retrofit2.Call<Personagem>
}