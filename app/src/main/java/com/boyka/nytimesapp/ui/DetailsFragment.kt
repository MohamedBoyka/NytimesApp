package com.boyka.nytimesapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boyka.nytimesapp.R
import com.boyka.nytimesapp.databinding.FragmentDetailsragmentBinding
import com.boyka.nytimesapp.databinding.FragmentHomeBinding


class DetailsFragment : Fragment() {

    lateinit var binding : FragmentDetailsragmentBinding
    private var nytDsection : String = ""
    private var abstract : String = ""
    private var adxKeywords : String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        binding = FragmentDetailsragmentBinding.inflate(inflater , container , false)
        binding.lifecycleOwner =this

        val args = DetailsFragmentArgs.fromBundle(requireArguments())

        nytDsection = args.argNytDsection
        abstract = args.argAbstract
        adxKeywords = args.argAdxKeywords

        if (nytDsection != ""|| nytDsection != null){
            binding.tvStyle.text = nytDsection
            binding.cardOne.visibility = View.VISIBLE
        }

        if (abstract != ""|| abstract != null){
            binding.tvAbstract.text = abstract
            binding.cardTwo.visibility = View.VISIBLE

        }
        if (adxKeywords != ""|| adxKeywords != null){
            binding.tvAdxKeywords.text = adxKeywords
            binding.cardThree.visibility = View.VISIBLE

        }



        return binding.root
    }

}