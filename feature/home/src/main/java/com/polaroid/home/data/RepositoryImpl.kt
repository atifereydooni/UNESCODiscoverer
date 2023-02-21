package com.polaroid.home.data

import com.polaroid.home.data.datasource.LocalDatasource
import com.polaroid.home.domain.entity.UNESCOSiteEntity
import com.polaroid.home.domain.repo.UNESCOSiteRepository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val localDatasource: LocalDatasource) :
    UNESCOSiteRepository {

    override suspend fun getAllUNESCOSite(): List<UNESCOSiteEntity> {
        return localDatasource.getAllUNESCOSite()
    }

}
