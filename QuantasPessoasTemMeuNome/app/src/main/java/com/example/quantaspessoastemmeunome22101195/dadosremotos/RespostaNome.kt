package com.example.quantaspessoastemmeunome22101195.dadosremotos

import com.google.gson.annotations.SerializedName

class RespostaNome (
    @SerializedName("nome") var nome:String,
    @SerializedName("res") var res: List<Frequencia>
    )

class Frequencia(
    @SerializedName("periodo") var periodo: String,
    @SerializedName("frequencia") var frequencia: String
)