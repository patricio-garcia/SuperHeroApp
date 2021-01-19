package cl.serlitoral.superheroapp.model

import android.util.Log

class Repo {

    val heroDatabase = HeroApplication.heroDatabase!!
    val heroList = heroDatabase.heroDao().getHeroes()

    suspend fun getHeroes() {

        val response = RetrofitClient.instance().getHeroes()

        when(response.isSuccessful) {

            true -> {
                response.body()?.let { heroesList ->
                heroDatabase.heroDao().insertHero(heroesList)
            }}

            false -> {
                Log.d("Repo", "Error:: ${response.errorBody()}")
            }
        }
    }
}