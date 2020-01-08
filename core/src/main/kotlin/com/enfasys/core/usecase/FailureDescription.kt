package com.enfasys.core.usecase

sealed class FailureDescription {
    object NetworkConnectionError : FailureDescription()

    data class WithThrowable(val throwable: Throwable) : FailureDescription() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as WithThrowable

            if (throwable != other.throwable) return false

            return true
        }

        override fun hashCode(): Int {
            return throwable.hashCode()
        }
    }

    open class WithFeature(val message: String) : FailureDescription() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as WithFeature

            if (message != other.message) return false

            return true
        }

        override fun hashCode(): Int {
            return message.hashCode()
        }
    }
}

object NoDataInServerResponseError : Throwable()
object NoMessageInServerResponseError : Throwable()
object NoTokenAvailableError : Throwable()
object NoFileAvailableError : Throwable()