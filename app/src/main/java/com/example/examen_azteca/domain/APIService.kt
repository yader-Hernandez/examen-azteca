package com.example.examen_azteca.domain

import com.example.examen_azteca.domain.models.DatosIntems
import com.example.examen_azteca.domain.models.DatosPrueba
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    fun getDatos(@Url url:String): Response<DatosPrueba>
}