package com.polaroid.home.presentation.component

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.Gson
import com.polaroid.home.domain.entity.UNESCOSiteEntity
import com.polaroid.home.presentation.UNESCOSiteState
import com.polaroid.home.presentation.componenet.TAG_LIST
import com.polaroid.home.presentation.componenet.UNESCOSiteList
import com.polaroid.home.presentation.listType
import com.polaroid.home.presentation.mockJson
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class UNESCOSiteListTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun listExistTest() {
        composeTestRule.setContent {
            UNESCOSiteList(
                lazyColumnListState = rememberLazyListState(),
                UNESCOSiteState()
            )
        }
        composeTestRule.onNodeWithTag(TAG_LIST)
            .assertExists()
    }

    @Test
    fun listIsEmptyTest() {
        composeTestRule.setContent {
            UNESCOSiteList(
                lazyColumnListState = rememberLazyListState(),
                UNESCOSiteState()
            )
        }
        composeTestRule.onNodeWithTag(TAG_LIST)
            .onChildren()
            .assertCountEquals(0)
    }

    @Test
    fun listSizeTest() {
        val mockData: List<UNESCOSiteEntity> = Gson().fromJson(
            mockJson,
            listType
        )
        composeTestRule.setContent {
            UNESCOSiteList(
                lazyColumnListState = rememberLazyListState(),
                UNESCOSiteState(UNESCOSiteList = mockData.toMutableList())
            )
        }
        composeTestRule.onNodeWithTag(TAG_LIST)
            .onChildren()
            .assertCountEquals(3)
    }

    @Test
    fun firstItemNameTest() {
        val mockData: List<UNESCOSiteEntity> = Gson().fromJson(
            mockJson,
            listType
        )
        composeTestRule.setContent {
            UNESCOSiteList(
                lazyColumnListState = rememberLazyListState(),
                UNESCOSiteState(UNESCOSiteList = mockData.toMutableList())
            )
        }
        composeTestRule.onNodeWithTag(TAG_LIST)
            .onChildren()
            .onFirst()
            .assert(hasText(mockData[0].name!!))
    }

    @Test
    fun lastItemNameTest() {
        val mockData: List<UNESCOSiteEntity> = Gson().fromJson(
            mockJson,
            listType
        )
        composeTestRule.setContent {
            UNESCOSiteList(
                lazyColumnListState = rememberLazyListState(),
                UNESCOSiteState(UNESCOSiteList = mockData.toMutableList())
            )
        }
        composeTestRule.onNodeWithTag(TAG_LIST)
            .onChildren()
            .onLast()
            .assert(hasText(mockData[mockData.size - 1].name!!))
    }


}
