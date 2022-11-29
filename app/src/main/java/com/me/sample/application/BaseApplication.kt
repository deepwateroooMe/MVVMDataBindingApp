package com.me.sample.application

import android.app.Application

class BaseApplication : Application() {

    companion object {
        var _context: Application? = null
        fun getApplicationContext(): Application {
            return _context!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        _context = this
    }
}