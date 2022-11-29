package com.me.sample.ui

import androidx.lifecycle.ViewModelProviders
import com.me.sample.api.ApiNetWork

class MainActivity : BaseActivity() {

// 工厂模式先(生产)出一个视图模型来,视图模型总是与模型仓库紧密相接的    
    private val viewModel by lazy {
        val modelFactory = ArticleModelFactory(ArticleRepository(ApiNetWork))
        ViewModelProviders.of(this, modelFactory).get(ArticleViewModel::class.java)
    }
    private val binding by lazy {
        // TODO: 检查这里名字写对了吗?
        DataBindingUtil.setContentView<LayoutMainBinding>(this, R.layout.layout_main)
    }

// 第一次创建的时候:    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
        binding.lifecycleOwner = this

        post(viewModel.data).observe(
            this,
            Observer {
                var adapter = ArticleAdapter(it)
                binding.rvList?.let { it1 ->
                                          it1.layoutManager = LinearLayoutManager(this)
                                      it1.addItemDecoration(DividerItemDecoration(3,"#e5e5e5"))
                                      it1.addOnItemTouchListener(
                                          RecyclerItemClickListener(
                                              this,it1,
                                              object : OnItemClickListener {
                                                  override fun onItemClick(view: View, position: Int) {
// 这里太难看,可以再改写一下                                                      
                                                      toast(it[position].title)
                                                  }
                                      }))
                }
                binding.adapter = adapter
        })
        viewModel.getArticle()
    }
}

