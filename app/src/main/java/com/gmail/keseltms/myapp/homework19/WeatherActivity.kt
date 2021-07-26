package com.gmail.keseltms.myapp.homework19

import android.annotation.SuppressLint
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.liveData.observe(this, {
            update()
        })
        binding.weatherHome.setOnClickListener {
            update()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun update() {
        val resultWeather = viewModel.liveData.value

        binding.tvCityName.text = resultWeather?.name
        binding.tvTemp.text = "${resultWeather?.temp?.toInt()} °C"
        binding.tvDescription.text = resultWeather?.description
            ?.replace("[", "")
            ?.replace("]", "")
        val url = "https://openweathermap.org/img/wn/${resultWeather?.iconId}@2x.png"//тут падает
            .replace("[", "")
            .replace("]", "")

        Glide
            .with(binding.root)
            .load(url)
//            .placeholder(R.drawable.ic_meteocast_sun_and_cloud)
            .into(binding.ivIcon)
    }
}