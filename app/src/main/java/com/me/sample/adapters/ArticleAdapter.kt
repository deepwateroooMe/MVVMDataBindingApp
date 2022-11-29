package com.me.sample.adapters

class ArticleAdapter (private val mList: List<Data>) : RecyclerView.Adapter<ArticleAdapter.MyViewHolder>() {

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

    // TODO: 这里,关于单个条目中的动态图片加载,这里还需要再多一点儿的工作 GLIDE 图库加载
    // 跟自己以前的版本对比,搜索一下,找一个解决方案
    inner class MyViewHolder(
        var binding: LayoutItemBinding
    ) : RecyclerView.ViewHolder(binding.root)
}