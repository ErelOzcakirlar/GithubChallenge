package com.erel.githubchallenge.core.extensions

const val EMPTY = ""

fun String?.orEmpty() = this ?: EMPTY