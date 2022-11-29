package com.me.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.me.sample.ArticleAdapter.MyViewHolder
import com.me.sample.databinding.LayoutItemBinding
import com.me.sample.model.Data

class ArticleAdapter(private val mList: List<Data>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        // 不知道lay_item.xml自动生成的databinding 类的名字,两个这里是否写对了 ?        
        val bind = DataBindingUtil.bind<LayoutItemBinding>(v)
        return bind?.let { MyViewHolder(it) }!!
    }
    override fun getItemCount(): Int {
        return mList.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val binding = holder.binding
        binding.data = mList[position]
    }
    // 在构造函数中声明binding变量，这样holder才能引用到，如果不加val/var，就引用不到，就需要在class的{}内写get函数
    inner class MyViewHolder(
        var binding: LayoutItemBinding
    ) : RecyclerView.ViewHolder(binding.root)
}