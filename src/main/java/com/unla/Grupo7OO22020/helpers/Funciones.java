package com.unla.Grupo7OO22020.helpers;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Funciones {
	
	public static boolean esBisiesto (int anio) {
		
		if ((anio % 4) == 0 ) {
			if ((anio % 100) == 0 && (anio % 400 != 0)){
				return false;
			}
				else {
					return true;
				}
			}
		else
			
		return false;
	}
	
	public static int traerAnio (LocalDate f) {
		return f.getYear(); 
	}
	
	public static int traerMes(LocalDate f) {
		return f.getMonthValue();
	}
	
	public static int traerDia(LocalDate f) {
		return f.getDayOfMonth();
	}
	
	public static boolean esFechaValida (int anio, int mes, int dia) {
		
		int diaMayor = Funciones.traerCantDiasDeUnMes(anio, mes);
		return diaMayor>=dia && dia> 0;
		
	}	
	
		
		
	public static LocalDate traerFecha (int anio, int mes, int dia) {		
		LocalDate date = LocalDate.of(dia, mes, dia);		
		return date;	
	}
	
	public static String traerFechaCorta(LocalDate date){		
		return date.getDayOfMonth() +"/"+ date.getMonthValue()+"/"+date.getYear();
	}
	
	
	public static String traerFechaCortaHora(LocalDateTime  f){
		String dia 		= String.valueOf(f.getDayOfMonth());
		String mes 		= String.valueOf(f.getMonthValue());
		String anio 	= String.valueOf(f.getYear());
		String hora 	= String.valueOf(f.getHour());
		String minutos 	= String.valueOf(f.getMinute());
		String seg 		= String.valueOf(f.getSecond());
		
		return dia+"/ "+mes+"/ "+anio + "--"+hora+":"+minutos+":"+seg;
	}
	
	public static LocalDate traerFechaProximo(LocalDate fecha, int cantDias, boolean habil){		
		LocalDate fecha1 = LocalDate.of(fecha.getYear(), fecha.getMonth(), fecha.getDayOfMonth());
		fecha1 = fecha1.plusDays(cantDias);
		while (!Funciones.esDiaHabil(fecha1) && habil){
			fecha1 =  fecha1.plusDays(1);
		}
		return fecha1;		
	}	
	
	public static boolean esDiaHabil(LocalDate fecha){
	
		if(fecha.getDayOfWeek().equals(DayOfWeek.SATURDAY)||fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
			return false;
		}else{
			return true;
		}
	}








	public static String traerDiaDelaSemana(LocalDate fecha) {
		String dia = null;
	
		switch(fecha.getDayOfWeek().toString()){		
		case "SUNDAY":
			dia = "Domingo";
			break;
		case "MONDAY":
			dia = "Lunes";
			break;
		case "TUESDAY":
			dia = "Martes";
			break;
		case "WEDNESDAY":
			dia = "Miercoles";
			break;
		case "THURSDAY":
			dia = "Jueves";
			break;
		case "FRIDAY":
			dia = "Viernes";
			break;
		case "SATURDAY":
			dia = "Sabado";
		}
		return dia;
	}
	
	public static String traerMesEnLetras(LocalDate fecha){
		String mes= null;
		
		switch(fecha.getMonthValue()){
		case 1:
			mes = "Enero";
			break;
		case 2:
			mes = "Febrero";
			break;
		case 3:
			mes = "Marzo";
			break;
		case 4:
			mes = "Abril";
			break;
		case 5:
			mes = "Mayo";
			break;
		case 6:
			mes = "Junio";
			break;
		case 7:
			mes = "Julio";
			break;
		case 8:
			mes = "Agosto";
			break;
		case 9:
			mes = "Septiembre";
			break;
		case 10:
			mes = "Octubre";
			break;
		case 11:
			mes = "Noviembre";
			break;
		case 12:
			mes = "Diciembre";
			break;
		}
		return mes;
	}
	
	public static String traerFechaLarga(LocalDate fecha){
		return Funciones.traerDiaDelaSemana(fecha) +", "+fecha.getDayOfMonth()+" de "+Funciones.traerMesEnLetras(fecha)+" de "+ Funciones.traerAnio(fecha);
	}
	
	public static boolean sonFechasIguales(LocalDate fecha1, LocalDate fecha2){		
		return fecha1.equals(fecha2);
	}
	
	
	public static boolean sonFechasHorasIguales(LocalDateTime fecha1, LocalDateTime fecha2){		
		return fecha1.equals(fecha2);
	}
	
	
	public static int traerCantDiasDeUnMes (int anio, int mes){
		
		mes += 1;
		int dias = 0;
		
		switch(mes-1){
		case 0:
			dias = 31;
			break;
		case 1:
			dias = 28;
			if(Funciones.esBisiesto(anio)){
				dias = 29;
			}
			break;
		case 2:
			dias = 31;
			break;
		case 3:
			dias = 30;
			break;
		case 4:
			dias = 31;
			break;
		case 5:
			dias = 30;
			break;
		case 6:
			dias = 31;
			break;
		case 7:
			dias = 31;
			break;
		case 8:
			dias = 30;
			break;
		case 9:
			dias = 31;
			break;
		case 10:
			dias = 30;
			break;
		case 11:
			dias = 31;
			break;
		}
		return dias;
	}
	
	
	public static double aproximar2Decimal(double numero){
		
		
		String numString = String.valueOf(numero);
		numString = numString.substring(numString.indexOf("."));
		
		if( 3 < numString.length()){
			if(numString.charAt(3) >= 5 ){
				numero = numero +0.01;	
			}			
		}	
		numero =(int)(numero*100);
		return numero/100;
		
	}
	
	
	public static boolean esNumero(char c){
		boolean respuesta= false;
		for(int i =0; i<10;i++){
			if (c == String.valueOf(i).charAt(0)){	
				respuesta = true;
			}
		}
		return respuesta;
	}
	
	public static boolean esCaracter(char c){
		String abecedario = "qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM";
		boolean validar = false;
		for (int i=0; i< abecedario.length(); i++){
			if (c == abecedario.charAt(i)){
				validar = true;
			}
		}
		return validar;
	}
	
	public static boolean esCadenaDeNumeros(String cadena){
		boolean respuesta = true;
		
		for(int i=0; i<cadena.length(); i++){
			if(Funciones.esNumero(cadena.charAt(i))!=true){
				respuesta = false;
			}
		}
		return respuesta;
	}
		 
	public static boolean esCadenaDeCaracteres(String cadena){
		boolean val = true;
		for(int i=0; i< cadena.length(); i++){
			if(!(Funciones.esCaracter(cadena.charAt(i)))){
				val = false;
			}
		}
		return val;
	}		
}