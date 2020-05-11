package com.unla.Grupo7OO22020.helpers;

public class ViewRouteHelper {
	
	/*LOGIN*/
	public final static String login = "/user/login";
	
	public final static String login_ok = "/home/index";
	
	public final static String login_fail = "redirect:/loginfail";
	
	
	/*LOCALES*/
	public final static String locales = "/home/locales";
	
	
	/*GERENTE*/
	public final static String gerente_idx = "empleado/gerente_idx";
	
	public final static String gerente_insert = "empleado/gerente_mod";
	
	public final static String gerente_reload = "redirect:/gerente_idx";
	
	
	/*VENDEDOR*/
	public final static String vendedor_idx = "empleado/vendedor_idx";
	
	public final static String vendedor_insert = "empleado/vendedor_mod";
	
	public final static String vendedor_reload = "redirect:/vendedor_idx";
	
	/*EMPLEADOS*/
	public final static String empleado_idx = "empleado/empleado_idx";
	
	public final static String empleado_insert = "empleado/empleado_mod";
	
	public final static String empleado_reload = "redirect:/empleado_idx";
	
	/*PERSONAS*/
	public final static String persona_idx = "persona/persona_idx";
	
	public final static String personas_insert = "persona/persona_mod";
	
	public final static String personas_reload = "redirect:/persona_idx";
	
	/*CLIENTES*/
	public final static String cliente_idx = "cliente/cliente_idx";
	
	public final static String cliente_insert = "cliente/cliente_mod";
	
	public final static String clientes_reload = "redirect:/cliente_idx";
}
