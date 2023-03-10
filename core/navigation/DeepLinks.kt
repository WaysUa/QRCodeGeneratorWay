package com.main.core.navigation

import androidx.core.net.toUri


object DeepLinks {
    val BOOK_READING_DEEP_LINK = "bookReader://reading".toUri()
    val BOOKS_DEEP_LINK = "bookReader://books".toUri()
}