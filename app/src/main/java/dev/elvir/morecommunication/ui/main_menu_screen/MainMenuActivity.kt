package dev.elvir.morecommunication.ui.main_menu_screen

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.ext.addFragment
import dev.elvir.morecommunication.ui.base.BaseActivity
import dev.elvir.morecommunication.ui.chat_list_screen.ChatListScreenFragment
import dev.elvir.morecommunication.ui.news_list_screen.NewsListScreenFragment
import kotlinx.android.synthetic.main.act_main_menu_screen.*


class MainMenuActivity : BaseActivity() {
    private var fragmentChatList = ChatListScreenFragment.newInstance()
    private var fragmentNewsList = NewsListScreenFragment.newInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorMainLogo)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main_menu_screen)
        bn_main_navigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_chat))
        bn_main_navigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_newspaper))
        bn_main_navigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_screen_player))
        bn_main_navigation.add(MeowBottomNavigation.Model(4, R.drawable.ic_user))
        bn_main_navigation.setOnClickMenuListener { handlerBottomMenuNavigation(it.id) }
        bn_main_navigation.show(1)
        addFragment( fragmentChatList,R.id.rootContainer, false)
        addFragment(fragmentNewsList,R.id.rootContainer,  false)
        supportFragmentManager.beginTransaction().hide(fragmentNewsList).commit()

    }


    private fun handlerBottomMenuNavigation(id: Int) {
        when (id) {
            1 -> {
                if (fragmentChatList.isHidden) {
                    supportFragmentManager.beginTransaction()
                        .show(fragmentChatList)
                        .commit()
                    supportFragmentManager.beginTransaction().hide(fragmentNewsList).commit()

                }
            }
            2 -> {
                if (fragmentNewsList.isHidden) {
                    supportFragmentManager.beginTransaction()
                        .show(fragmentNewsList)
                        .commit()
                    supportFragmentManager.beginTransaction().hide(fragmentChatList).commit()
                }
            }
            else -> {
            }
        }
    }


}