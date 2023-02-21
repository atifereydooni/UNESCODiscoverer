package com.polaroid.home.data.datasource

import com.polaroid.home.domain.entity.UNESCOSiteEntity

interface LocalDatasource {

    suspend fun getAllUNESCOSite(): List<UNESCOSiteEntity>

}
