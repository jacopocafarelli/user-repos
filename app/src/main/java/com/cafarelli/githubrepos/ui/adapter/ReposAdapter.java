package com.cafarelli.githubrepos.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cafarelli.githubrepos.R;
import com.cafarelli.githubrepos.model.Repo;

import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder>{

    private List<Repo> repoList;

    public void setRepoList(List<Repo> repoList) {
        this.repoList = repoList;
        notifyDataSetChanged();
    }

    public List<Repo> getRepoList() {
        return repoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.repo_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Repo repo = repoList.get(position);
        holder.name.setText(repo.name);
        holder.description.setText(repo.description);
    }

    @Override
    public int getItemCount() {
        return repoList != null ? repoList.size() : 0;
    }

    public void clear() {
        repoList = null;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView description;

        ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_repo_name);
            description = (TextView) itemView.findViewById(R.id.tv_repo_description);
        }
    }
}
