package com.example.halanchallenge.presentation.utils

import androidx.lifecycle.Observer
import com.example.halanchallenge.presentation.utils.Event


class EventObserver<T>(private val observe: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let { value ->
            observe(value)
        }
    }
}