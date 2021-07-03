package com.gmail.keseltms.myapp.homework13

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.gmail.keseltms.myapp.databinding.FragmentInfoCandyBinding
import com.gmail.keseltms.myapp.homework10.FactoryCandy
import com.gmail.keseltms.myapp.homework10.Candy
import com.gmail.keseltms.myapp.homework13.SharedPrefsKeys.PREFS_MESSAGE_BRAND_KEY
import com.gmail.keseltms.myapp.homework13.SharedPrefsKeys.PREFS_MESSAGE_BARCODE_KEY
import com.gmail.keseltms.myapp.R

class InfoCandyFragment : Fragment() {

    private var binding: FragmentInfoCandyBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoCandyBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val info = arguments?.getParcelable<Candy>(KEY)

        SharedPreferencesUtils.putStrings(PREFS_MESSAGE_BRAND_KEY, info!!.brand)
        SharedPreferencesUtils.putLongs(
            PREFS_MESSAGE_BARCODE_KEY,
            info.barcodeNumber
        )
        binding?.tvBrand?.text = info.brand
        binding?.tvBarcodeNumber?.text = info.barcodeNumber.toString()
        Glide
            .with(binding!!.root)
            .load(
                getURL(info),
            )
            .into(binding!!.ivCandy)

        val anim = AnimationUtils.loadAnimation(context, R.anim.anim_kombi)
        binding!!.ivCandy.startAnimation(anim)

        val animTranslate = AnimationUtils.loadAnimation(context, R.anim.anim_translate)
        binding!!.ivCandy.setOnClickListener {
            binding!!.ivCandy.startAnimation(animTranslate)
        }

        binding?.ivCat?.setOnClickListener {

            (binding?.ivCat?.drawable as? AnimationDrawable)?.start()

        }

    }

    private fun getURL(brand: Candy?): String {
        return when (brand?.brand) {
            FactoryCandy.BRAND_MARS -> URL_MARS
            FactoryCandy.BRAND_SNICKERS -> URL_SNICKERS
            else -> URL_TWIX
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val KEY = "KEY_INFO_CANDY_FRAGMENT"
        const val TAG = "INFO_CANDY_FRAGMENT"
        const val URL_MARS =
            "https://company.unipack.ru/light_editor_img/images/2012-5-12/file1336810083.jpg"
        const val URL_SNICKERS =
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNv-WEXnaw0qwZPO9AIjXLcNInRERfh8qfNKHLV_RE9Z23MByhOar5DMoxhiEE9LvPBQ&usqp=CAU"
        const val URL_TWIX =
            "https://storage.googleapis.com/multi-static-content/previews/artage-io-thumb-1120d7581b31dad1e62477a0fef35472.png"
    }
}