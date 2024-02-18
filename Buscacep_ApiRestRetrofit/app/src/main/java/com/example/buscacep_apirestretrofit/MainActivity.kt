package com.example.buscacep_apirestretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.buscacep_apirestretrofit.dadosremotos.Endereco
import com.example.buscacep_apirestretrofit.dadosremotos.retrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var editTextCep: EditText
    lateinit var ButtonBuscar: Button
    lateinit var textViewRuaValor: TextView
    lateinit var textViewCidadeValor: TextView
    lateinit var textViewEstadoValor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextCep = findViewById(R.id.editTextCep)
        ButtonBuscar = findViewById(R.id.ButtonBuscar)
        textViewRuaValor = findViewById(R.id.textViewRuaValor)
        textViewCidadeValor = findViewById(R.id.textViewCidadeValor)
        textViewEstadoValor = findViewById(R.id.textViewEstadoValor)

        ButtonBuscar.setOnClickListener {
            var cepDigitado: String = editTextCep.text.toString()

            retrofitService.getEndereco(cepDigitado).enqueue(object : Callback<Endereco> {
                override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                    if(response.isSuccessful) {
                        textViewRuaValor.text = response.body()!!.rua
                        textViewCidadeValor.text = response.body()!!.cidade
                        textViewEstadoValor.text = response.body()!!.estado

                    } else{
                        Toast.makeText(this@MainActivity, "Ocorreu um erro", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Endereco>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Sem internet", Toast.LENGTH_SHORT).show()
                }

            })
        }

    }
}