package com.example.examen_azteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen_azteca.adapter.ImageAdapter
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
    private  lateinit var adapter: ImageAdapter
    private  val imagenes = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        adapter = ImageAdapter(imagenes)
        binding.rvImagen.layoutManager = LinearLayoutManager(this)
        binding.rvImagen.adapter = adapter
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
            val datos : DatosPrueba? = call.body()
            runOnUiThread{
                if (call.isSuccessful){
                    val imagenes: List<String> = datos?.items?.map { it.imagen } ?: emptyList()
                }
                else{
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this,"Ha ocurrido un error",Toast.LENGTH_LONG).show()
    }
}