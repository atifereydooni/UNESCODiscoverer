package com.polaroid.home.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.gson.Gson
import com.polaroid.home.data.RepositoryImpl
import com.polaroid.home.data.datasource.LocalDatasource
import com.polaroid.home.domain.repo.UNESCOSiteRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.spyk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class GetUNESCOSiteUseCaseTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    private val testCoroutineDispatcher = UnconfinedTestDispatcher()

    private lateinit var repository: UNESCOSiteRepository

    private lateinit var getUNESCOSiteUseCase: GetUNESCOSiteUseCase

    @RelaxedMockK
    private lateinit var localDatasource: LocalDatasource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testCoroutineDispatcher)
        repository = spyk(RepositoryImpl(localDatasource))
        getUNESCOSiteUseCase = spyk(GetUNESCOSiteUseCase(repository))
    }

    @Test
    fun getUNESCOSiteList_IsSuccessful() = runBlocking {
        coEvery {
            repository.getAllUNESCOSite()
        } returns Gson().fromJson(
            mockJson,
            listType
        )

        val result = getUNESCOSiteUseCase.getAllUNESCOSite(1)
        assert(result.isNotEmpty())
    }

    @Test
    fun getUNESCOSiteList_hasCorrectSize() = runBlocking {
        coEvery {
            repository.getAllUNESCOSite()
        } returns Gson().fromJson(
            mockJson,
            listType
        )

        val result = getUNESCOSiteUseCase.getAllUNESCOSite(1)
        assert(result.size == 3)
    }

    @Test
    fun getUNESCOSiteList_isEmpty() = runBlocking {
        coEvery {
            repository.getAllUNESCOSite()
        } returns listOf()

        val result = getUNESCOSiteUseCase.getAllUNESCOSite(1)
        assert(result.isEmpty())
    }

    @Test
    fun getUNESCOSiteList_hasValidData() = runBlocking {
        coEvery {
            repository.getAllUNESCOSite()
        } returns Gson().fromJson(
            mockJson,
            listType
        )

        val result = getUNESCOSiteUseCase.getAllUNESCOSite(1)
        assert(result[0].id == "1")
    }

}

