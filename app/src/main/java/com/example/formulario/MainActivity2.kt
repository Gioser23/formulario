package com.example.formulario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formulario.MainActivity.Companion.shar
import com.example.formulario.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextText.setText(shar.getUsuario())
        binding.editTextText2.setText(shar.getClave())
        binding.editTextText3.setText(shar.getCorreo())
        binding.editTextText4.setText(shar.getNumero())


        binding.eliminar.setOnClickListener {
            shar.setUsuario("")
            shar.setClave("")
            shar.setCorreo("")
            shar.setNumero("")
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}