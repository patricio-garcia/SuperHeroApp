package cl.serlitoral.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cl.serlitoral.superheroapp.databinding.ActivityMainBinding
import cl.serlitoral.superheroapp.view.HeroAdapter
import cl.serlitoral.superheroapp.view.HeroViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val viewModel: HeroViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var fabToUp: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = HeroAdapter()
        binding.rvHeroes.adapter = adapter

        viewModel.heroes.observe(this, {
            it?.let {
                adapter.update(it)
            }
        })

        fabToUp = binding.fabToUp
        fabToUp.setOnClickListener() {
            binding.rvHeroes.smoothScrollToPosition(0)
        }
    }
}