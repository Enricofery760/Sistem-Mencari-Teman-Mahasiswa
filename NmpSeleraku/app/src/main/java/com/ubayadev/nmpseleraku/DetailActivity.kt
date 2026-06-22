package com.ubayadev.nmpseleraku

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ubayadev.nmpseleraku.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    companion object {
        val MAHASISWA = "mahasiswa"
        var jumlahTeman: Int = 0
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val index = intent.getIntExtra(MAHASISWA, 0)

        binding.imgMahasiswa.setImageResource(MahasiswaData.mahasiswa[index].idFoto)
        binding.txtNama.text = MahasiswaData.mahasiswa[index].nama
        binding.txtNrp.text = getString(R.string.nrp, MahasiswaData.mahasiswa[index].nrp)

        if (MahasiswaData.mahasiswa[index].program == "DSAI") {
            binding.radioDsai.isChecked = true
        } else if (MahasiswaData.mahasiswa[index].program == "NCS") {
            binding.radioNcs.isChecked = true
        } else if (MahasiswaData.mahasiswa[index].program == "IMES") {
            binding.radioImes.isChecked = true
        } else if (MahasiswaData.mahasiswa[index].program == "DMT") {
            binding.radioDmt.isChecked = true
        } else if (MahasiswaData.mahasiswa[index].program == "GD") {
            binding.radioGd.isChecked = true
        }else if (MahasiswaData.mahasiswa[index].program == "SIB") {
            binding.radioSib.isChecked = true
        }

        // handle spinner
        val items = arrayOf(
            getString(R.string.about_me),
            getString(R.string.my_course),
            getString(R.string.my_experiences)
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerInformasi.adapter = adapter

        binding.spinnerInformasi.setSelection(0)
        binding.txtAbout.text = MahasiswaData.mahasiswa[index].about

        binding.spinnerInformasi.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0) {
                    binding.txtAbout.text = MahasiswaData.mahasiswa[index].about
                } else if (position == 1) {
                    binding.txtAbout.text = MahasiswaData.mahasiswa[index].course
                } else if (position == 2) {
                    binding.txtAbout.text = MahasiswaData.mahasiswa[index].experiences
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        binding.btnFriend.setOnClickListener {
            com.ubayadev.nmpseleraku.DetailActivity.Companion.jumlahTeman++
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Friend Request")
            builder.setMessage("Sukses tambah " + MahasiswaData.mahasiswa[index].nama + " sebagai friend.\n" +
                    "Friend anda sekarang adalah " + com.ubayadev.nmpseleraku.DetailActivity.Companion.jumlahTeman
            )
            builder.setPositiveButton("OK"){ dialog, _ ->
                dialog.dismiss()
                finish()
            }
            builder.show()
        }

    }
}
