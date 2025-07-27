package edu.udb.deafio01_dsm

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.sqrt

class Ejercicio3Activity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_ejercicio3)

            val etNumero1 = findViewById<EditText>(R.id.etNumero1)
            val etNumero2 = findViewById<EditText>(R.id.etNumero2)
            val tvResultado = findViewById<TextView>(R.id.tvResultado)

            val btnSuma = findViewById<Button>(R.id.btnSuma)
            val btnResta = findViewById<Button>(R.id.btnResta)
            val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
            val btnDividir = findViewById<Button>(R.id.btnDividir)
            val btnExponente = findViewById<Button>(R.id.btnExponente)
            val btnRaiz = findViewById<Button>(R.id.btnRaiz)

            fun obtenerNumeros(): Pair<Double?, Double?> {
                val num1 = etNumero1.text.toString().toDoubleOrNull()
                val num2 = etNumero2.text.toString().toDoubleOrNull()
                return Pair(num1, num2)
            }

            btnSuma.setOnClickListener {
                val (n1, n2) = obtenerNumeros()
                if (n1 != null && n2 != null)
                    tvResultado.text = "Resultado: ${n1 + n2}"
                else
                    tvResultado.text = "⚠️ Ingrese ambos números"
            }

            btnResta.setOnClickListener {
                val (n1, n2) = obtenerNumeros()
                if (n1 != null && n2 != null)
                    tvResultado.text = "Resultado: ${n1 - n2}"
                else
                    tvResultado.text = "⚠️ Ingrese ambos números"
            }

            btnMultiplicar.setOnClickListener {
                val (n1, n2) = obtenerNumeros()
                if (n1 != null && n2 != null)
                    tvResultado.text = "Resultado: ${n1 * n2}"
                else
                    tvResultado.text = "⚠️ Ingrese ambos números"
            }

            btnDividir.setOnClickListener {
                val (n1, n2) = obtenerNumeros()
                if (n1 != null && n2 != null) {
                    if (n2 == 0.0)
                        tvResultado.text = "⚠️ División entre cero no permitida"
                    else
                        tvResultado.text = "Resultado: ${n1 / n2}"
                } else {
                    tvResultado.text = "⚠️ Ingrese ambos números"
                }
            }

            btnExponente.setOnClickListener {
                val (n1, n2) = obtenerNumeros()
                if (n1 != null && n2 != null)
                    tvResultado.text = "Resultado: ${n1.pow(n2)}"
                else
                    tvResultado.text = "⚠️ Ingrese ambos números"
            }

            btnRaiz.setOnClickListener {
                val num1 = etNumero1.text.toString().toDoubleOrNull()
                if (num1 != null && num1 >= 0)
                    tvResultado.text = "Raíz cuadrada: ${sqrt(num1)}"
                else
                    tvResultado.text = "⚠️ Ingrese un número válido en el primer campo"
            }
        }
    }
