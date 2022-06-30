package com.example.examen_azteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examen_azteca.databinding.ActivityMainBinding
import com.example.examen_azteca.domain.APIService
import com.example.examen_azteca.domain.models.DatosIntems
import com.example.examen_azteca.domain.models.DatosPrueba
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://tiradodev.github.io/appLite/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun imagenes(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getDatos("pruebaAzteca")
            val datos : DatosIntems? = call.body()
            if (call.isSuccessful){

            }
            else{

            }
        }
    }
}