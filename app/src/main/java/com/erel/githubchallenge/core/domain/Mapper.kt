package com.erel.githubchallenge.core.domain

interface Mapper<Raw, Clean> {
    fun map(raw: Raw): Clean
}