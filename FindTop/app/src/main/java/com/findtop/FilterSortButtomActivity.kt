package com.findtop

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterSortBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_filter_sort_buttom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val closeButton: ImageView = view.findViewById(R.id.closeButton)
        val buttonSimpanFilter: Button = view.findViewById(R.id.buttonSimpanFilter)
        val editTextMinHarga: EditText = view.findViewById(R.id.editTextMinHarga)
        val editTextMaxHarga: EditText = view.findViewById(R.id.editTextMaxHarga)

        // Tutup bottom sheet
        closeButton.setOnClickListener { dismiss() }

        // Simpan filter manual
        buttonSimpanFilter.setOnClickListener {
            val minHarga = editTextMinHarga.text.toString()
            val maxHarga = editTextMaxHarga.text.toString()

            if (minHarga.isNotBlank() || maxHarga.isNotBlank()) {
                Toast.makeText(context, "Filter: $minHarga - $maxHarga", Toast.LENGTH_SHORT).show()
                // Bisa dikembangkan untuk diteruskan via intent
            } else {
                Toast.makeText(context, "Tidak ada filter yang diterapkan.", Toast.LENGTH_SHORT).show()
            }
            dismiss()
        }

        // Rentang harga yang bisa diklik
        val priceRange4 = view.findViewById<TextView>(R.id.priceRange4) // Rp 7jt - 10jt

        priceRange4.setOnClickListener {
            Toast.makeText(context, "Menampilkan laptop 7jt - 10jt", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), FilterLaptopActivity::class.java)
            startActivity(intent)
            dismiss()
        }

        // Optional: listener rentang harga lainnya (bisa dikembangkan sendiri)
    }
}
