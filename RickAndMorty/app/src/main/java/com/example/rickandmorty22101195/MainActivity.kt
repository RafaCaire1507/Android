package com.example.rickandmorty22101195

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.rickandmorty22101195.dadosremotos.Personagem
import com.example.rickandmorty22101195.dadosremotos.retrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var editTextPersonagemID: EditText
    lateinit var buttonBuscar: Button
    lateinit var textViewNomeValor: TextView
    lateinit var textViewStatusValor: TextView
    lateinit var textViewEspeciesValor: TextView
    lateinit var textViewGeneroValor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextPersonagemID = findViewById(R.id.editTextPersonagemID)
        buttonBuscar = findViewById(R.id.buttonBuscar)
        textViewNomeValor = findViewById(R.id.textViewNomeValor)
        textViewStatusValor = findViewById(R.id.textViewStatusValor)
        textViewEspeciesValor = findViewById(R.id.textViewEspeciesValor)
        textViewGeneroValor = findViewById(R.id.textViewGeneroValor)

        buttonBuscar.setOnClickListener{
            var idDigitado: String = editTextPersonagemID.text.toString()

            retrofitService.getPersonagem(idDigitado.toInt()).enqueue(object : retrofit2.Callback<Personagem> {
                override fun onResponse(call: Call<Personagem>, response: Response<Personagem>) {
                    if(response.isSuccessful) {
                        textViewNomeValor.text = response.body()!!.nome
                        textViewStatusValor.text = response.body()!!.vivo
                        textViewEspeciesValor.text = response.body()!!.especie
                        textViewGeneroValor.text = response.body()!!.genero


                    } else{
                        Toast.makeText(this@MainActivity, "Ocorreu um erro", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Personagem>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Sem internet", Toast.LENGTH_SHORT).show()
                }

            })
        }



    }
}