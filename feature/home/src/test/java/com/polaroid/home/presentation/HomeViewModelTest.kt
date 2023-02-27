package com.polaroid.home.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.gson.Gson
import com.polaroid.home.domain.entity.UNESCOSiteEntity
import com.polaroid.home.domain.repo.UNESCOSiteRepository
import com.polaroid.home.domain.usecase.GetUNESCOSiteUseCase
import com.polaroid.home.domain.usecase.listType
import com.polaroid.home.domain.usecase.mockJson
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

class HomeViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    private val testCoroutineDispatcher = UnconfinedTestDispatcher()

    private lateinit var viewModel: HomeViewModel

    private lateinit var getUNESCOSiteUseCase: GetUNESCOSiteUseCase

    @RelaxedMockK
    private lateinit var repository: UNESCOSiteRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testCoroutineDispatcher)
        getUNESCOSiteUseCase = spyk(GetUNESCOSiteUseCase(repository))
        viewModel = spyk(HomeViewModel(getUNESCOSiteUseCase))
    }

    @Test
    fun getAllUNESCOSite_hasCorrectSize() = runBlocking {
        coEvery {
            getUNESCOSiteUseCase.getAllUNESCOSite(any())
        } returns Gson().fromJson(
            mockJson,
            listType
        )

        viewModel.getUNESCOSite()

        assert(viewModel.unescoSiteState.value.UNESCOSiteList.size == 3)
    }

    @Test
    fun getAllUNESCOSiteList_hasCorrectData() = runBlocking {
        val mockData: List<UNESCOSiteEntity> = Gson().fromJson(
            mockJson,
            listType
        )
        coEvery {
            getUNESCOSiteUseCase.getAllUNESCOSite(any())
        } returns mockData

        viewModel.getUNESCOSite()

        assert(viewModel.unescoSiteState.value.UNESCOSiteList[0].id == mockData[0].id)
        assert(viewModel.unescoSiteState.value.UNESCOSiteList[0].name == mockData[0].name)
        assert(viewModel.unescoSiteState.value.UNESCOSiteList[0].image == mockData[0].image)
        assert(viewModel.unescoSiteState.value.UNESCOSiteList[0].imageAuthor == mockData[0].imageAuthor)
        assert(viewModel.unescoSiteState.value.UNESCOSiteList[0].shortInfo == mockData[0].shortInfo)
        assert(viewModel.unescoSiteState.value.UNESCOSiteList[0].longInfo == mockData[0].longInfo)
    }

    @Test
    fun getAllUNESCOSiteState_hasCorrectStateData() = runBlocking {
        val mockData: List<UNESCOSiteEntity> = Gson().fromJson(
            mockJson,
            listType
        )
        coEvery {
            getUNESCOSiteUseCase.getAllUNESCOSite(any())
        } returns mockData

        viewModel.getUNESCOSite()

        assert(viewModel.unescoSiteState.value.listState == ListState.IDLE)
        assert(viewModel.unescoSiteState.value.canPaginate)
    }
}