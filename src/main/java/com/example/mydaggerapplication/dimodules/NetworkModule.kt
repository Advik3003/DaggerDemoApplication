package com.example.mydaggerapplication.dimodules

import com.example.mydaggerapplication.classes.ActivityScope
import com.example.mydaggerapplication.classes.HttpClient
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @ActivityScope
    @Provides
    fun provideHttpClient(): HttpClient {
          return HttpClient();
    }
}