package com.teikk.learningjc.feature.home.impl.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.teikk.learningjc.core.navigation.Navigator
import com.teikk.learningjc.feature.home.api.HomeNavKey
import com.teikk.learningjc.feature.home.impl.HomeScreen
import com.teikk.learningjc.feature.home.impl.HomeViewModel

fun EntryProviderScope<NavKey>.homeEntry(navigator: Navigator) {
    entry<HomeNavKey> { key ->
        HomeScreen(
            viewModel = hiltViewModel<HomeViewModel, HomeViewModel.Factory>(
                creationCallback = { factory -> factory.create(key) }
            )
        )
    }
}
