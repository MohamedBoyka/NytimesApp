package com.boyka.nytimesapp.viewModel

/*import androidx.hilt.lifecycle.ViewModelInject*/
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boyka.domain.model.AnytimesResponse
import com.boyka.domain.usecase.GetNews
import com.boyka.nytimesapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNews: GetNews
): ViewModel(){

    private val _res = MutableLiveData<Resource<AnytimesResponse>>()

    val res : LiveData<Resource<AnytimesResponse>>
        get() = _res

    init {
        getData()
    }

    private fun getData()  = viewModelScope.launch {
        _res.postValue(Resource.loading(null))
        getNews.getData().let {
            if (it.isSuccessful){
                _res.postValue(Resource.success(it.body()))
            }else{
                _res.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }

}