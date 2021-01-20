package cl.serlitoral.superheroapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import cl.serlitoral.superheroapp.R
import cl.serlitoral.superheroapp.databinding.FragmentHeroListBinding
import cl.serlitoral.superheroapp.databinding.HeroListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HeroListFragment : Fragment() {

    private val viewModel: HeroViewModel by viewModels()
    private lateinit var binding: FragmentHeroListBinding
    private lateinit var fabToUp: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHeroListBinding.inflate(layoutInflater)
        val adapter = HeroAdapter()
        binding.rvHeroes.adapter = adapter

        viewModel.heroes.observe(viewLifecycleOwner, {
            it?.let {
                adapter.update(it)
            }
        })

        fabToUp = binding.fabToUp
        fabToUp.setOnClickListener() {
            binding.rvHeroes.smoothScrollToPosition(0)
        }

        return binding.root
    }

}