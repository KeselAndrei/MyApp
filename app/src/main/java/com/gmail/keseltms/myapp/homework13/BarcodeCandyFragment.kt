package com.gmail.keseltms.myapp.homework13

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.keseltms.myapp.databinding.FragmentBarcodeCandyBinding

class BarcodeCandyFragment(
    private val barcodeClickListener: () -> Unit
) : Fragment() {

    private var binding: FragmentBarcodeCandyBinding? = null
    private val barcodeViewModel: BarcodeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBarcodeCandyBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val barcodeAdapter = BarcodeAdapter(barcodeClickListener)

        with(binding!!.rvBarcode) {
            layoutManager = LinearLayoutManager(
                view.context, LinearLayoutManager.VERTICAL, false
            )
            adapter = barcodeAdapter
        }

        barcodeViewModel.liveData.observe(viewLifecycleOwner, {
            barcodeAdapter.update(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val TAG_BARCODE_CANDY_FRAGMENT = "BARCODE_CANDY_FRAGMENT"
    }
}