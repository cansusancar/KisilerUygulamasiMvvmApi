package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.data.entity.Kisiler
import com.example.kisileruygulamasimvvm.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasimvvm.ui.adapter.KisilerAdapter

class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim: FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater,container,false)

        tasarim.toolbarAnasayfa.title = "Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        tasarim.rv.layoutManager = LinearLayoutManager(requireContext())

        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","1111")
        val k2 = Kisiler(2,"Helin","2222")
        val k3 = Kisiler(3,"Orcan","444")
        val k5 = Kisiler(4,"Döne","7777")
        val k6 = Kisiler(4,"Büşra","6666")
        val k7 = Kisiler(4,"Nazlıcan","0000")
        val k8 = Kisiler(4,"Türkan","8598")
        val k9 = Kisiler(4,"Can","85847")

        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        kisilerListesi.add(k5)
        kisilerListesi.add(k6)
        kisilerListesi.add(k7)
        kisilerListesi.add(k8)
        kisilerListesi.add(k9)

        val adapter = KisilerAdapter(requireContext(),kisilerListesi)
        tasarim.rv.adapter = adapter



        tasarim.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)

                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView

                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return tasarim.root
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        ara(newText)
        return true
    }

    fun ara(aramaKelimesi:String){
        Log.e("Kişi Ara",aramaKelimesi)
    }

}