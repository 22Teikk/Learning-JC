package com.teikk.learningjc.core.data.repository

import com.teikk.learningjc.core.model.SliderModel
import com.teikk.learningjc.core.network.datasource.FirebaseDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface BannerRepository {
    fun loadBanners(): Flow<List<SliderModel>>
}

internal class BannerRepositoryImpl @Inject constructor(
    private val firebaseDataSource: FirebaseDataSource
) : BannerRepository {

    override fun loadBanners(): Flow<List<SliderModel>> = firebaseDataSource.loadBanner()

}
