package com.example.mydaggerapplication.components

import com.example.mydaggerapplication.constructors.registration.UserRegistrationService
import dagger.Component

@Component
public interface UserRegistrationComponent {
    fun getUserRegistrationService() : UserRegistrationService
}