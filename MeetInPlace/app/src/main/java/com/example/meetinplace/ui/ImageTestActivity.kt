package com.example.meetinplace.ui

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.meetinplace.R
import com.example.meetinplace.databinding.ActivityImageTestBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ImageTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageTestBinding

    private val image1 = R.drawable.boyoung1
    private val image2 = R.drawable.boyoung2
    private val image3 = R.drawable.dahee1

    var imageList1 = listOf(image1, image2, image3)
    var imageList2 = listOf(image1)
    var imageList3 = listOf(image1, image3)

    private var progressBarList : ArrayList<View> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@ImageTestActivity, R.layout.activity_image_test)

        for (drawable in imageList1) {
            val v = createProgressView()
            binding.layoutProgress.addView(v)
            progressBarList.add(v)
        }
        startProgress(progressBarList[0] as ProgressBar)

    }

    private fun createProgressView(): View {
        val progressBar =
            ProgressBar(this@ImageTestActivity, null, android.R.attr.progressBarStyleHorizontal)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            1f
        )
        layoutParams.marginStart = 8f.dpToPixel()
        progressBar.layoutParams = layoutParams
        progressBar.max = 300
        return progressBar
    }

    private fun Float.dpToPixel(): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this,
            this@ImageTestActivity.resources.displayMetrics
        ).toInt()
    }

    private fun startProgress(progressBar: ProgressBar) {
        GlobalScope.launch() {
            repeat(300) {
                delay(10L)
                progressBar.progress = progressBar.progress + 1
            }
        }
    }

    companion object {

    }
}