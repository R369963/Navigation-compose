package com.example.nav.vimodel

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nav.api.networkRepository
import com.example.nav.model.Products
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class ProductViewModel:ViewModel(){
    val apiService = networkRepository.api
    private val _items = MutableStateFlow<List<Products>>(emptyList())
    var productList: StateFlow<List<Products>> = _items

    init {
        getProducts()
    }

    @SuppressLint("SuspiciousIndentation")
    fun getProducts(){
        viewModelScope.launch {
            try {
                val response = apiService.getProductList()
                if (response.isNotEmpty()){
                    _items.value = response
                }
            } catch (e: Exception) {
                // Handle the exception
            }
        }
    }
}
