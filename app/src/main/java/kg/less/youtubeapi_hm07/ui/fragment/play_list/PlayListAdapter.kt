package kg.less.youtubeapi_hm07.ui.fragment.play_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kg.less.youtubeapi_hm07.data.model.Item
import kg.less.youtubeapi_hm07.databinding.ItemPlaylistsBinding

class PlaylistsAdapter :
    ListAdapter<Item, PlaylistsAdapter.PlaylistViewHolder>(PlaylistItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(
            ItemPlaylistsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class PlaylistViewHolder(
        private val binding: ItemPlaylistsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(playlists: Item) {
            with(binding) {
                tvNamePlaylist.text = playlists.snipped.title
                tvQuantityVideo.text = playlists.contentDetails.itemCount.toString()
                imgPlaylists.load(playlists.snipped.thumbnails.medium.url)
            }
        }
    }
}

class PlaylistItemCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
}