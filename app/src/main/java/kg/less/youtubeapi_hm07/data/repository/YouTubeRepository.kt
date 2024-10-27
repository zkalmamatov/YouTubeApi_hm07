package kg.less.youtubeapi_hm07.data.repository

import androidx.lifecycle.LiveData
import kg.less.youtubeapi_hm07.BuildConfig
import kg.less.youtubeapi_hm07.data.api_services.YouTubeApi
import kg.less.youtubeapi_hm07.data.base.BaseRepository
import kg.less.youtubeapi_hm07.data.model.BaseResponse
import kg.less.youtubeapi_hm07.data.model.Item
import kg.less.youtubeapi_hm07.utils.Constants
import kg.less.youtubeapi_hm07.utils.Resource
import retrofit2.Response

const val ARG_ERROR_MESSAGE = "Unknown Error"

class YouTubeRepository (
    private val api: YouTubeApi
) : BaseRepository() {

    fun getPlayLists(): LiveData<Resource<List<Item>>> = sendRequest {
        val response: Response<BaseResponse> = api.fetchPlaylists(
            channelId =  Constants.CHANNEL_ID,
            part = Constants.PART,
            maxResults = Constants.MAX_RESULTS,
            apiKey = BuildConfig.API_KEY
        )
        if (response.isSuccessful) {
            Response.success(response.body()?.items ?: emptyList())
        }else {
            Response.error(response.errorBody()!!, response.raw())
        }
    }
}