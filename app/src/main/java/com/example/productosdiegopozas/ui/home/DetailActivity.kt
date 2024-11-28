// DetailActivity.kt
package com.example.productosdiegopozas.ui.home

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.productosdiegopozas.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item = intent.getSerializableExtra("item") as? ListElement

        if (item != null) {
            val iconImage = findViewById<ImageView>(R.id.ImageView)
            val nameTextView = findViewById<TextView>(R.id.nameTextView)
            val descTextView = findViewById<TextView>(R.id.descTextView)
            val statusTextView = findViewById<TextView>(R.id.statusTextView)
            val detailsTextView = findViewById<TextView>(R.id.detailsTextView)

            iconImage.setColorFilter(Color.parseColor(item.color), PorterDuff.Mode.SRC_IN)
            nameTextView.text = item.name
            descTextView.text = item.desc
            statusTextView.text = item.status
            detailsTextView.text = item.details
        } else {
            finish()
        }
    }
}
