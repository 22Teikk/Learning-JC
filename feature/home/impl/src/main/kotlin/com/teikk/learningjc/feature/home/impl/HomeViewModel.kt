package com.teikk.learningjc.feature.home.impl

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teikk.learningjc.core.data.repository.BannerRepository
import com.teikk.learningjc.core.model.SliderModel
import com.teikk.learningjc.feature.home.api.HomeNavKey
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel(assistedFactory = HomeViewModel.Factory::class)
class HomeViewModel @AssistedInject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val bannerRepository: BannerRepository,
    @Assisted private val key: HomeNavKey
) : ViewModel() {

    val banners : StateFlow<List<SliderModel>> = bannerRepository.loadBanners().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

    @AssistedFactory
    interface Factory {
        fun create(
            key: HomeNavKey
        ) : HomeViewModel
    }
}
