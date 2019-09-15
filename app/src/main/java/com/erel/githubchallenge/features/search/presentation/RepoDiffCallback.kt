package com.erel.githubchallenge.features.search.presentation

import androidx.recyclerview.widget.DiffUtil
import com.erel.githubchallenge.features.repo.domain.RepoUI

class RepoDiffCallback(private val oldRepos: List<RepoUI>, private val newRepos: List<RepoUI>) :
    DiffUtil.Callback() {

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean =
        oldRepos[oldPosition].id == newRepos[newPosition].id

    override fun getOldListSize(): Int = oldRepos.size

    override fun getNewListSize(): Int = newRepos.size

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean =
        oldRepos[oldPosition] == newRepos[newPosition]

}