package com.example.matches.present.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.matches.data.network.ApiFactory
import com.example.matches.model.MatchItem
import com.example.matches.model.MatchResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel:ViewModel(){

    var num = 0;
    private val isLoad = MutableLiveData<Boolean>()
    val _isLoad: LiveData<Boolean>
        get() = _isLoad

    private val matches = MutableLiveData<List<MatchItem>>()
    val _matches:LiveData<List<MatchItem>>
    get()=_matches

    val compositeDisposable = CompositeDisposable()

    public fun loadMatch(){
        val load: Boolean = isLoad.value!!
        if (load != null && load) {
            return
        }

        compositeDisposable.add(ApiFactory.apiservice.loadMatches(num)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{ isLoad.setValue(true)
            }
            .doAfterTerminate(Action { isLoad.setValue(false)
            })
            .subscribe({response -> onResponse(response)}, {t -> onFailure(t) }))
    }

    private fun onFailure(t: Throwable) {
    }

    private fun onResponse(matchResponse: MatchResponse) {
        val loadMatch: MutableList<MatchItem> = matches.value as MutableList<MatchItem>
        if (loadMatch != null) {
            loadMatch.addAll(matchResponse.list)
            matches.setValue(loadMatch)
        } else {
            matches.setValue(matchResponse.list)
        }
        num++
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
    }
