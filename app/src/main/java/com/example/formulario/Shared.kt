package com.example.formulario

import android.content.Context

open class Shared(val context:Context){
    fun setUsuario(Usuario:String){
        context.getSharedPreferences("code",Context.MODE_PRIVATE).edit().putString("Usuario",Usuario).commit()
    }
    fun setClave(Clave:String){
        context.getSharedPreferences("code",Context.MODE_PRIVATE).edit().putString("Clave",Clave).commit()
    }
    fun setNumero(Numero:String){
        context.getSharedPreferences("code",Context.MODE_PRIVATE).edit().putString("Numero",Numero).commit()
    }
    fun setCorreo(Correo:String){
        context.getSharedPreferences("code",Context.MODE_PRIVATE).edit().putString("Correo",Correo).commit()
    }
    fun getUsuario():String?{
        var getU= context.getSharedPreferences("code",Context.MODE_PRIVATE).getString("Usuario","")
        return getU
    }
    fun getClave():String?{
        var getC= context.getSharedPreferences("code",Context.MODE_PRIVATE).getString("Clave","")
        return getC
    }
    fun getNumero():String?{
        var getN= context.getSharedPreferences("code",Context.MODE_PRIVATE).getString("Numero","")
        return getN
    }
    fun getCorreo():String?{
        var getCo= context.getSharedPreferences("code",Context.MODE_PRIVATE).getString("Correo","")
        return getCo
    }
}