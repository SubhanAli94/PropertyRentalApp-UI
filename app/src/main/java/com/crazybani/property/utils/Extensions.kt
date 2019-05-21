package com.crazybani.property.utils

/** Convenience for callbacks/listeners whose return value indicates an event was consumed. */
inline fun consume(f: () -> Unit): Boolean{
    f()
    return true
}