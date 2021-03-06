package com.example.meetinplace.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import com.example.meetinplace.data.model.KakaoAddressData
import com.example.meetinplace.data.repository.MapRepositoryImpl
import com.example.meetinplace.databinding.FragmentFindLocationBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FindLocationFragment : Fragment() {

	private var _binding: FragmentFindLocationBinding? = null
	private val binding get() = _binding!!
	private var mapRepositoryImpl: MapRepositoryImpl = MapRepositoryImpl()

	override fun onCreateView(
			inflater: LayoutInflater,
			container: ViewGroup?,
			savedInstanceState: Bundle?
	): View? {
		_binding = FragmentFindLocationBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.etLocation.setOnEditorActionListener { _, actionId, _ ->
			return@setOnEditorActionListener when (actionId) {
				EditorInfo.IME_ACTION_DONE -> {
					mapRepositoryImpl.searchAddressOnRemoteWithKakao("동탄 CGV", success = {
						val list: List<KakaoAddressData> = it.documents
						Log.i(TAG, "리스트 사이즈: ${list.size}")
					}, fail = {
						Log.e(TAG, "API 호출 실패: $it")
					})
					false
				}
				else -> false
			}
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	companion object {
		val TAG = FindLocationFragment::class.qualifiedName
	}
}