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
import com.example.fizzyquiz.databinding.FragmentSignupBinding

class SignUp : Fragment() {

    private lateinit var bind:FragmentSignupBinding
    private lateinit var databaseHelper:dbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind= FragmentSignupBinding.inflate(layoutInflater,container,false)
        databaseHelper= dbHelper(requireContext())


        bind.register.setOnClickListener {
            val username=bind.emailSignUp.text.toString()
            val password=bind.passwordSignUp.text.toString()
            signUpDatabase(username,password)
        }


        bind.AlreadyAccLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signUp_to_signIn2,null,NavOptions.Builder().setPopUpTo(R.id.signUp,true).build())
        }


        return bind.root
    }

    private fun signUpDatabase(username:String,password:String){
        val insertRowId=databaseHelper.insertUser(username,password)


        if (insertRowId!=-1L) {
            Toast.makeText(context, "Registered Successfully", Toast.LENGTH_SHORT).show()
            findNavController().navigate(
                R.id.action_signUp_to_signIn2,
                null,
                NavOptions.Builder().setPopUpTo(R.id.signUp, true).build()
            )

        }

        else{

            Toast.makeText(context,"Registration failed",Toast.LENGTH_SHORT).show()
        }





    }


}