package com.example.nischay.mediumclone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nischay on 5/12/2020.
 */

public class blogFragment extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View blog = inflater.inflate(R.layout.fragment_blog, container, false);
        recyclerView = blog.findViewById(R.id.blog_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(blog.getContext()));

        final blogAdapter adapter = new blogAdapter();
        recyclerView.setAdapter(adapter);

        ((Button) blog.findViewById(R.id.add)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.insert("One");
            }
        });

        return blog;
    }

    private class blogAdapter extends RecyclerView.Adapter<blogAdapter.blogViewHolder> {
        ArrayList<String> data;

        @Override
        public blogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater from = LayoutInflater.from(parent.getContext());
            View inflate = from.inflate(R.layout.fragment_blog, parent, false);
            return new blogViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(blogViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public void insert(String one) {
            data.add(one);
            notifyItemInserted(data.size()-1);
        }

        protected class blogViewHolder extends RecyclerView.ViewHolder {
            TextView t1;
            public blogViewHolder(View itemView) {
                super(itemView);
                t1 = itemView.findViewById(R.id.text1);
            }
        }
    }
}
