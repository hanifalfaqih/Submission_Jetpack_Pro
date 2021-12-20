package com.allana.submissionsatu_jetpackpro.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.allana.submissionsatu_jetpackpro.R
import com.allana.submissionsatu_jetpackpro.utils.DataDummy
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val moviesListDummy = DataDummy.generateAllMoviesDataDummy()
    private val tvShowsListDummy = DataDummy.generateAllTvShowsDataDummy()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(moviesListDummy.size))
    }

    @Test
    fun clickFirstListItemMovies() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
    }

    @Test
    fun clickLastListItemMovies() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(moviesListDummy.size - 1))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(moviesListDummy.size - 1, ViewActions.click()))
    }

    @Test
    fun clickFavoriteMoviesAndCheckListItemFavorite() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(withId(R.id.favButtonMovie)).perform(ViewActions.click())
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.homeToFavorite)).perform(ViewActions.click())
        onView(withId(R.id.rv_movies_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_genre)).check(matches(isDisplayed()))
    }

    @Test
    fun clickFavoriteMoviesAndDeleteItemFavorite() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(withId(R.id.favButtonMovie)).perform(ViewActions.click())
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.homeToFavorite)).perform(ViewActions.click())
        onView(withId(R.id.rv_movies_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies_fav)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.swipeRight()))
    }

    @Test
    fun clickFavoriteMoviesAndGoToDetail() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(withId(R.id.favButtonMovie)).perform(ViewActions.click())
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.homeToFavorite)).perform(ViewActions.click())
        onView(withId(R.id.rv_movies_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies_fav)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(withId(R.id.tv_movie_release)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_duration)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_overview)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_genre)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_director)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_screenplay)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_budget)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_revenue)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_cast)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(withId(R.id.tv_movie_release)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_duration)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_overview)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_genre)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_director)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_screenplay)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_budget)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_revenue)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_cast)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShows() {
        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShowsListDummy.size))
    }

    @Test
    fun clickFirstListItemTvShows() {
        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
    }

    @Test
    fun clickLastListItemTvShows() {
        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShowsListDummy.size - 1))
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(tvShowsListDummy.size - 1, ViewActions.click()))
    }

    @Test
    fun clickFavoriteTvShowsAndCheckListItemFavorite() {
        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(withId(R.id.favButtonTvShow)).perform(ViewActions.click())
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.homeToFavorite)).perform(ViewActions.click())
        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_genre)).check(matches(isDisplayed()))
    }

    @Test
    fun clickFavoriteTvShowsAndDeleteItemFavorite() {
        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(withId(R.id.favButtonTvShow)).perform(ViewActions.click())
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.homeToFavorite)).perform(ViewActions.click())
        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows_fav)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.swipeRight()))
    }

    @Test
    fun clickFavoriteTvShowsAndGoToDetail() {
        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(withId(R.id.favButtonTvShow)).perform(ViewActions.click())
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.homeToFavorite)).perform(ViewActions.click())
        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows_fav)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(withId(R.id.tv_tvshow_release)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_duration)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_title)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_overview)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_genre)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_creator)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_cast)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTvShows() {
        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(withId(R.id.tv_tvshow_release)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_duration)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_title)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_overview)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_genre)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_creator)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_cast)).perform(ViewActions.swipeUp()).check(matches(isDisplayed()))
    }

}