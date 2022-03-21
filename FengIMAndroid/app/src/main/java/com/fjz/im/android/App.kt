package com.fjz.im.android

import android.app.Application
import android.util.Log
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException


/**
 * Created by Jinzhen Feng on 2022/3/21.
 * Copyright (c) 2022 Podbean. All rights reserved.
 */

private const val TAG = "APP"
class App : Application(){

    private var mSocket: Socket? = null
    val socket: Socket?
        get() = mSocket

    init {
        mSocket = try {
            IO.socket(CHAT_SERVER_URL)
        } catch (e: URISyntaxException) {
            Log.i(TAG, "error: $e")
            throw RuntimeException(e)
        }
    }


}