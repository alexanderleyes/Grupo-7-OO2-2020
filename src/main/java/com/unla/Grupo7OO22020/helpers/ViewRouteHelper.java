package com.unla.Grupo7OO22020.helpers;

public class ViewRouteHelper {
	
	/*LOGIN*/
	public final static String login = "/user/login";
	
	public final static String login_ok = "/home/index";
	
	public final static String login_fail = "redirect:/loginfail";
	
	
	/*LOCALES*/
	public final static String locales = "/home/locales";
	
	
	/*EMPLEADOS*/
	public final static String empleado_idx = "empleado/empleado_idx";
	
	public final static String empleado_insert = "empleado/empleado_mod";
	
	public final static String empleado_reload = "redirect:/empleado_idx";
	
	
	/*CLEINTES*/
	public final static String persona_idx = "persona/persona_idx";
	
	public final static String  personas_insert = "persona/persona_mod";
	
	public final static String  personas_reload = "redirect:/persona_idx";
}
