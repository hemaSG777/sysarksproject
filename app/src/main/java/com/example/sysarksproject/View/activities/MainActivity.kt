package com.example.sysarksproject.View.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.sysarksproject.Database.GoodsDatabase
import com.example.sysarksproject.View.adapters.AddItemAdapter
import com.example.sysarksproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val goodsAdapter by lazy { AddItemAdapter(this) }
    private val goodsDB: GoodsDatabase by lazy {
        Room.databaseBuilder(this, GoodsDatabase::class.java, "room_table")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.goodsRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.goodsRv.adapter = goodsAdapter

        binding.addGoods.setOnClickListener {
            val intent = Intent(this@MainActivity, AddGoodsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        checkItem()
    }

    private fun checkItem() {
        binding.apply {
            if (goodsDB.dao().getAllData().isNotEmpty()) {
                goodsRv.visibility = View.VISIBLE
                tvEmptyText.visibility = View.GONE
                goodsAdapter.differ.submitList(goodsDB.dao().getAllData())
            } else {
                goodsRv.visibility = View.GONE
                tvEmptyText.visibility = View.VISIBLE
            }
        }
    }
}