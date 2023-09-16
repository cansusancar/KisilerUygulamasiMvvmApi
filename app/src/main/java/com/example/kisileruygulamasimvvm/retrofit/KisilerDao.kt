package com.example.kisileruygulamasimvvm.retrofit

import com.example.kisileruygulamasimvvm.data.entity.KisilerCevap
import retrofit2.Call
import retrofit2.http.GET

interface KisilerDao {
    //http://kasimadalan.pe.hu/kisiler/tum_kisiler.php

    @GET("kisiler/tum_kisiler.php")
    fun tumKisiler():Call<KisilerCevap>
}