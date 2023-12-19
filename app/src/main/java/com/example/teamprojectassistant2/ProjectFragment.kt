package com.example.teamprojectassistant2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teamprojectassistant2.databinding.FragmentProjectBinding

class   ProjectFragment : Fragment() {
    private var _binding: FragmentProjectBinding? = null
    private val binding get() = _binding!!

    private var image: Int? = null
    private var text: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            image = it.getInt("image", 0)
            text = it.getString("text", "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView.setImageResource(image!!)
        binding.textView.text = text
    }

    companion object {
        fun newInstance(image: Int, text: String) =
            ProjectFragment().apply {
                arguments = Bundle().apply {
                    putInt("image", image)
                    putString("text", text)
                }
            }
    }
}