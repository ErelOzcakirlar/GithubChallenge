package com.erel.githubchallenge.features.search.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.erel.githubchallenge.R
import com.erel.githubchallenge.features.repo.domain.RepoUI
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_search_repo.view.*

class SearchAdapter : RecyclerView.Adapter<SearchRepoViewHolder>() {

    private var data = listOf<RepoUI>()

    var userClickListener: (String) -> Unit = {}
    var repoClickListener: (user:String, repo:String) -> Unit = { _, _ ->}

    fun setData(newData: List<RepoUI>) {
        val diffResult = DiffUtil.calculateDiff(RepoDiffCallback(data, newData))
        data = newData
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchRepoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_search_repo, parent, false)
        )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: SearchRepoViewHolder, position: Int) =
        holder.bind(data[position], userClickListener, repoClickListener)

}

class SearchRepoViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
    fun bind(
        item: RepoUI,
        userClickListener: (String) -> Unit,
        repoClickListener: (user:String, repo:String) -> Unit
    ) {
        root.setOnClickListener { repoClickListener(item.owner.id, item.name) }
        root.imageOwnerAvatar.setOnClickListener { userClickListener(item.owner.id) }
        root.textRepoName.text = item.name
        root.textOwnerName.text = item.owner.id
        Picasso.get().load(item.owner.profileImage).fit().centerCrop().into(root.imageOwnerAvatar)
    }
}