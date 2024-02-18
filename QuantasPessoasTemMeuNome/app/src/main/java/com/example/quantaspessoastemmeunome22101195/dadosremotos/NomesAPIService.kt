package com.example.quantaspessoastemmeunome22101195.dadosremotos

import retrofit2.http.GET
import retrofit2.http.Path

interface NomesAPIService {

    @GET("{nome}")
    fun getFrequenciaNomePorDecada(@Path("nome") nome : String) : retrofit2.Call<List<RespostaNome>>
}