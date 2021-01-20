package cl.serlitoral.superheroapp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.serlitoral.superheroapp.model.Repo
import cl.serlitoral.superheroapp.model.SuperHero
import kotlinx.coroutines.launch

class HeroViewModel: ViewModel() {
    private val repo = Repo()
    val heroes = repo.heroList

    init {
        viewModelScope.launch {
            repo.getHeroes()
        }
    }

    private lateinit var selectedHero: SuperHero
    fun selected(superHero: SuperHero) {
        selectedHero = superHero
    }

    fun getHeroDetail(): LiveData<SuperHero> {
        return repo.getHeroDetail(selectedHero.id)
    }
}