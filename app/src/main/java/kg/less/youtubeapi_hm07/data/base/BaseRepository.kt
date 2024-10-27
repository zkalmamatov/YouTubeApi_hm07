package kg.less.youtubeapi_hm07.data.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kg.less.youtubeapi_hm07.data.repository.ARG_ERROR_MESSAGE
import kg.less.youtubeapi_hm07.utils.Resource
import kotlinx.coroutines.Dispatchers
import okio.IOException
import retrofit2.HttpException
import retrofit2.Response

abstract class BaseRepository {

    fun <T> sendRequest(
        requestFun: suspend () -> Response<T>
    ): LiveData<Resource<T>> = liveData(Dispatchers.IO) {
        try {
            val response = requestFun()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Succes(it))
                } ?: run {
                    emit(Resource.Error("Пустое тело ответа"))
                }
            } else {
                emit(Resource.Error("Ошибка: ${response.code()} ${response.message()}"))
            }
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ARG_ERROR_MESSAGE))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ARG_ERROR_MESSAGE))
        }
    }
}