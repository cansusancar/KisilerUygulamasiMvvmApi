package com.example.kisileruygulamasimvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasimvvm.data.entity.Kisiler
import com.example.kisileruygulamasimvvm.data.entity.KisilerCevap
import com.example.kisileruygulamasimvvm.retrofit.KisilerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KisilerDaRepository(var kdao:KisilerDao) {
    var kisilerListesi:MutableLiveData<List<Kisiler>>

    init {
        kisilerListesi = MutableLiveData()
    }

    fun kisileriGetir() : MutableLiveData<List<Kisiler>>{
        return kisilerListesi

    }

    fun kisiKayit(kisiAd:String, kisiTel:String){
        Log.e("Kişi Kayıt","$kisiAd - $kisiTel")
    }

    fun kisiGuncelle(kisiId: Int, kisiAd: String, kisiTel: String) {
        Log.e("Kişi Güncelle", "$kisiId - $kisiAd - $kisiTel")
    }

    fun kisiAra(aramaKelimesi:String){
        Log.e("Kişi Ara", aramaKelimesi)
    }

    fun kisiSil(kisiId: Int){
        Log.e("Kişi Sil",kisiId.toString())
    }

    fun tumKisileriAl(){
        kdao.tumKisiler().enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>) {
                val liste = response.body()!!.kisiler
                kisilerListesi.value = liste
            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {
            }

        })
    }
}