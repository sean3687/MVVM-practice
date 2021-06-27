package com.tassiecomp.mvvmtistory.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tassiecomp.mvvmtistory.R
import com.tassiecomp.mvvmtistory.models.Article
import kotlinx.android.synthetic.main.item_article_preview.view.*

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {


    //viewholder를 만들어줍니다.
    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object: DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {

            // 이함수는 oldItem과 new Item이 같은지 확인하는 함수입니다.
            // oldItem과 newItem은 전에 만들었던 article dataclass의 타입을 가지고있습니다.
            // 같은아이템인지 확인하려면 두 아이템에 고유ID를 확인해줘야합니다.
            // 기사마자 다른 url을 가지고있기때문에 data class에서 각 아이템의 url을 확인해주겠습니다.

            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            //둘의 컨텐츠도 비교해줍니다.
            return oldItem == newItem
        }

    }

    //async list differ은 두리스트를 가져와서 둘이 다른지 백그라운드에서 계산 하는 함수입니다.
    //추가시작
    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_article_preview,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply{
            Glide.with(this).load(article.urlToImage).into(ivArticleImage)
            tvSource.text = article.source.name
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvPublishedAt.text = article.publishedAt
            setOnClickListener{
                onItemClickListener?.let{
                    it(article)
                }
            }
        }
    }

    private var onItemClickListener: ((Article) -> Unit?)? = null

    fun setOnItemClickListener(listener: (Article)->Unit){
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        //리사이클러뷰에서는 보통 리스트를 받아서 그 리스트 사이즈를 count하지만 리스트를 asynclistdiffer가 관리하기때문에, differ에 item갯수로 연결해주어야합니다.
        return differ.currentList.size
    }
    //추가끝
}