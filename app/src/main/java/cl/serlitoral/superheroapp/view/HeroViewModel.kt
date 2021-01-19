package cl.serlitoral.superheroapp.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.serlitoral.superheroapp.model.Repo
import kotlinx.coroutines.launch

class HeroViewModel: ViewModel() {
    private val repo = Repo()
    val heroes = repo.heroList

    init {
        viewModelScope.launch {
            repo.getHeroes()
        }
    }
}