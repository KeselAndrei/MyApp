package com.gmail.keseltms.myapp.homework10

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gmail.keseltms.myapp.databinding.ItemCandyBinding

class CandyViewHolder(
    private val bindingView: ItemCandyBinding
) : RecyclerView.ViewHolder(bindingView.root) {

    fun bind(item: Candy) {
        bindingView.tvBrand.text = item.brand
        bindingView.tvBarcodeNumber.text = item.barcodeNumber.toString()
        Glide
            .with(bindingView.root)
            .load(
                getURL(item)
            )
            .into(bindingView.ivCandy)
    }

    private fun getURL(candy:Candy): String {
        return when (candy.brand) {
            FactoryCandy.BRAND_MARS -> URL_MARS
            FactoryCandy.BRAND_SNICKERS -> URL_SNICKERS
            else -> URL_TWIX
        }
    }

    companion object {
        const val URL_MARS =
            "https://company.unipack.ru/light_editor_img/images/2012-5-12/file1336810083.jpg"
        const val URL_SNICKERS =
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNv-WEXnaw0qwZPO9AIjXLcNInRERfh8qfNKHLV_RE9Z23MByhOar5DMoxhiEE9LvPBQ&usqp=CAU"
        const val URL_TWIX =
            "https://storage.googleapis.com/multi-static-content/previews/artage-io-thumb-1120d7581b31dad1e62477a0fef35472.png"
    }
}