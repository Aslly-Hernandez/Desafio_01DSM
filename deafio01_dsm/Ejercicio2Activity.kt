package edu.udb.deafio01_dsm

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
class Ejercicio2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etSalario = findViewById<EditText>(R.id.etSalario)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val salarioStr = etSalario.text.toString().trim()

            if (nombre.isEmpty() || salarioStr.isEmpty()) {
                tvResultado.text = "⚠️ Debe llenar todos los campos."
                return@setOnClickListener
            }

            val salario = salarioStr.toDoubleOrNull()
            if (salario == null || salario <= 0) {
                tvResultado.text = "⚠️ Ingrese un salario válido."
                return@setOnClickListener
            }

            val afp = salario * 0.0725
            val isss = salario * 0.03
            val renta = calcularRenta(salario)

            val totalDescuento = afp + isss + renta
            val salarioNeto = salario - totalDescuento

            val resultado = if (salario == 472.00) {
                """
        Empleado: $nombre
        Salario Base: $472.00
        AFP (7.25%): $${"%.2f".format(afp)}
        ISSS (3%): $${"%.2f".format(isss)}
        Renta: $0.00
        -----------------------------
        Total Descuento: $${"%.2f".format(afp + isss)}
        Salario Neto: $${"%.2f".format(salario - afp - isss)}
        """.trimIndent()
            } else {
                """
        Empleado: $nombre
        Salario Base: $${"%.2f".format(salario)}
        AFP (7.25%): $${"%.2f".format(afp)}
        ISSS (3%): $${"%.2f".format(isss)}
        Renta: $${"%.2f".format(renta)}
        -----------------------------
        Total Descuento: $${"%.2f".format(totalDescuento)}
        Salario Neto: $${"%.2f".format(salarioNeto)}
        """.trimIndent()
            }

            tvResultado.text = resultado
        }
    }

    private fun calcularRenta(salario: Double): Double {
        return when {
            salario <= 472.01 -> 0.0
            salario > 472.01 && salario <= 895.24 -> ((salario - 472.01) * 0.10) + 17.67
            salario > 895.24 && salario <= 2038.10 -> ((salario - 895.24) * 0.20) + 60.00
            else -> ((salario - 2038.10) * 0.30) + 288.57
        }
    }

}

