package com.example.meetinplace.ui

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.meetinplace.R
import com.example.meetinplace.databinding.ActivityImageTestBinding
import kotlinx.coroutines.*


class ImageTestActivity : AppCompatActivity() {

	private lateinit var binding: ActivityImageTestBinding

	private val image1 = R.drawable.boyoung1
	private val image2 = R.drawable.boyoung2
	private val image3 = R.drawable.dahee1

	private var imageList1 = listOf(image1, image2, image3)
	private var imageList2 = listOf(image1)
	private var imageList3 = listOf(image1, image3)
	private var imageList = listOf(imageList1, imageList2, imageList3)

	private var progressBarList: ArrayList<View> = ArrayList()

	private var currentGroupIndex = 0
	private var currentImageIndex = 0

	private lateinit var currentCorutionJob: Deferred<Unit>

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this@ImageTestActivity, R.layout.activity_image_test)

		setImageSwitcher()
		setProgressView()
		showImage(currentImageIndex = currentImageIndex)
	}

	init {
		val display = this.display
		val displayMetrics = DisplayMetrics()
		display!!.getRealMetrics(displayMetrics)

		val density = resources.displayMetrics.density
		val dpHeight = displayMetrics.heightPixels / density
		val dpWidth = displayMetrics.widthPixels / density
	}

	private fun setImageSwitcher() {
		binding.viewImage.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
		binding.viewImage.setFactory {
			val imageView = ImageView(this)
			imageView.scaleType = ImageView.ScaleType.FIT_CENTER
			imageView
		}
	}

	private fun setProgressView() {
		for (drawable in imageList[currentGroupIndex]) {
			val v = createProgressView()
			binding.layoutProgress.addView(v)
			progressBarList.add(v)
		}
	}

	private fun showImage(currentImageIndex: Int) {
		GlobalScope.launch(Dispatchers.Main) {
			startProgress(progressBarList[currentImageIndex] as ProgressBar)
		}
		Glide.with(this).load(imageList[currentGroupIndex][currentImageIndex]).into(binding.viewImage.currentView as ImageView)
	}

	private fun checkNextStep() {
		++currentImageIndex
		if (currentImageIndex < imageList[currentGroupIndex].size) {
			showImage(currentImageIndex = currentImageIndex)
		} else {
			resetProgressView()
		}
	}

	private fun resetProgressView() {
		++currentGroupIndex
		if (currentGroupIndex < imageList.size) {
			binding.layoutProgress.removeAllViews()
			progressBarList = ArrayList()

			setProgressView()
			currentImageIndex = 0
			showImage(currentImageIndex = currentImageIndex)
		} else {
			Toast.makeText(this, "모든 그룹 종료", Toast.LENGTH_SHORT).show()
		}
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

	private suspend fun startProgress(progressBar: ProgressBar) {
		currentCorutionJob = GlobalScope.async {
			repeat(300) {
				delay(10L)
				progressBar.progress = progressBar.progress + 1
			}
		}
		currentCorutionJob.await()
		checkNextStep()
	}

	companion object {

	}
}