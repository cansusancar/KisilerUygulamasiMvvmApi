package com.example.kisileruygulamasimvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


/*
****** Retrofit ********
* Android uygulamalarında kullanılan bir kütüphane
* Web Servisleriyle(API'ler) iletişim kurmak için kullanılır
* Application Programming Interface (Api) = Uygulama Programlama Arayüzü
* Http ve https isteklerini oluşturmak ve yanıtları işlemek için kullanılır.
* Kullandığımız api http ile başıyorsa manifest dosyasına  android:usesCleartextTraffic="true" eklememiz gerekir

 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}