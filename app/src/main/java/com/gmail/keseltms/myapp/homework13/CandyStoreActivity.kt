package com.gmail.keseltms.myapp.homework13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.keseltms.myapp.databinding.ActivityCandyStoreBinding

class CandyStoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCandyStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCandyStoreBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentBarcode = supportFragmentManager.findFragmentByTag(
            BarcodeCandyFragment.TAG_BARCODE_CANDY_FRAGMENT
        )
            ?: BarcodeCandyFragment(::barcodeClickListener) //

        supportFragmentManager.beginTransaction()
            .replace(
                binding.fragmentContainerView.id,
                fragmentBarcode,
                BarcodeCandyFragment.TAG_BARCODE_CANDY_FRAGMENT
            )
            .addToBackStack(null)
            .commit()
    }

    private fun barcodeClickListener() {

        val fragmentInfo = supportFragmentManager.findFragmentByTag(
            InfoCandyFragment.TAG_INFO_CANDY_FRAGMENT
        )
            ?: InfoCandyFragment()

        supportFragmentManager.beginTransaction()
            .replace(
                binding.fragmentContainerView.id,
                fragmentInfo,
                InfoCandyFragment.TAG_INFO_CANDY_FRAGMENT
            )
            .commit()
    }
}