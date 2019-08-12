package com.kl.testapp2.epoxy.view

import com.airbnb.epoxy.TypedEpoxyController
import com.kl.testapp2.LayoutContentFirstBindingModel_
import com.kl.testapp2.LayoutContentSecondBindingModel_
import com.kl.testapp2.LayoutHeaderFirstBindingModel_
import com.kl.testapp2.LayoutHeaderSecondBindingModel_
import com.kl.testapp2.epoxy.data.EpoxyData
import com.kl.testapp2.epoxy.viewmodel.ContentFirstViewModel
import com.kl.testapp2.epoxy.viewmodel.ContentSecondViewModel
import com.kl.testapp2.epoxy.viewmodel.HeaderFirstViewModel
import com.kl.testapp2.epoxy.viewmodel.HeaderSecondViewModel

class EpoxyController: TypedEpoxyController<EpoxyData>() {

    override fun buildModels(data: EpoxyData?) {

        LayoutHeaderFirstBindingModel_()
            .id(modelCountBuiltSoFar)
            .viewModel(data?.header1)
            .addTo(this)

        data?.content1?.text?.forEach { it ->
            LayoutContentFirstBindingModel_()
                .id(modelCountBuiltSoFar)
                .text(it)
                .addTo(this)
        }

        LayoutHeaderSecondBindingModel_()
            .id(modelCountBuiltSoFar)
            .viewModel(data?.header2)
            .addTo(this)

        data?.content2?.text?.forEach { it ->
            LayoutContentSecondBindingModel_()
                .id(modelCountBuiltSoFar)
                .text(it)
                .addTo(this)
        }
    }
}