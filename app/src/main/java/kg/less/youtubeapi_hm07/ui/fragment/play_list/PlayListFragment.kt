package kg.less.youtubeapi_hm07.ui.fragment.play_list

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kg.less.youtubeapi_hm07.databinding.FragmentPlayListBinding
import kg.less.youtubeapi_hm07.ui.base.BaseFragment
import kg.less.youtubeapi_hm07.utils.Resource


class PlayListFragment :

    BaseFragment<FragmentPlayListBinding>(FragmentPlayListBinding::inflate) {

    private val viewModel: PlayListViewModel by viewModels()
    private val playlistsAdapter: PlaylistsAdapter by lazy { PlaylistsAdapter() }

    override fun setupViews() {
        super.setupViews()
        setupRecycler()
    }

    override fun setupObservers() {
        viewModel.getPlayLists().stateHandler(
            succes = { data ->
                playlistsAdapter.submitList(data)
            },
            state = { state ->
                binding.pbLoaded.isVisible = state is Resource.Loading
            }
        )
    }

    private fun setupRecycler() = with(binding.rvPlaylist) {
        adapter = playlistsAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

}