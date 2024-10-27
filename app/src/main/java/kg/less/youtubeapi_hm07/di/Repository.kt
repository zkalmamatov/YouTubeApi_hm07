package kg.less.youtubeapi_hm07.di

import kg.less.youtubeapi_hm07.data.repository.YouTubeRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    single { YouTubeRepository(get()) }
}