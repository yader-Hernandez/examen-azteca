package com.example.examen_azteca.domain.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DatosPrueba(
    @SerializedName("items")
    @Expose
    var items: List<DatosIntems>
)

data class DatosIntems(
    @SerializedName("firebasescreen")
    @Expose
    var firebasescreen: String,
    @SerializedName("firebase_tipo")
    @Expose
    var firebase_tipo: String,
    @SerializedName("tituloselcolor")
    @Expose
    var tituloselcolor: String,
    @SerializedName("tipo")
    @Expose
    var tipo: String,
    @SerializedName("imagetv")
    @Expose
    var imagetv: String,
    @SerializedName("private")
    @Expose
    var private: String,
    @SerializedName("programa")
    @Expose
    var programa: String,
    @SerializedName("imagen")
    @Expose
    var imagen: String,
    @SerializedName("firebase_screen")
    @Expose
    var firebase_screen: String,
    @SerializedName("titulounselcolor")
    @Expose
    var titulounselcolor: String,
)
