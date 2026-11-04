package com.teikk.learningjc.feature.intro.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.teikk.learningjc.core.navigation.Navigator
import com.teikk.learningjc.feature.intro.api.navigation.IntroNavKey
import com.teikk.learningjc.feature.intro.impl.IntroScreen

fun EntryProviderScope<NavKey>.introEntry(navigator: Navigator) {
    entry<IntroNavKey> {
        IntroScreen()
    }
}
