package com.teikk.learningjc.core.network.datasource

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.teikk.learningjc.core.model.SliderModel
import com.teikk.learningjc.core.network.utils.FirebaseConst
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import timber.log.Timber
import javax.inject.Inject

class FirebaseDataSource @Inject constructor(
    private val database: FirebaseDatabase,
) {

    fun loadBanner(): Flow<List<SliderModel>> = callbackFlow<List<SliderModel>> {
        val ref = database.getReference(FirebaseConst.Table.BANNER)
        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val listBanner = mutableListOf<SliderModel>()
                p0.children.forEach { childSnapshot ->
                    childSnapshot.getValue(SliderModel::class.java)?.let { listBanner.add(it) }
                }
                trySend(listBanner)
            }

            override fun onCancelled(p0: DatabaseError) {
                Timber.tag(TAG).e(p0.toException(), "Failed to load banners from Firebase")
            }

        }
        ref.addValueEventListener(valueEventListener)
        awaitClose {
            ref.removeEventListener(valueEventListener)
        }
    }.distinctUntilChanged()

    companion object {
        private const val TAG = "FirebaseDataSource"
    }
}
