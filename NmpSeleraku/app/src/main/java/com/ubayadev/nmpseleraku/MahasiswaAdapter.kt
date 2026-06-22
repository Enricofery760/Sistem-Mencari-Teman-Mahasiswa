package com.ubayadev.nmpseleraku

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubayadev.nmpseleraku.databinding.MahasiswaCardBinding

class MahasiswaAdapter :
    RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {
    class MahasiswaViewHolder(val binding: MahasiswaCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(
        holder: MahasiswaViewHolder,
        position: Int
    ) {
        holder.binding.txtNama.text = MahasiswaData.mahasiswa[position].nama
        holder.binding.txtNrp.text = "NRP "+ MahasiswaData.mahasiswa[position].nrp
        holder.binding.txtProgram.text = "Program " + MahasiswaData.mahasiswa[position].program
        holder.binding.imgMahasiswa.setImageResource(MahasiswaData.mahasiswa[position].idFoto)

        holder.binding.cardMahasiswa.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.MAHASISWA, position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MahasiswaViewHolder {
        val binding = MahasiswaCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MahasiswaViewHolder(binding)
    }

    override fun getItemCount(): Int = MahasiswaData.mahasiswa.size
}