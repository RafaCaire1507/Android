package com.example.buscacep_apirestretrofit.dadosremotos

import com.google.gson.annotations.SerializedName

class Endereco (
    @SerializedName("logradouro") var rua: String,
    @SerializedName("localidade") var cidade: String,
    @SerializedName("uf") var estado: String
)