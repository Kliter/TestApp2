package com.kl.testapp2.epoxy.data

import com.kl.testapp2.epoxy.viewmodel.ContentFirstViewModel
import com.kl.testapp2.epoxy.viewmodel.ContentSecondViewModel
import com.kl.testapp2.epoxy.viewmodel.HeaderFirstViewModel
import com.kl.testapp2.epoxy.viewmodel.HeaderSecondViewModel

class EpoxyData(
    val header1: HeaderFirstViewModel,
    val content1: ContentFirstViewModel,
    val header2: HeaderSecondViewModel,
    val content2: ContentSecondViewModel
)