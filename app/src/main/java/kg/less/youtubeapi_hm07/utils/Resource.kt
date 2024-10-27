package kg.less.youtubeapi_hm07.utils

sealed class Resource<T> {
    class Loading<T> : Resource<T>()
    class Error<T>(val message: String) :Resource<T>()
    class Succes<T>(val data: T) : Resource<T>()
}