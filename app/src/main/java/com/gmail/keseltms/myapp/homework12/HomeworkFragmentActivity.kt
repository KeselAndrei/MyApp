package com.gmail.keseltms.myapp.homework12

import com.gmail.keseltms.myapp.databinding.ActivityHomeworkFragmentBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.gmail.keseltms.myapp.R

class HomeworkFragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeworkFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeworkFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            replaceFragment()
        }
    }

    private fun getFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container_view, fragment)
        }
    }

    private var counter = 1
    private fun replaceFragment() {

        when (counter) {
            1 -> {
                getFragment(FirstFragment())
                counter++
            }
            2 -> {
                getFragment(SecondFragment())
                counter++
            }
            3 -> {
                getFragment(ThirdFragment())
                counter++
            }
            4 -> {
                getFragment(ForthFragment())
                counter++
            }
            5 -> {
                getFragment(FifthFragment())
                counter = 1
            }
        }
    }
}