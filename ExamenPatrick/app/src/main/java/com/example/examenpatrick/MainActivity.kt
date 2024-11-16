package com.example.examenpatrick

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var txtNombre : TextView
    private lateinit var btnEntrar : Button
    private lateinit var btnSalir : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        iniciarComponente()
        eventosClic()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    public fun iniciarComponente(){
        txtNombre = findViewById(R.id.txtNombre) as EditText
        btnEntrar = findViewById(R.id.btnEntrar) as Button
        btnSalir = findViewById(R.id.btnSalir) as Button
    }

    public fun eventosClic(){
    btnEntrar.setOnClickListener(View.OnClickListener {
    if (txtNombre.text.toString().contentEquals(charSequence = "")){
        Toast.makeText(this, "Falto capturar tu nombre", Toast.LENGTH_SHORT).show()
    }else{
        val intent = Intent(this, RectanguloActivity::class.java)
        intent.putExtra("Nombre", txtNombre.text.toString())
        startActivity(intent)
    } })
        btnSalir.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}