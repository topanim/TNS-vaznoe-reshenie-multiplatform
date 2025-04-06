package app.what.gorogeuslugi.data

import app.what.gorogeuslugi.foundation.utils.orThrow


object AppSettings {
    private var token: String? = null

    fun getToken() = token.orThrow
    fun getTokenOrNull() = token
    fun setToken(value: String) { token = value }
}