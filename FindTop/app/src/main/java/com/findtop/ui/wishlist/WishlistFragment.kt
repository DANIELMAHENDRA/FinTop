package com.findtop.ui.wishlist

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.findtop.DetailWhishActivity
import com.findtop.R

class WishlistFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wishlist2, container, false)

        val card1 = view.findViewById<View>(R.id.cardVIew1)
        val card2 = view.findViewById<View>(R.id.cardVIew2)
        val card3 = view.findViewById<View>(R.id.cardVIew3)
        val card4 = view.findViewById<View>(R.id.cardVIew4)
        val card5 = view.findViewById<View>(R.id.cardVIew5)
        val card6 = view.findViewById<View>(R.id.cardVIew6)

        val spesifikasi1 = """
            • Intel® Core™ Ultra 5 Processor 225H 1.7 GHz (up to 4.9 GHz, 16 Threads)
            • Intel® AI Boost NPU up to 13TOPS
            • Windows 11 Home
            • 14.0-inch, WUXGA (1920 x 1200), IPS-level Panel
            • 300nits, 45% NTSC color gamut, Anti-glare display
            • 16GB DDR5 on board
            • 1TB M.2 NVMe™ PCIe® 4.0 SSD
            • Backlit Chiclet Keyboard, 1.7mm Key-travel
            • FHD camera with IR, Windows Hello
        """.trimIndent()

        val spesifikasi2 = """
            • Intel® Core™ i7-1260P
            • OLED 2.8K Display
            • 16GB LPDDR5 RAM
            • 1TB NVMe SSD
            • ASUS Antibacterial Guard
            • Dolby Atmos Audio
            • WiFi 6E & Thunderbolt 4
        """.trimIndent()

        card1.setOnClickListener {
            val intent = Intent(requireContext(), DetailWhishActivity::class.java)
            intent.putExtra("nama", "ASUS Vivobook S14 (S3407C)")
            intent.putExtra("harga", "Rp13.499.000")
            intent.putExtra("gambar", R.drawable.laptop1)
            intent.putExtra("spesifikasi", spesifikasi1)
            startActivity(intent)
        }

        val cards = listOf(card2, card3, card4, card5, card6)
        for (card in cards) {
            card.setOnClickListener {
                val intent = Intent(requireContext(), DetailWhishActivity::class.java)
                intent.putExtra("nama", "Zenbook 14 OLED")
                intent.putExtra("harga", "Rp14.499.000")
                intent.putExtra("gambar", R.drawable.laptop2)
                intent.putExtra("spesifikasi", spesifikasi2)
                startActivity(intent)
            }
        }

        return view
    }
}
