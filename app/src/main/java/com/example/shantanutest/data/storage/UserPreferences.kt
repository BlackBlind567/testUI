package com.example.shantanutest.data.storage

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

import javax.inject.Inject


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_data_store")


class UserPreferences @Inject constructor(@ApplicationContext context: Context) {

    private val appContext = context.applicationContext

    val accessToken: Flow<String?>
        get() = appContext.dataStore.data.map { preferences ->
            preferences[ACCESS_TOKEN]
        }

    val refreshToken: Flow<String?>
        get() = appContext.dataStore.data.map { preferences ->
            preferences[REFRESH_TOKEN]
        }

    suspend fun saveAccessTokens(accessToken: String){
        appContext.dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN] = accessToken
        }
    }
    suspend fun clear() {
        appContext.dataStore.edit { preferences ->
            preferences.clear()
            println("myNewToken1 == ${preferences[ACCESS_TOKEN]}")
        }
//        appContext.dataStore.edit { preferences ->
//            preferences[ACCESS_TOKEN] = "1234"
//            println("myNewToken == ${preferences[ACCESS_TOKEN]}")
//        }

    }
    companion object {
        private val ACCESS_TOKEN = stringPreferencesKey("key_access_token")
        private val REFRESH_TOKEN = stringPreferencesKey("key_refresh_token")
    }
}