package com.example.taparking
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.example.taparking.R
import com.google.firebase.database.*


class LayoutParkiranActivity : AppCompatActivity() {
    private lateinit var lp1: ImageView
    private lateinit var lp2: ImageView
    private lateinit var lp3: ImageView
    private lateinit var lp4: ImageView
    private lateinit var lp5: ImageView
    private lateinit var lp6: ImageView
    private lateinit var lp7: ImageView
    private lateinit var lp8: ImageView
    private lateinit var lp9: ImageView
    private lateinit var lp10: ImageView
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_parkiran)

        lp1 = findViewById(R.id.lp_1)
        lp2 = findViewById(R.id.lp_2)
        lp3 = findViewById(R.id.lp_3)
        lp4 = findViewById(R.id.lp_4)
        lp5 = findViewById(R.id.lp_5)
        lp6 = findViewById(R.id.lp_6)
        lp7 = findViewById(R.id.lp_7)
        lp8 = findViewById(R.id.lp_8)
        lp9 = findViewById(R.id.lp_9)
        lp10 = findViewById(R.id.lp_10)

        database = FirebaseDatabase.getInstance().reference

        database.child("sensor").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // Mengambil data dari Firebase
                val slotData1 = snapshot.child("sensor1").getValue(Int::class.java) ?: 0
                val slotData2 = snapshot.child("sensor2").getValue(Int::class.java) ?: 0
                val slotData3 = snapshot.child("sensor3").getValue(Int::class.java) ?: 0
                val slotData4 = snapshot.child("sensor4").getValue(Int::class.java) ?: 0
                val slotData5 = snapshot.child("sensor5").getValue(Int::class.java) ?: 0
                val slotData6 = snapshot.child("sensor10").getValue(Int::class.java) ?: 0
                val slotData7 = snapshot.child("sensor9").getValue(Int::class.java) ?: 0
                val slotData8 = snapshot.child("sensor8").getValue(Int::class.java) ?: 0
                val slotData9= snapshot.child("sensor7").getValue(Int::class.java) ?: 0
                val slotData10 = snapshot.child("sensor6").getValue(Int::class.java) ?: 0

                // Mengubah warna ImageView berdasarkan data
                updateSlotImage(lp1, slotData1)
                updateSlotImage(lp2, slotData2)
                updateSlotImage(lp3, slotData3)
                updateSlotImage(lp4, slotData4)
                updateSlotImage(lp5, slotData5)
                updateSlotImage(lp6, slotData6)
                updateSlotImage(lp7, slotData7)
                updateSlotImage(lp8, slotData8)
                updateSlotImage(lp9, slotData9)
                updateSlotImage(lp10, slotData10)
            }

            override fun onCancelled(error: DatabaseError) {
                // Menangani kesalahan database
            }
        })
    }

    private fun updateSlotImage(slot: ImageView, status: Int) {
        if (status == 1) {
            // Slot terisi, ganti warna background
            slot.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
        } else {
            // Slot kosong, ganti warna background
            slot.setBackgroundColor(ContextCompat.getColor(this, R.color.hijau))
        }

    }
}
