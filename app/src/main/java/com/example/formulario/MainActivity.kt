package com.example.formulario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.formulario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        lateinit var shar:Shared
    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        shar=Shared(this)

        binding.editTextText.setOnFocusChangeListener { view, b ->
            if (binding.editTextText.text.isEmpty())
            {
                binding.editTextText.error="Campo Requerido"
            }
            else
            {
                binding.editTextText.error=null
            }
        }
        binding.editTextText2.setOnFocusChangeListener { view, b ->
            if (binding.editTextText2.text.isEmpty())
            {
                binding.editTextText2.error="Campo Requerido"
            }
            else
            {
                binding.editTextText2.error=null
            }
        }
        binding.editTextText3.addTextChangedListener {
            var regexCor:Boolean = Regex("^[a-zA-Z0-9]{4,15}[-._][a-zA-Z0-9]{4,15}@[a-zA-Z]{3,15}[.][a-zA]{2,5}").matches(binding.editTextText3.text.toString())
            if (binding.editTextText3.text.isEmpty())
            {
                binding.editTextText3.error="Campo Requerido"
            }
            else if(regexCor)
            {
                binding.editTextText3.error=null
            }
            else
            {
                binding.editTextText3.error="No cumple los parametro especificados"
            }
        }
        binding.editTextText4.addTextChangedListener {
            var regexNum:Boolean = Regex("^[0-9]+$").matches(binding.editTextText4.text.toString())
            if (binding.editTextText4.text.isEmpty())
            {
                binding.editTextText4.error="Campo Requerido"
            }
            else if(regexNum)
            {
                binding.editTextText4.error=null
            }
            else
            {
                binding.editTextText4.error="Solo se admiten digitos"
            }
        }

        binding.guardar.setOnClickListener {
            var regexCor:Boolean = Regex("^[a-zA-Z0-9]{4,}[-._][a-zA-Z0-9]{4,}@[a-zA-Z]{3,}[.][a-z]{2,}").matches(binding.editTextText3.text.toString())
            var regexNum:Boolean = Regex("^[0-9]+$").matches(binding.editTextText4.text.toString())
            if (regexNum && !binding.editTextText.text.isEmpty() && !binding.editTextText2.text.isEmpty() && regexCor)
            {
                shar.setUsuario(binding.editTextText.text.toString())
                shar.setClave(binding.editTextText2.text.toString())
                shar.setCorreo(binding.editTextText3.text.toString())
                shar.setNumero(binding.editTextText4.text.toString())
            }

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

            finish()
        }


    }
}