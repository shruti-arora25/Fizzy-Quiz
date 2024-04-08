package com.example.fizzyquiz.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fizzyquiz.databinding.FragmentLeaderPageBinding


class LeaderPage : Fragment() {


    private lateinit var bind:FragmentLeaderPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bind= FragmentLeaderPageBinding.inflate(layoutInflater,container,false)
        return bind.root

    }



}