package com.unla.Grupo7OO22020.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*****para insertar manualmente un usuario generar un password encriptado, sino no lo toma */
public class genPassword {
	 public static void main(String[] args) {
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
	        System.out.println("USAR PASSWORD: " + bCryptPasswordEncoder.encode("123"));   
	       
	 }
}