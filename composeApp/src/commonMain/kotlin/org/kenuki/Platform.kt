package org.kenuki

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform