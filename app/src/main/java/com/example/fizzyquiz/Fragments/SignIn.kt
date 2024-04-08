package com.example.fizzyquiz.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.fizzyquiz.DataBase.dbHelper
import com.example.fizzyquiz.R
import com.example.fizzyquiz.databinding.FragmentSignInBinding


class SignIn : Fragment() {

    private lateinit var bind:FragmentSignInBinding
    private lateinit var databaseHelper: dbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        bind= FragmentSignInBinding.inflate(layoutInflater, container, false)



        bind.signIn.setOnClickListener {
            val user=bind.enailLogin.text.toString()
            val pass=bind.passwordLogin.text.toString()
            loginUser(user,pass)
        }

        bind.createAccount.setOnClickListener {
            findNavController().navigate(R.id.action_signIn2_to_signUp,null,NavOptions.Builder().setPopUpTo(R.id.signIn2,true).build())
        }






        return bind.root
    }


    private fun loginUser(username:String,password:String){

        val existUser=databaseHelper.readUser(username,password)
        if (existUser){
            Toast.makeText(requireContext(),"Login Successfully",Toast.LENGTH_SHORT).show()


            findNavController().navigate(R.id.action_signIn2_to_leaderPage,null,NavOptions.Builder().setPopUpTo(R.id.signIn2,true).build())
        }
        else{

            Toast.makeText(requireContext(),"Login Failed!",Toast.LENGTH_SHORT).show()

        }

    }

}