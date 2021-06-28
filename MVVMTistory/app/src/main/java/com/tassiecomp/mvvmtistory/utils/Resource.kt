package com.tassiecomp.mvvmtistory.utils

//it is useful when you define successful/unsuccessful
//you can handle all the progress state here
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data:T):Resource<T>(data)
    class Error<T>(message: String?,data:T? =null): Resource<T>(data,message)
    class Loading<T> : Resource<T>()
}