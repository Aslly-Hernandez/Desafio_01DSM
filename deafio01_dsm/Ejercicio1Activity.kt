package edu.udb.deafio01_dsm

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
class Ejercicio1Activity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_ejercicio1)

            val etNombre = findViewById<EditText>(R.id.etNombre)
            val etNota1 = findViewById<EditText>(R.id.etNota1)
            val etNota2 = findViewById<EditText>(R.id.etNota2)
            val etNota3 = findViewById<EditText>(R.id.etNota3)
            val etNota4 = findViewById<EditText>(R.id.etNota4)
            val etNota5 = findViewById<EditText>(R.id.etNota5)
            val btnCalcular = findViewById<Button>(R.id.btnCalcular)
            val tvResultado = findViewById<TextView>(R.id.tvResultado)

            btnCalcular.setOnClickListener {
                val nombre = etNombre.text.toString()
                val notas = listOf(
                    etNota1.text.toString(),
                    etNota2.text.toString(),
                    etNota3.text.toString(),
                    etNota4.text.toString(),
                    etNota5.text.toString()
                )

                if (nombre.isBlank() || notas.any { it.isBlank() }) {
                    Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val notasNumericas = notas.map {
                    try {
                        it.toDouble()
                    } catch (e: Exception) {
                        Toast.makeText(this, "Las notas deben ser números válidos", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }

                if (notasNumericas.any { it < 0 || it > 10 }) {
                    Toast.makeText(this, "Las notas deben estar entre 0 y 10", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val ponderaciones = listOf(0.20, 0.15, 0.15, 0.25, 0.25)
                val promedio = notasNumericas.zip(ponderaciones).sumOf { it.first * it.second }

                val df = DecimalFormat("#.00")
                val promedioFinal = df.format(promedio)
                val estado = if (promedio >= 6.0) "Aprobado" else "Reprobado"

                tvResultado.text = "Estudiante: $nombre\nPromedio: $promedioFinal\nEstado: $estado"
            }
        }
    }

