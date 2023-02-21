package com.polaroid.home.domain.repo

import com.polaroid.home.domain.entity.UNESCOSiteEntity

interface UNESCOSiteRepository {

    suspend fun getAllUNESCOSite(): List<UNESCOSiteEntity>

}
