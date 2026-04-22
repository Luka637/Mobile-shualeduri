package com.example.shualeduri

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shualeduri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // აპლიკაციის მთელ ეკრანზე გაშლა
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // სისტემური პადინგების გასწორება (სტატუს ბარი და ნავიგაცია)
        ViewCompat.setOnApplyWindowInsetsListener(binding.ltMainRoot) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // თუ პირველად ირთვება აპლიკაცია, ჩავსვათ FragmentA
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.lt_main_fragment_container, FragmentA())
                .commit()
        }
    }
}
