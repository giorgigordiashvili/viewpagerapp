package com.example.viewpagerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerapp.adapter.ViewPagerAdapter
import com.example.viewpagerapp.databinding.ActivityMainBinding
import com.example.viewpagerapp.model.ItemData
import com.example.viewpagerapp.model.ViewPagerItemModel


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val viewPagerDataProvider by lazy { ViewPagerDataProvider() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        viewPagerAdapter = ViewPagerAdapter(viewPagerDataProvider.getViewPagerData())
        viewPager.adapter = viewPagerAdapter
    }
}

typealias DR = R.drawable

class ViewPagerDataProvider {
    fun getViewPagerData(): List<ViewPagerItemModel> {
        return listOf(
            ViewPagerItemModel(
                "Cities",
                listOf(
                    ItemData(DR.city_batumi, "Batumi"),
                    ItemData(DR.city_telavi, "Telavi"),
                    ItemData(DR.city_tbilisi, "Tbilisi"),
                    ItemData(DR.city_akhaltsikhe, "Akhaltsikhe"),
                    ItemData(DR.city_kobuleti, "Kobuleti")
                )
            ),
            ViewPagerItemModel(
                "Deserts",
                listOf(
                    ItemData(DR.desert_sahara, "Sahara"),
                    ItemData(DR.desert_dubai, "Dubai"),
                    ItemData(DR.desert_africa, "Africa"),
                    ItemData(DR.desert_deserted, "Deserted Desert"),
                    ItemData(DR.desert_idk, "Idk")
                )
            ),
            ViewPagerItemModel(
                "Cars",
                listOf(
                    ItemData(DR.car_rr, "Rolls-Royce"),
                    ItemData(DR.car_gelik, "Mercedes-Benz G-wagon"),
                    ItemData(DR.car_bmw, "BMW"),
                    ItemData(DR.car_idk, "Idk this either")
                )
            )
        )
    }
}