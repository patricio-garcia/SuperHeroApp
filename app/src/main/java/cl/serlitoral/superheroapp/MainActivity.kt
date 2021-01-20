package cl.serlitoral.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cl.serlitoral.superheroapp.databinding.ActivityMainBinding
import cl.serlitoral.superheroapp.view.HeroAdapter
import cl.serlitoral.superheroapp.view.HeroListFragment
import cl.serlitoral.superheroapp.view.HeroViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fmtContainer, HeroListFragment())
            .commit()
    }
}