package com.example.hiltcarengine

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DieselEngine @Inject constructor(): Engine {
    override fun start()= "Engine has started"
}