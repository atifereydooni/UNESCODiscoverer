package com.polaroid.home.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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

    val unescoSiteState: MutableState<UNESCOSiteState> = mutableStateOf(UNESCOSiteState())

    init {
        getUNESCOSite()
    }

    fun getUNESCOSite() = viewModelScope.launch {
        if (unescoSiteState.value.page == 1 ||
            (unescoSiteState.value.page != 1 && unescoSiteState.value.canPaginate) &&
            unescoSiteState.value.listState == ListState.IDLE
        ) {
            unescoSiteState.value = unescoSiteState.value.copy(
                listState = ListState.PAGINATING
            )

            val list = getUNESCOSiteUseCase.getAllUNESCOSite(unescoSiteState.value.page)
            unescoSiteState.value = unescoSiteState.value.copy(
                canPaginate = list.size < 1090
            )

            if (unescoSiteState.value.page == 1) {
                unescoSiteState.value.UNESCOSiteList.clear()
                unescoSiteState.value.UNESCOSiteList.addAll(list)
            } else {
                unescoSiteState.value.UNESCOSiteList.addAll(list)
            }

            unescoSiteState.value = unescoSiteState.value.copy(
                listState = ListState.IDLE
            )

            if (unescoSiteState.value.canPaginate)
                unescoSiteState.value = unescoSiteState.value.copy(
                    page = unescoSiteState.value.page + 1
                )
        }
    }

    override fun onCleared() {
        unescoSiteState.value = unescoSiteState.value.copy(
            page = 1,
            listState = ListState.IDLE,
            canPaginate = false
        )
        super.onCleared()
    }
}