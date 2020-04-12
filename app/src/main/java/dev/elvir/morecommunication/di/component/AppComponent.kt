package dev.elvir.morecommunication.di.component

import dagger.Component
import dev.elvir.morecommunication.App
import dev.elvir.morecommunication.data.db.dao.AuthDao
import dev.elvir.morecommunication.data.db.dao.ChatDao
import dev.elvir.morecommunication.data.db.dao.UserDao
import dev.elvir.morecommunication.data.repository.AuthRepository
import dev.elvir.morecommunication.data.repository.ChatRepository
import dev.elvir.morecommunication.data.repository.CurrentUserRepository
import dev.elvir.morecommunication.di.module.*
import dev.elvir.morecommunication.ui.chat.ChatScreenFragment
import dev.elvir.morecommunication.ui.chat_list_screen.ChatListScreenFragment
import dev.elvir.morecommunication.ui.search.SearchFragment
import dev.elvir.morecommunication.ui.sign_in_anonymously.SignInAnonymouslyScreenActivity
import dev.elvir.morecommunication.ui.splas_screen.SplashScreenActivity
import retrofit2.Retrofit
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@Component(
    modules = [
        NetworkModule::class,
        AppModule::class,
        PreferencesModule::class,
        RepositoryModule::class,
        RoomModule::class,
        SocketModule::class
    ]
)
@AppScope
interface AppComponent {

    fun inject(app: App)
 //   fun inject(searchFragment: SearchFragment)
  //  fun inject(chatScreenFragment: ChatScreenFragment)
   // fun inject(chatListScreenFragment: ChatListScreenFragment)

    fun getAuthRepository(): AuthRepository
    fun getCurrentUserRepository(): CurrentUserRepository
    fun getChatRepository():ChatRepository
    fun getRetrofit(): Retrofit

    fun userDao(): UserDao
    fun AuthDao(): AuthDao
    fun chatDao():ChatDao

}