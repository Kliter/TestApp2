package com.kl.testapp2.epoxymodelchange

typealias EpoxyModelId = Int

data class SampleEpoxyModel(
    val id: EpoxyModelId,
    var isSelected: Boolean = false
)