package com.example.aula8_mvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.OnClick
import butterknife.Optional
import com.example.aula8_mvvm.NavigationManager
import com.example.aula8_mvvm.R


class RegisterFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    @OnClick(R.id.register_button)
    fun onClickGoToRegistry(){
        NavigationManager.goToRegisterFragment(activity?.supportFragmentManager!!)
    }


}
