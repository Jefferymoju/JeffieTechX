package com.jeffery.androidapp.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeffery.androidapp.data.MongoSync
import com.jeffery.androidapp.models.Post
import com.jeffery.androidapp.util.Constants.APP_ID
import com.jeffery.androidapp.util.RequestState
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * ViewModel responsible for managing data related to the home screen.
 * This includes fetching all posts and performing searches by title.
 */
class HomeViewModel: ViewModel() {
    private val _allPosts: MutableState<RequestState<List<Post>>> =
        mutableStateOf(RequestState.Idle)
    val allPosts: State<RequestState<List<Post>>> = _allPosts

    private val _searchedPosts: MutableState<RequestState<List<Post>>> =
        mutableStateOf(RequestState.Idle)
    val searchedPosts: State<RequestState<List<Post>>> = _searchedPosts

    init {
        viewModelScope.launch (Dispatchers.IO){
            App.create(APP_ID).login(Credentials.anonymous())
            fetchAllPosts()
        }
    }

    /**
     * Fetches all posts from the MongoDB Realm.
     */
    private suspend fun fetchAllPosts() {
        withContext(Dispatchers.Main) {
            _allPosts.value = RequestState.Loading
        }
        MongoSync.readAllPosts().collectLatest {
            _allPosts.value = it
        }
    }

    /**
     * Searches posts by title using the provided query.
     * @param query The search query entered by the user.
     */
    fun searchPostsByTitle(query: String) {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                _searchedPosts.value = RequestState.Loading
            }
            MongoSync.searchPostsByTitle(query = query).collectLatest { searched ->
                _searchedPosts.value = searched
            }
        }
    }

    /**
     * Resets the state of searched posts to idle.
     * This is typically called when the search query is cleared.
     */
    fun resetSearchedPosts() {
        _searchedPosts.value = RequestState.Idle
    }
}