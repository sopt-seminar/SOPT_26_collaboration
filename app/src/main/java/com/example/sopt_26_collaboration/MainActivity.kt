package com.example.sopt_26_collaboration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    fun init()
    {
        main_vp.adapter = MainPagerAdapter(supportFragmentManager)
        main_vp.offscreenPageLimit = 2
        main_vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener
        {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                main_bottom_navi.menu.getItem(position).isChecked = true
            }

        })
        main_bottom_navi.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.menu_home-> main_vp.currentItem =0
                R.id.menu_search -> main_vp.currentItem =1
                R.id.menu_user-> main_vp.currentItem=2
            }
            true
        }

    }
}
