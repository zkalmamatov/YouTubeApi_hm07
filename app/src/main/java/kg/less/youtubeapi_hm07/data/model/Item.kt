package kg.less.youtubeapi_hm07.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("contentDetails")
    val contentDetails: ContentDetails,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("snipped")
    val snipped: Snippet
)