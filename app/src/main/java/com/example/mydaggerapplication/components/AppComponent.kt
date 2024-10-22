package com.example.mydaggerapplication.components

import com.example.mydaggerapplication.activities.MainActivity
import com.example.mydaggerapplication.classes.ActivityScope
import com.example.mydaggerapplication.dimodules.NetworkModule
import dagger.Component

@ActivityScope
@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
}