package com.example.realworld_android_kotlin.view.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.realworld_android_kotlin.R
import com.example.realworld_android_kotlin.databinding.LoginFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        return binding.root
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.nextButton.setOnClickListener {
            viewModel.signIn(binding.editTextEmail.text.toString(),
                binding.editTextPassword.text.toString()).observe(viewLifecycleOwner, Observer {
                when(it.status) {
                }
            })
        }
    }

}