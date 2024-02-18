package com.example.quantaspessoastemmeunome22101195

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quantaspessoastemmeunome22101195.dadosremotos.RespostaNome
import com.example.quantaspessoastemmeunome22101195.dadosremotos.retrofitService
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var buttonPesquisar: Button
    lateinit var editTextTextNomePessoa: EditText
    lateinit var RecyclerViewFrequencia: RecyclerView
    lateinit var frequenciaAdapter : FrequenciaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonPesquisar = findViewById(R.id.buttonPesquisar)
        editTextTextNomePessoa = findViewById(R.id.editTextTextNomePessoa)
        RecyclerViewFrequencia = findViewById(R.id.RecyclerViewFrequencia)

        frequenciaAdapter = FrequenciaAdapter()
        RecyclerViewFrequencia.adapter = frequenciaAdapter
        RecyclerViewFrequencia.layoutManager = LinearLayoutManager(this)

        buttonPesquisar.setOnClickListener{
            var nomeDigitado: String = editTextTextNomePessoa.text.toString()

            retrofitService.getFrequenciaNomePorDecada(nomeDigitado).enqueue(object : retrofit2.Callback<List<RespostaNome>> {
                override fun onResponse(
                    call: Call<List<RespostaNome>>,
                    response: Response<List<RespostaNome>>
                ) {
                    if (response.isSuccessful) {
                        frequenciaAdapter.setNovaFrequencias(response.body()!![0].res)

                    }
                }

                override fun onFailure(call: Call<List<RespostaNome>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Você está sem internet", Toast.LENGTH_SHORT).show()
                    }

            })
        }


    }
}