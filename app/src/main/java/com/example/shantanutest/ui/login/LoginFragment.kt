package com.example.shantanutest.ui.login

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import com.example.shantanutest.R
import com.example.shantanutest.databinding.FragmentLoginBinding
import com.example.shantanutest.ui.base.BaseFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
* Recreated on 23 March 2024 @ 10:45 By BlackBlind
* */


class LoginFragment : BaseFragment<FragmentLoginBinding>(
    FragmentLoginBinding::inflate
) {

    private val viewModel by viewModels<LoginViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etPan.doOnTextChanged { text, _, _, _ ->
            viewModel.panNumber = text.toString()
            // Validate PAN number

            CoroutineScope(Dispatchers.Default).launch {
                if (!viewModel.validatePAN()) {
                    binding.etPan.error = "Invalid PAN number"
                } else {
                    binding.etPan.error = null

                }
                viewModel.validateFields()
            }
        }
        // validate date of birth
        binding.etDate.doOnTextChanged { text, _, _, _ ->
            viewModel.birthDateDay = text.toString()
            validateBirthDate()
            viewModel.validateFields()
        }

        binding.etMonth.doOnTextChanged { text, _, _, _ ->
            viewModel.birthDateMonth = text.toString()
            validateBirthDate()
            viewModel.validateFields()
        }

        binding.etYear.doOnTextChanged { text, _, _, _ ->
            var yearValue = text.toString()
            if (yearValue.length == 4) {
                viewModel.birthDateYear = text.toString()
                validateBirthDate()
                viewModel.validateFields()
            }
        }

        binding.btnNext.setOnClickListener {
            if (viewModel.isButtonEnabled.value == true) {
                Toast.makeText(requireContext(), "Details submitted", Toast.LENGTH_SHORT).show()
                requireActivity().finish()
            }
        }

        viewModel.isButtonEnabled.observe(viewLifecycleOwner, Observer {
            binding.btnNext.isEnabled = it
        })

        binding.doNotHavePanTv.setOnClickListener {
            requireActivity().finish()
        }
    }

    private fun validateBirthDate() {
        // Validate birthdate
        CoroutineScope(Dispatchers.Default).launch {
            if (!viewModel.validateBirthDate()) {
//            Toast.makeText(requireContext(), "Date is invalid", Toast.LENGTH_SHORT).show()
            } else {
                binding.etDate.error = null
                binding.etMonth.error = null
                binding.etYear.error = null
            }
        }
    }
}