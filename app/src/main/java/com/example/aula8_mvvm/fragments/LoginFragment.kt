package com.example.aula8_mvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.aula8_mvvm.NavigationManager
import com.example.aula8_mvvm.R
import com.example.aula8_mvvm.activities.LoginActivity
import com.example.aula8_mvvm.viewmodels.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        ButterKnife.bind(this,view)
        return view
    }

    @OnClick(R.id.login_button)
    fun onClickLogin(){
        val username : EditText? = view?.findViewById(R.id.login_username)
        val password : EditText? = view?.findViewById(R.id.login_password)
        val userInfo = arrayListOf(username.toString(),password.toString())
        LoginActivity().enterCalculator(userInfo)
    }

    @OnClick(R.id.register_button)
    fun onClickGoToRegistry(){
        NavigationManager.goToRegisterFragment(activity?.supportFragmentManager!!)
    }
}
