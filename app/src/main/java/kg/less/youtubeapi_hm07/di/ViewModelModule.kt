package kg.less.youtubeapi_hm07.di

import kg.less.youtubeapi_hm07.ui.fragment.play_list.PlayListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel {
        PlayListViewModel(get())
    }
}