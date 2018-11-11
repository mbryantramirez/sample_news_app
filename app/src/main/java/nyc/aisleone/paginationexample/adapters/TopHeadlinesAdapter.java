package nyc.aisleone.paginationexample.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import nyc.aisleone.paginationexample.R;
import nyc.aisleone.paginationexample.models.ArticlesItem;
import nyc.aisleone.paginationexample.models.TopHeadlines;

public class TopHeadlinesAdapter extends RecyclerView.Adapter<TopHeadlinesAdapter.TopHeadlinesViewHolder> {

    private List<ArticlesItem> articlesItems = new ArrayList<>();

    public TopHeadlinesAdapter() {
    }

    public void addArticles(List<ArticlesItem> articlesItems) {
        this.articlesItems.addAll(articlesItems);
    }

    @NonNull
    @Override
    public TopHeadlinesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.article_item, viewGroup, false);
        return new TopHeadlinesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TopHeadlinesViewHolder topHeadlinesViewHolder, int i) {

        topHeadlinesViewHolder.articleTitle.setText(articlesItems.get(i).getTitle());
        topHeadlinesViewHolder.articleDescription.setText(articlesItems.get(i).getDescription());
        topHeadlinesViewHolder.articleDescription.setSelected(true);
        Picasso.get()
                .load(articlesItems.get(i).getUrlToImage())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .fit().centerCrop()
                .into(topHeadlinesViewHolder.articleImage);
    }

    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    public static class TopHeadlinesViewHolder extends RecyclerView.ViewHolder {

        public TextView articleTitle;
        public TextView articleDescription;
        public ImageView articleImage;

        public TopHeadlinesViewHolder(@NonNull View itemView) {
            super(itemView);
            articleTitle = itemView.findViewById(R.id.tv_article_title);
            articleImage = itemView.findViewById(R.id.iv_article_image);
            articleDescription = itemView.findViewById(R.id.tv_article_desc);
        }
    }
}
