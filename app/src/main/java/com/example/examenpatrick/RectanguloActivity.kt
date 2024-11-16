package com.example.examenpatrick

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RectanguloActivity : AppCompatActivity() {
    private lateinit var nombreTextView: TextView
    private lateinit var txtBaseR: EditText
    private lateinit var txtAlturaR: EditText
    private lateinit var txtArea: EditText
    private lateinit var txtPerimetro: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnCerrar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rectangulo)
        iniciarComponentes()
        eventosClic()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    public fun iniciarComponentes(){
        nombreTextView = findViewById(R.id.Nombre)
        txtBaseR = findViewById(R.id.txtBaseR)
        txtAlturaR = findViewById(R.id.txtAlturaR)
        txtArea = findViewById(R.id.txtArea)
        txtPerimetro = findViewById(R.id.txtPerimetro)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)

        val strNombre = intent.getStringExtra("Nombre")?: "Nombre desconocido"
        nombreTextView.text = "Tu nombre es: $strNombre"
    }
    public fun eventosClic(){
        btnCalcular.setOnClickListener {
            if (txtBaseR.text.isBlank() || txtAlturaR.text.isBlank()) {
                Toast.makeText(this, "Falto Capturar algun dato", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val base = txtBaseR.text.toString().toDoubleOrNull()
            val altura = txtAlturaR.text.toString().toDoubleOrNull()
            if (base == null || altura == null) {
                Toast.makeText(this, "Por favor, ingresa valores numéricos válidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val area = base * altura
            val perimetro = 2*(base) + 2*(altura)
            txtArea.setText(area.toString())
            txtPerimetro.setText(perimetro.toString())
        }
        btnLimpiar.setOnClickListener{
            txtPerimetro.setText("")
            txtArea.setText("")
            txtBaseR.setText("")
            txtAlturaR.setText("")
        }
        btnCerrar.setOnClickListener{
            finish()
        }

    }
}