package com.gmail.keseltms.myapp.homework19

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gmail.keseltms.myapp.databinding.ActivityWeatherBinding
import com.gmail.keseltms.myapp.homework19.viewModel.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class WeatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWeatherBinding
    private val viewModel: WeatherViewModel by viewModel()
    private  var id:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.liveData.observe(this, {
            binding.tvCityName.text = it.name
            binding.tvTemp.text = it.temp.toInt().toString()
            binding.tvDescription.text = it.description
                .replace("[", "")
                .replace("]", "")
            id = it.iconId
        })

        Log.e("KEK",id.let { "NULL" })

        val URL = "https://openweathermap.org/img/wn/${1}@2x.png"

        Glide
            .with(binding.root)
            .load(URL)
//            .placeholder(R.drawable.ic_meteocast_sun_and_cloud)
            .into(binding.ivIcon)
    }
}