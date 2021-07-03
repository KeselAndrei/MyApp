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
            getFragment()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container_view, fragment)
        }
    }

    private var counter = 1
    private fun getFragment() {

        when (counter) {
            1 -> {
                replaceFragment(FirstFragment())
                counter++
            }
            2 -> {
                replaceFragment(SecondFragment())
                counter++
            }
            3 -> {
                replaceFragment(ThirdFragment())
                counter++
            }
            4 -> {
                replaceFragment(ForthFragment())
                counter++
            }
            5 -> {
                replaceFragment(FifthFragment())
                counter = 1
            }
        }
    }
}