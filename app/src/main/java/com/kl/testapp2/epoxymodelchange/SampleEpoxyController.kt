package com.kl.testapp2.epoxymodelchange

import com.airbnb.epoxy.TypedEpoxyController
import com.kl.testapp2.itemDivider
import com.kl.testapp2.itemSampleList

class SampleEpoxyController(
    private val onClick: (SampleEpoxyModel) -> Unit
) : TypedEpoxyController<List<SampleEpoxyModel>?>() {

    override fun buildModels(data: List<SampleEpoxyModel>?) {
        data?.forEach { sampleEpoxyModel ->
            itemSampleList {
                id("EpoxyModel_id:${sampleEpoxyModel.id}")
                sampleEpoxyModel(sampleEpoxyModel)
                onClick { _ ->
                    onClick.invoke(sampleEpoxyModel)
                }
            }
            itemDivider {
                id("divider")
            }
        }
    }
}