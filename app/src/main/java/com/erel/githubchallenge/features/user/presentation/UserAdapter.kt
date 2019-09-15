package com.erel.githubchallenge.features.user.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erel.githubchallenge.R
import com.erel.githubchallenge.features.repo.domain.RepoUI
import com.erel.githubchallenge.features.user.domain.UserUI
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_search_repo.view.textRepoName
import kotlinx.android.synthetic.main.item_user.view.*
import kotlinx.android.synthetic.main.item_user_repo.view.*

class UserAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data: UserUI? = null

    var repoClickListener: (user: String, repo: String) -> Unit = { _, _ -> }

    fun setData(newData: UserUI) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == VIEW_TYPE_USER) {
            UserViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_user,
                    parent,
                    false
                )
            )
        } else {
            UserRepoViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_user_repo,
                    parent,
                    false
                )
            )
        }

    override fun getItemCount() = data?.let {
        it.repos.size + 1
    } ?: 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? UserViewHolder)?.bind(data!!)
        (holder as? UserRepoViewHolder)?.bind(data!!.repos[position - 1], repoClickListener)
    }

    override fun getItemViewType(position: Int) = if (position == 0) {
        VIEW_TYPE_USER
    } else {
        VIEW_TYPE_REPO
    }

    companion object {
        private const val VIEW_TYPE_USER = 0
        private const val VIEW_TYPE_REPO = 1
    }
}

class UserViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
    fun bind(item: UserUI) {
        root.textUserName.text = item.name
        root.textCompany.text = item.company
        root.textLocation.text = item.location
        root.textBio.text = item.bio
        Picasso.get().load(item.profileImage).fit().centerCrop().into(root.imageAvatar)
    }
}

class UserRepoViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
    fun bind(
        item: RepoUI,
        repoClickListener: (user: String, repo: String) -> Unit
    ) {
        root.setOnClickListener { repoClickListener(item.owner.id, item.name) }
        root.textRepoName.text = item.name
        root.textRepoLanguage.text = item.language
    }
}