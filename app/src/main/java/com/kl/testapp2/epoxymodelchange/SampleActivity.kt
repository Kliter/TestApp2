package com.kl.testapp2.epoxymodelchange

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.airbnb.epoxy.EpoxyController
import com.kl.testapp2.R
import com.kl.testapp2.databinding.ActivitySampleBinding

class SampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySampleBinding
    private var epoxyController: SampleEpoxyController? = null
    private var sampleEpoxyModels: MutableList<SampleEpoxyModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sample)
        setController()
    }

    private fun setController() {
        sampleEpoxyModels = (0..9).map {
            SampleEpoxyModel(it)
        }.toMutableList()
        epoxyController = SampleEpoxyController(
            onClick = {
                val index = sampleEpoxyModels?.indexOf(it) ?: -1
                sampleEpoxyModels?.set(
                    index,
                    it.copy(
                        isSelected = it.isSelected.not()
                    )
                )
                epoxyController?.setData(sampleEpoxyModels)
            }
        )
        binding.recyclerView.setController(epoxyController as EpoxyController)
        epoxyController?.setData(sampleEpoxyModels)
    }
}