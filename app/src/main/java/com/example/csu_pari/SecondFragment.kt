package com.example.csu_pari

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.csu_pari.dataBase.AppDataBase
import com.example.csu_pari.dataBase.GopherRaceGenerator
import com.example.csu_pari.databinding.FragmentSecondBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var binding: FragmentSecondBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = AppDataBase.createDb(requireContext()).getGopherDao()
        binding?.loadBtn?.setOnClickListener {
            val corutine = CoroutineScope(Dispatchers.IO)
            corutine.launch {
                val gopherGenerator = GopherRaceGenerator()
                val gophers = gopherGenerator.generate(1, 10)
                for (gopher in gophers) {
                    dao.insert(gopher)
                    Log.d("TEST_DB", gopher.job + " " + gopher.name + " " + gopher.age)
                }
            }.apply {
                Toast.makeText(requireContext(), "GOPHERS ADDED", Toast.LENGTH_LONG).show()
            }

        }

        binding?.showBtn?.setOnClickListener {
            val corutine = CoroutineScope(Dispatchers.IO)
            corutine.launch {
                val gophers = dao.getGophers()
                var endText = ""
                for (gopher in gophers) {
                    endText += " " + gopher.toString()
                }
                binding?.modelView?.text = endText
            }
        }

        binding?.clearBtn?.setOnClickListener {
            val corutine = CoroutineScope(Dispatchers.IO)
            corutine.launch {
                dao.clearTable()
            }.apply {
                Toast.makeText(requireContext(), "GOPHERS DELETED", Toast.LENGTH_LONG).show()
            }

        }
    }
}