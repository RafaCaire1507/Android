package com.example.buscacep_apirestretrofit.dadosremotos

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepApiService {


    @GET("ws/{cep}/json/")
    fun getEndereco(@Path("cep") cep: String) : Call<Endereco>

}