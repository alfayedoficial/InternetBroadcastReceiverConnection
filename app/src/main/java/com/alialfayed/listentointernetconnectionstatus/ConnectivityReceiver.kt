package com.alialfayed.listentointernetconnectionstatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build


/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/23/2021 - 1:30 PM
 */
class ConnectivityReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        connectivityReceiverListener?.onNetworkConnectionChanger(isConnectedOrConnecting(context!!))
    }

    private fun isConnectedOrConnecting(context: Context):Boolean{
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    interface ConnectivityReceiverListener{
        fun onNetworkConnectionChanger(isConnected: Boolean)
    }

    companion object{
        var connectivityReceiverListener:ConnectivityReceiverListener? = null
    }
}