package com.ubayadev.nmpseleraku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubayadev.nmpseleraku.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerMahasiswa.layoutManager = LinearLayoutManager(this)
        binding.recyclerMahasiswa.setHasFixedSize(true)
        binding.recyclerMahasiswa.adapter = MahasiswaAdapter()
    }
}
