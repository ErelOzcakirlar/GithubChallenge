package com.erel.githubchallenge.features.repo.data

interface RepoRepository {
    suspend fun getRepo(user: String, repo: String): RepoRaw
}

class DefaultRepoRepository(private val repoService: RepoService) : RepoRepository {
    override suspend fun getRepo(user: String, repo: String): RepoRaw =
        repoService.getRepo(user, repo)
}