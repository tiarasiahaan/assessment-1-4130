package org.d3if4130.hitungnilaiakhir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.d3if4130.hitungnilaiakhir.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            hitungNilai()
        }

        binding.resetButton.setOnClickListener {
            reset() }
        }

    private fun reset(){
        binding.namaEditText.text?.clear()
        binding.hadirEditText.text?.clear()
        binding.tugasEditText.text?.clear()
        binding.utsEditText.text?.clear()
        binding.uasEditText.text?.clear()
        binding.namaTextView2.text = ""
        binding.akhirTextView.text = ""
        binding.hurufTextView.text = ""
    }

    private fun hitungNilai(){
        val nama = binding.namaEditText.text.toString()
        val hadir = binding.hadirEditText.text.toString().toFloat()
        val tugas = binding.tugasEditText.text.toString().toFloat()
        val uts = binding.utsEditText.text.toString().toFloat()
        val uas = binding.uasEditText.text.toString().toFloat()
        val hasil = (0.20 * hadir) + (0.25 * tugas) + (0.25 * uts) + (0.30 * uas)
        val huruf = getHuruf(hasil)

        binding.namaTextView2.text = getString(R.string.nama_siswa, nama)
        binding.akhirTextView.text = getString(R.string.akhir_n, hasil)
        binding.hurufTextView.text = getString(R.string.huruf_n, huruf)
    }
    private fun getHuruf(hasil: Double): String{
        val stringRes =
           when {
               hasil >= 85 -> R.string.nilai_a
               hasil >= 70 && hasil <= 85 -> R.string.nilai_b
               else -> R.string.nilai_c
           }
        return getString(stringRes)
    }
}