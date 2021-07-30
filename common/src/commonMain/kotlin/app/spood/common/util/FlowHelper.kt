package app.spood.common.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

fun <T> Flow<T>.asCommonFlow(): CommonFlow<T> = CommonFlow(this)

class CommonFlow<T>(private val origin: Flow<T>) : Flow<T> by origin {

    suspend fun collectCommon(callback: (T) -> Unit) {
        collect { callback(it) }
    }
}