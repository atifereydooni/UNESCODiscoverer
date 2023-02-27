package com.polaroid.home.domain.usecase

import com.polaroid.home.domain.entity.UNESCOSiteEntity
import com.polaroid.home.domain.repo.UNESCOSiteRepository
import javax.inject.Inject

class GetUNESCOSiteUseCase @Inject constructor(private val repository: UNESCOSiteRepository) {

    suspend fun getAllUNESCOSite(page: Int): List<UNESCOSiteEntity> {
        val UNESCOSites = repository.getAllUNESCOSite()
        return UNESCOSites.sortedBy { it.id!!.toInt() }.subList(
            (page - 1) * 10,
            if (page * 10 < UNESCOSites.size) page * 10 else UNESCOSites.size
        )
    }
}
