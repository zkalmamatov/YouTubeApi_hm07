package kg.less.youtubeapi_hm07.app

import android.app.Application
import kg.less.youtubeapi_hm07.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(appModule)
        }
    }
}