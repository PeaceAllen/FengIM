package com.fjz.im.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fjz.im.android.databinding.ActivityMainBinding
import io.socket.client.Socket
import io.socket.emitter.Emitter

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {


    private lateinit var mBinding: ActivityMainBinding
    private val mSocket: Socket by lazy {
        (application as App).socket!!
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mBinding.root)


        mBinding.btnConnect.setOnClickListener {
            mSocket.on(Socket.EVENT_CONNECT, onConnect)
            mSocket.on(Socket.EVENT_DISCONNECT, onDisconnect)
            mSocket.connect()
            Log.i(TAG, "connect msg")
        }


        mBinding.btnLogin.setOnClickListener {
            Log.i(TAG, "send msg: add user")

            mSocket.emit("add user", "fengjz")

        }

    }

    private val onConnect = Emitter.Listener {
        Log.i(TAG, "on connection: ")
    }


    private val onDisconnect = Emitter.Listener {
        Log.i(TAG, "on disconnection: ")
    }


}