package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row_hero.view.*

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    override fun onBindViewHolder(holder: ListHeroAdapter.ListViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHeroAdapter.ListViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var onItemClickCallback: ListHeroAdapter.OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: ListHeroAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

        override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
            val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_hero, viewGroup, false)
            return ListViewHolder(view)
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            holder.bind(listHero[position])
        }

        override fun getItemCount(): Int = listHero.size
        inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(hero: Hero) {
                with(itemView){
                    Glide.with(itemView.context)
                        .load(hero.photo)
                        .apply(RequestOptions().override(55, 55))
                        .into(img_item_photo)

                    tv_item_name.text = hero.name
                    tv_item_description.text = hero.description

                    itemView.setOnClickListener { onItemClickCallback?.onItemClicked(hero) }
                }
            }
        }

        interface OnItemClickCallback {
            fun onItemClicked(data: Hero)
        }
    }