package kg.less.youtubeapi_hm07.ui.fragment.play_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kg.less.youtubeapi_hm07.data.model.Item
import kg.less.youtubeapi_hm07.data.repository.YouTubeRepository
import kg.less.youtubeapi_hm07.utils.Resource

class PlayListViewModel  (
    private val repository: YouTubeRepository
) : ViewModel() {

    fun getPlayLists(): LiveData<Resource<List<Item>>> {
        return repository.getPlayLists()
    }
}