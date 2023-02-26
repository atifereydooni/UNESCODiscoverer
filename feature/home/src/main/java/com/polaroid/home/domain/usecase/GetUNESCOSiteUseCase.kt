package com.polaroid.home.domain.usecase

import com.polaroid.home.domain.entity.UNESCOSiteEntity
import com.polaroid.home.domain.repo.UNESCOSiteRepository
import javax.inject.Inject

class GetUNESCOSiteUseCase @Inject constructor(private val repository: UNESCOSiteRepository) {

    suspend fun getAllUNESCOSite(page: Int): List<UNESCOSiteEntity> {
        return repository.getAllUNESCOSite().sortedBy { it.id }.subList((page - 1) * 10, page * 10)
    }
}
