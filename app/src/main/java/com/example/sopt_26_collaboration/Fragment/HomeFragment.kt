package com.example.sopt_26_collaboration.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.sopt_26_collaboration.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    lateinit var carouselView: CarouselView
    var bannerImages = intArrayOf(
        R.drawable.carousel_design,
        R.drawable.carousel_android,
        R.drawable.carousel
    )
    var subtitleStrings = arrayOf(
        "디자인 인재 영입 중",
        "안드로이드 인재 영입 중",
        "iOS 인재 영입 중"
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carouselView = view.findViewById(R.id.carousel) as CarouselView
        carouselView.setImageListener(imageListener)
        carouselView.pageCount = bannerImages.count()

        carouselView.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) { }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { }

            override fun onPageSelected(position: Int) {
                tv_subtitle.text = subtitleStrings.get(position)
            }
        })
    }

    var imageListener =
        ImageListener { position, imageView -> imageView.setImageResource(bannerImages.get(position)) }
}
