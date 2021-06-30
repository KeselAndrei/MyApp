package com.gmail.keseltms.myapp.homework13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.gmail.keseltms.myapp.databinding.ActivityCandyStoreBinding
import com.gmail.keseltms.myapp.homework10.Candy

class CandyStoreActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityCandyStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCandyStoreBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentBarcode = supportFragmentManager.findFragmentByTag(
            BarcodeCandyFragment.TAG_BARCODE_CANDY_FRAGMENT
        )
            ?: BarcodeCandyFragment()

        supportFragmentManager.beginTransaction()
            .replace(
                binding.fragmentContainerView.id,
                fragmentBarcode,
                BarcodeCandyFragment.TAG_BARCODE_CANDY_FRAGMENT
            )
            .commit()
    }

     fun barcodeClickListener(candy:Candy) {
        val fragmentInfo = InfoCandyFragment().apply {
            arguments = bundleOf("Key" to candy)
        }
        supportFragmentManager.beginTransaction()
            .replace(
                binding.fragmentContainerView.id,
                fragmentInfo
            )
            .commit()
    }
}