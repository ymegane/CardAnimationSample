package org.ymegane.android.cardanimationsample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import org.ymegane.android.cardanimationsample.databinding.ActivityMainBinding
import org.ymegane.android.cardanimationsample.databinding.ViewListItemBinding
import org.ymegane.android.cardanimationsample.util.makeSceneWithSystemBar
import androidx.core.util.Pair as AndroidPair

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this@MainActivity, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = ItemAdapter(this, clickEvent = { _, binding, item ->
            navigateToDetail(binding, item)
        })
        binding.recyclerView.also {
            it.layoutManager = LinearLayoutManager(this@MainActivity)
            it.adapter = adapter
        }
    }

    private fun navigateToDetail(binding: ViewListItemBinding, item: Item) {
        val pairThumb = AndroidPair<View, String>(binding.viewThumbnail, binding.viewThumbnail.transitionName)
        val options = makeSceneWithSystemBar(pairThumb)
        val intent = DetailActivity.createIntent(this@MainActivity, item)
        startActivity(intent, options.toBundle())
    }
}
