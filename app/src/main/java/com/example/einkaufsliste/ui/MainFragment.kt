package com.example.einkaufsliste.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.einkaufsliste.databinding.FragmentMainBinding
import com.example.einkaufsliste.util.ArtikelAdapter


class MainFragment : Fragment() {

    // Binding & Viewmodel variable
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        //Binding
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Zeige Artikel Datenbank in RV
        viewModel.artikelListe.observe(viewLifecycleOwner){
            binding.artikelRV.adapter = ArtikelAdapter(it)
            
        }

        binding.artikelRV.setHasFixedSize(true)


    }

}