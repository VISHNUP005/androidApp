package com.example.vwork.activities
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vwork.R


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnNote = findViewById<Button>(R.id.btnNote)
        val btnChat = findViewById<Button>(R.id.btnChat)

        btnNote.setOnClickListener {
            startActivity(Intent(this, HomeNoteActivity::class.java))
        }

        btnChat.setOnClickListener {
            startActivity(Intent(this, HomeChatActivity::class.java))
        }
    }
}
