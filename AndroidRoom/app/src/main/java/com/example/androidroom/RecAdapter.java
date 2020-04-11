package com.example.androidroom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.VH>{
    private Context context;
    private List<Word> mWords;

    public RecAdapter(Context context){
        this.context = context;


    }
    public RecAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.item,null);

        return new RecAdapter.VH(view);
    }

    @Override
    public void onBindViewHolder(RecAdapter.VH holder, int position) {
        if (mWords != null) {
            Word current = mWords.get(position);
            holder.mTextView.setText(current.getWord());
        } else {

            holder.mTextView.setText("No Word");
        }


    }
    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;


    }

    public static class VH extends RecyclerView.ViewHolder{

        private TextView mTextView;
        public VH( View itemView) {
            super(itemView);
            itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT));

            mTextView=itemView.findViewById(R.id.textview);
        }




    }

}

