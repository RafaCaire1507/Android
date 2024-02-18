package com.example.rickandmorty22101195.dadosremotos

import com.google.gson.annotations.SerializedName

class Personagem (
    @SerializedName("name") var nome: String,
    @SerializedName("status") var vivo: String,
    @SerializedName("species") var especie: String,
    @SerializedName("gender") var genero: String,
    @SerializedName("image") var imagem: String
    )