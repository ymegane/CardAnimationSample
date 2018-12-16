package org.ymegane.android.cardanimationsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.ymegane.android.cardanimationsample.databinding.ActivityDetailBinding
import org.ymegane.android.cardanimationsample.util.lazyWithExtras
import org.ymegane.android.cardanimationsample.util.setSystemBarTransition

class DetailActivity : AppCompatActivity() {

    private val imageResId: Int by lazyWithExtras(EXTRA_ITEM)

    private val binding: ActivityDetailBinding by lazy {
        DataBindingUtil.setContentView<ActivityDetailBinding>(this@DetailActivity, R.layout.activity_detail)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportPostponeEnterTransition()

        setSystemBarTransition()
        binding.resourceId = imageResId

        supportStartPostponedEnterTransition()
    }

    companion object {

        private const val EXTRA_ITEM = "extra_item_res"

        fun createIntent(context: Context, item: Item): Intent {
            return Intent(context, DetailActivity::class.java).also {
                it.putExtra(EXTRA_ITEM, item.resId)
            }
        }
    }
}