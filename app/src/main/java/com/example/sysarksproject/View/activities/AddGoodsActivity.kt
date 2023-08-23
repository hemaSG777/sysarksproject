package com.example.sysarksproject.View.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.sysarksproject.Database.GoodsDatabase
import com.example.sysarksproject.Model.Entity
import com.example.sysarksproject.databinding.ActivityAddGoodsBinding

class AddGoodsActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddGoodsBinding.inflate(layoutInflater) }
    private val goodsDB: GoodsDatabase by lazy {
        Room.databaseBuilder(this, GoodsDatabase::class.java, "room_table")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    private lateinit var entity: Entity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            backImage.setOnClickListener {
                onBackPressed()
            }
            binding.submitBtn.setOnClickListener {
                val title = itemNAme.text.toString()
                val desc = desc.text.toString()
                val quantity = quantity.text

                if (title.isNotEmpty() || desc.isNotEmpty() || quantity!!.isNotEmpty()) {
                    entity = Entity(0, title, desc, quantity.toString())
                    goodsDB.dao().insertData(entity)
                    Toast.makeText(this@AddGoodsActivity, "Added Successfully", Toast.LENGTH_SHORT)
                        .show()
                    finish()
                } else {
                    Toast.makeText(this@AddGoodsActivity, "Error", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}