package dev.elvir.morecommunication.ui.splas_screen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.ui.sign_in_mode.SignInModeScreenActivity
import ua.naiksoftware.stomp.StompClient


class SplashScreenActivity : AppCompatActivity() {

    lateinit var stompClient: StompClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_splash_screen)
//        createWebSocketClient();
        Handler().postDelayed({
            startActivity(Intent(this, SignInModeScreenActivity::class.java))
        }, 800)
    }

//    private fun createWebSocketClient() {
//        stompClient = Stomp.over(
//            Stomp.ConnectionProvider.OKHTTP,
//            "ws://192.168.43.244:9090/example-endpoint/websocket"
//        )
//        stompClient.connect()
//        stompClient.lifecycle().subscribe {
//            when (it.type) {
//                LifecycleEvent.Type.OPENED -> {
//                    Log.i("WebSocket", "Stomp connection opened");
//                }
//                LifecycleEvent.Type.CLOSED -> {
//                    Log.i("WebSocket", "Stomp connection closed");
//                }
//                LifecycleEvent.Type.ERROR -> {
//                    Log.i("WebSocket", "Stomp connection error");
//                    it.exception.printStackTrace()
//                }
//            }
//        }
//        stompClient.topic("/topic/greetings")
//            .subscribe({
//                Log.i("WebSocket", "recieved ${it.payload}")
//            })
//        stompClient.send("/topic/hello-msg-mapping", "My first STOMP message!").subscribe { }
//
//
//    }
//
}
//
//
//class Chat {
//    var chatId : Long = 123
//    var chatName : String = "undefined"
//    var memberSize : Int = 0
//    var memberId: ArrayList<Long> = arrayListOf(1,2,3)
//    var lastMessage : String = ""
//}
//
