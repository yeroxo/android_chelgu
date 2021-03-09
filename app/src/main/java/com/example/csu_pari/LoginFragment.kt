package com.example.csu_pari

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.csu_pari.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private var binding: LoginFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding!!.root
    }

    override fun onResume() {
        super.onResume()
        Log.d("check", "fragment Resume")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        if (sharedPref?.getString(
                getString(R.string.pass_tmp),
                null
            ) != null && sharedPref.getString(getString(R.string.login_tmp), null) != null
        ) {
            findNavController().navigate(R.id.action_loginFragment_to_SecondFragment)
        } else {
            binding?.buttonLogin?.setOnClickListener {
                var name = binding?.editTextTextPersonName?.text.toString()
                var pass = binding?.editTextTextPassword?.text.toString()
                if (sharedPref != null) {
                    with(sharedPref.edit()) {
                        putString(getString(R.string.login_tmp), name)
                        putString(getString(R.string.pass_tmp), pass)
                        apply()
                    }
                }
                findNavController().navigate(R.id.action_loginFragment_to_SecondFragment)
            }
        }


    }
}