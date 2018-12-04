/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.Serializable;

/**
 *
 * @author Ricardo
 */
public class Cliente implements Serializable{
    String nombre, usuario,apellido, tipoCuenta, password;
    int numCuenta;
    double saldo;
    
    public Cliente(String nombre, String usuario, String apellido, String tipoCuenta, int numCuenta, String password, double saldo){
        this.nombre=nombre;
        this.apellido=apellido;
        this.numCuenta=numCuenta;
        this.usuario=usuario;
        this.password=password;
        this.saldo=saldo;
        this.tipoCuenta=tipoCuenta;
           
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", usuario=" + usuario + ", apellido=" + apellido + ", tipoCuenta=" + tipoCuenta + ", password=" + password + ", numCuenta=" + numCuenta + ", saldo=" + saldo + '}';
    }
    
}
