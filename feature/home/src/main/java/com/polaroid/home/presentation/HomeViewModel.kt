package com.polaroid.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polaroid.home.domain.usecase.GetUNESCOSiteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val getUNESCOSiteUseCase: GetUNESCOSiteUseCase
) : ViewModel() {

    init {
        getAllUNESCOSite()
    }

    private fun getAllUNESCOSite() {
        viewModelScope.launch {
            Log.d("HomeViewModel", "Success: " + getUNESCOSiteUseCase.getAllUNESCOSite())
        }
    }

}