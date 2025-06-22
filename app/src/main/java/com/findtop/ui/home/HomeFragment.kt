package com.findtop.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.findtop.*
import com.findtop.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Tombol ke halaman Merk
        binding.buttonMerk.setOnClickListener {
            val intent = Intent(requireContext(), MerkActivity::class.java)
            startActivity(intent)
        }

        // Tombol ke halaman Pengguna
        binding.buttonPengguna.setOnClickListener {
            val intent = Intent(requireContext(), PenggunaActivity::class.java)
            startActivity(intent)
        }

        // Tombol notifikasi
        binding.notificationIcon.setOnClickListener {
            val intent = Intent(requireContext(), NotificationActivity::class.java)
            startActivity(intent)
        }

        // Klik pada salah satu card laptop
        binding.cardAsusVivobook.setOnClickListener {
            val intent = Intent(requireContext(), DetailLaptopActivity::class.java)
            intent.putExtra("nama", "ASUS Vivobook S14 (S3407C)")
            intent.putExtra("harga", "Rp13.499.000")
            intent.putExtra("gambar", R.drawable.laptop1)
            intent.putExtra(
                "spesifikasi",
                """
                • Intel® Core™ Ultra 5 Processor 225H (up to 4.9 GHz, 16 Threads)
                • Intel® AI Boost NPU up to 13TOPS
                • Windows 11 Home
                • 14.0-inch, WUXGA (1920 x 1200), 16:10, IPS-level Panel
                • 300nits, 45% NTSC, TÜV Rheinland-certified
                • 16GB DDR5 on board
                • 1TB M.2 NVMe™ PCIe® 4.0 SSD
                • Backlit Keyboard, 1.7mm key-travel
                • FHD camera with IR dan Windows Hello
                """.trimIndent()
            )
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
