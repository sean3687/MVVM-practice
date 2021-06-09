package com.tassiecomp.recyclerviewactivity.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object{
        val baseUrl = "https://api.github.com/search/"
        fun getRetroInstance(): Retrofit {
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }
}