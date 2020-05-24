package com.samit.yesoptustest.data.repo

import com.samit.yesoptustest.data.OptusUI

class Repository {
    fun getScenarios() = Mocks.getScenarios()

    fun getScenarioOneItems() = Mocks.getItems()
}

object Mocks {

    fun getScenarios() = listOf(
        OptusUI(1, "Scenario 1"),
        OptusUI(2, "Scenario 2")
    )

    fun getPoints() = listOf(
        OptusUI(1, "Point 1: Horizontal Scroll"),
        OptusUI(2, "Point 2: View Pager"),
        OptusUI(3, "Point 3: Textview Alignment"),
        OptusUI(4, "Point 4: Item Click"),
        OptusUI(5, "Point 5: Colorful Button")
    )

    fun getItems() = listOf(
        OptusUI(1, "Item 1"),
        OptusUI(2, "Item 2"),
        OptusUI(3, "Item 3"),
        OptusUI(4, "Item 4"),
        OptusUI(5, "Item 5")
    )
}