package edu.udb.deafio01_dsm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btnEjercicio1)
        val btn2 = findViewById<Button>(R.id.btnEjercicio2)
        val btn3 = findViewById<Button>(R.id.btnEjercicio3)

        btn1.setOnClickListener {
            startActivity(Intent(this, Ejercicio1Activity::class.java))
        }

        btn2.setOnClickListener {
            startActivity(Intent(this, Ejercicio2Activity::class.java))
        }

        btn3.setOnClickListener {
            startActivity(Intent(this, Ejercicio3Activity::class.java))
        }
    }
}
