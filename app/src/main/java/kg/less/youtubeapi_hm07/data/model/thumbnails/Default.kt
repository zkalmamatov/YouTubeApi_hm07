package kg.less.youtubeapi_hm07.data.model.thumbnails

import com.google.gson.annotations.SerializedName

data class Default (
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)