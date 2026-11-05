package com.teikk.learningjc.feature.intro.impl

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.teikk.learningjc.core.data.repository.BannerRepository
import com.teikk.learningjc.feature.intro.api.navigation.IntroNavKey
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = IntroViewModel.Factory::class)
class IntroViewModel @AssistedInject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val bannerRepository: BannerRepository,
    @Assisted private val key: IntroNavKey
) : ViewModel() {

    val banners = bannerRepository.loadBanners()
    @AssistedFactory
    interface Factory {
        fun create(
            key: IntroNavKey
        ) : IntroViewModel
    }
}
