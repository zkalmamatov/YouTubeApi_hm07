package kg.less.youtubeapi_hm07.data.model

import com.google.gson.annotations.SerializedName
import kg.less.youtubeapi_hm07.data.model.thumbnails.Thumbnails

data class Snippet(
    @SerializedName("channelId")
    val channelId: String,
    @SerializedName("channelTitle")
    val channelTitle: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("thumbnails")
    val thumbnails: Thumbnails,
    @SerializedName("title")
    val title: String
)