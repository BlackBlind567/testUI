package com.example.shantanutest.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Locale

class LoginViewModel : ViewModel() {

    var panNumber: String = ""
    var birthDateDay: String = ""
    var birthDateMonth: String = ""
    var birthDateYear: String = ""

    private val _isButtonEnabled = MutableLiveData<Boolean>()
    val isButtonEnabled: LiveData<Boolean>
        get() = _isButtonEnabled

    init {
        // Initially disable the button
        _isButtonEnabled.value = false
    }

    // Method to perform all validations and update button enabled state
    fun validateFields() {
        // Launch a coroutine to perform validations asynchronously
        CoroutineScope(Dispatchers.Default).launch {
            val isPANValid = validatePAN()
            val isBirthDateValid = validateBirthDate()

            // Update button enabled state based on all validations
            _isButtonEnabled.value = isPANValid && isBirthDateValid
        }
    }

    suspend fun validatePAN(): Boolean {
        // Implement PAN number validation logic asynchronously
        return withContext(Dispatchers.Default) {
            panNumber.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}".toRegex())
        }
    }

    suspend fun validateBirthDate(): Boolean {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val dateString = "$birthDateDay/$birthDateMonth/$birthDateYear"
        println("DateParsing ==> $dateString")
        return withContext(Dispatchers.Default) {
            try {
                dateFormat.parse(dateString)
                true // Date is valid
            } catch (e: Exception) {
                false // Date is invalid
            }
        }
    }

}