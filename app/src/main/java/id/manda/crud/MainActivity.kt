package id.manda.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var ref : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ref = FirebaseDatabase.getInstance().getReference("USERS")
        btnSave.setOnClickListener {
            savedata()
        }
    }
    private fun savedata() {
        val nama = inputNama.text.toString()
        val status = inputStatus.text.toString()
        val user = Users(nama,status)
        val userId = ref.push().key.toString()
        ref.child(userId).setValue(user).addOnCompleteListener {
            Toast.makeText(this, "Successs",Toast.LENGTH_SHORT).show()
            inputNama.setText("")
            inputStatus.setText("")
            
        }
    }
}

