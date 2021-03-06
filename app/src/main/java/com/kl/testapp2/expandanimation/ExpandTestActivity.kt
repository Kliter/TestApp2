package com.kl.testapp2.expandanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.kl.testapp2.R
import com.kl.testapp2.databinding.ActivityExpandTestBinding

class ExpandTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpandTestBinding
    private val users = listOf(
        User("mojombo", 1, "https://avatars0.githubusercontent.com/u/1?v=4"),
        User("defunkt", 2, "https://avatars0.githubusercontent.com/u/2?v=4"),
        User("pjhyett", 3, "https://avatars0.githubusercontent.com/u/3?v=4"),
        User("wycats", 4, "https://avatars0.githubusercontent.com/u/4?v=4"),
        User("ezmobius", 5, "https://avatars0.githubusercontent.com/u/5?v=4"),
        User("ivey", 6, "https://avatars0.githubusercontent.com/u/6?v=4"),
        User("evanphx", 7, "https://avatars0.githubusercontent.com/u/7?v=4"),
        User("vanpelt", 17, "https://avatars1.githubusercontent.com/u/17?v=4"),
        User("wayneeseguin", 18, "https://avatars0.githubusercontent.com/u/18?v=4"),
        User("brynary", 19, "https://avatars0.githubusercontent.com/u/19?v=4"),
        User("kevinclark", 20, "https://avatars3.githubusercontent.com/u/20?v=4"),
        User("technoweenie", 21, "https://avatars3.githubusercontent.com/u/21?v=4"),
        User("macournoyer", 22, "https://avatars3.githubusercontent.com/u/22?v=4"),
        User("takeo", 23, "https://avatars3.githubusercontent.com/u/23?v=4"),
        User("Caged", 25, "https://avatars3.githubusercontent.com/u/25?v=4"),
        User("topfunky", 26, "https://avatars3.githubusercontent.com/u/26?v=4"),
        User("anotherjesse", 27, "https://avatars3.githubusercontent.com/u/27?v=4"),
        User("roland", 28, "https://avatars2.githubusercontent.com/u/28?v=4"),
        User("lukas", 29, "https://avatars2.githubusercontent.com/u/29?v=4"),
        User("fanvsfan", 30, "https://avatars2.githubusercontent.com/u/30?v=4"),
        User("tomtt", 31, "https://avatars2.githubusercontent.com/u/31?v=4"),
        User("railsjitsu", 32, "https://avatars2.githubusercontent.com/u/32?v=4"),
        User("nitay", 34, "https://avatars2.githubusercontent.com/u/34?v=4"),
        User("kevwil", 35, "https://avatars2.githubusercontent.com/u/35?v=4"),
        User("KirinDave", 36, "https://avatars2.githubusercontent.com/u/36?v=4"),
        User("jamesgolick", 37, "https://avatars2.githubusercontent.com/u/37?v=4"),
        User("atmos", 38, "https://avatars3.githubusercontent.com/u/38?v=4"),
        User("errfree", 44, "https://avatars2.githubusercontent.com/u/44?v=4"),
        User("mojodna", 45, "https://avatars2.githubusercontent.com/u/45?v=4"),
        User("bmizerany", 46, "https://avatars2.githubusercontent.com/u/46?v=4")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_expand_test)

        binding.recyclerView.apply {
            val adapter = Adapter(users)
            this.addItemDecoration(
                DividerItemDecoration(
                    this@ExpandTestActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            binding.recyclerView.adapter = adapter
        }
    }
}
