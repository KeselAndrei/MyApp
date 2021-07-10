package com.gmail.keseltms.myapp.homework13

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.gmail.keseltms.myapp.R
import com.gmail.keseltms.myapp.databinding.ActivityCandyStoreBinding
import com.gmail.keseltms.myapp.homework10.Candy
import com.gmail.keseltms.myapp.homework13.SharedPrefsKeys.PREFS_MESSAGE_BARCODE_KEY
import com.gmail.keseltms.myapp.homework13.SharedPrefsKeys.PREFS_MESSAGE_BRAND_KEY

class CandyStoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCandyStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCandyStoreBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val messageBrand = SharedPreferencesUtils.getStrings(PREFS_MESSAGE_BRAND_KEY)
        val messageBarcode: Long =
            SharedPreferencesUtils.getLongs(PREFS_MESSAGE_BARCODE_KEY)

        val toast = Toast.makeText(
            applicationContext,
            String.format(
                getString(R.string.candy_info),
                messageBrand + "\n",
                messageBarcode
            ),
            Toast.LENGTH_LONG
        )
        toast.show()

        val fragment = supportFragmentManager.findFragmentByTag(
            InfoCandyFragment.TAG
        ) ?: supportFragmentManager.findFragmentByTag(BarcodeCandyFragment.TAG)

        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    binding.fragmentContainerView.id,
                    fragment
                )
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(
                    binding.fragmentContainerView.id,
                    BarcodeCandyFragment(),
                    BarcodeCandyFragment.TAG
                )
                .commit()
        }
    }

    fun barcodeClickListener(candy: Candy) {
        val fragmentInfo = InfoCandyFragment().apply {
            arguments = bundleOf(InfoCandyFragment.KEY to candy)
        }
        supportFragmentManager.beginTransaction()
            .replace(
                binding.fragmentContainerView.id,
                fragmentInfo,
                InfoCandyFragment.TAG
            )
            .addToBackStack(InfoCandyFragment.TAG)
            .commit()
    }
}