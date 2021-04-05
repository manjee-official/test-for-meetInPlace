package com.example.meetinplace.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.meetinplace.R
import com.example.meetinplace.databinding.FragmentMeetListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MeetListFragment : Fragment() {

    private var _binding: FragmentMeetListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMeetListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.layoutAddLocation.setOnClickListener {
            it.findNavController().navigate(R.id.action_meetListFragment_to_findLocationFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}