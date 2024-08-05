import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.example.taparking.R

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

        val database = FirebaseDatabase.getInstance()
        val parkingSlotsRef = database.getReference("parking_slots")

        parkingSlotsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (slotSnapshot in snapshot.children) {
                    val slotId = slotSnapshot.key
                    val status = slotSnapshot.child("status").getValue(String::class.java)

                    val imageView = when (slotId) {
                        "lp_1" -> lp1
                        "lp_2" -> lp2
                        "lp_3" -> lp3
                        "lp_4" -> lp4
                        "lp_5" -> lp5
                        "lp_6" -> lp6
                        "lp_7" -> lp7
                        "lp_8" -> lp8
                        "lp_9" -> lp9
                        "lp_10" -> lp10
                        else -> null
                    }

                    // Update ImageView based on slot status

                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle possible errors.
            }
        })
    }
}
