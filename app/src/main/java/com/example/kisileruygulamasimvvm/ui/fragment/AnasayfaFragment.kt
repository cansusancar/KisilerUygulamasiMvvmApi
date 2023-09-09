package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var tasarim: FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater,container,false)

        tasarim.toolbarAnasayfa.title = "Kişiler"

        tasarim.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }

        return tasarim.root
    }

}