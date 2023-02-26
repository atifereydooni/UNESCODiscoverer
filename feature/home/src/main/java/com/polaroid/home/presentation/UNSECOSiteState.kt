package com.polaroid.home.presentation

import com.polaroid.home.domain.entity.UNESCOSiteEntity

data class UNESCOSiteState(
    val UNESCOSiteList: MutableList<UNESCOSiteEntity> = mutableListOf(),
    val page: Int = 1,
    val canPaginate: Boolean = false,
    val listState: ListState = ListState.IDLE
)

enum class ListState {
    IDLE,
    PAGINATING
}
