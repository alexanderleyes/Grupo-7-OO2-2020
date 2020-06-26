package com.unla.Grupo7OO22020.helpers;


public class ViewRouteHelper {


	/*LOGIN*/
	public final static String login = "/user/login";

	public final static String login_ok = "/home/index"; 

	public final static String login_fail = "redirect:/loginfail";


	/*LOCALES*/
	public final static String sucursal_idx = "sucursal/sucursal_idx";

	public final static String sucursal_insert = "sucursal/sucursal_mod";

	public final static String sucursal_reload = "redirect:/" + sucursal_idx;

	public final static String cercana_view = "fragments/sucursalCercanas";
	
	public final static String cercana_sin = "fragments/sinCercanas";

	/*GERENTE*/
	public final static String gerente_idx = "gerente/gerente_idx";

	public final static String gerente_insert = "gerente/gerente_mod";

	public final static String gerente_reload = "redirect:/"+ gerente_idx;


	/*VENDEDOR*/
	public final static String vendedor_idx = "vendedor/vendedor_idx";
	
	public final static String vendedor_sueldos = "vendedor/vendedor_sueldos";

	public final static String vendedor_insert = "vendedor/vendedor_mod";

	public final static String vendedor_reload = "redirect:/" + vendedor_idx;

	/*EMPLEADOS*/
	public final static String empleado_idx = "empleado/empleado_idx";

	public final static String empleado_insert = "empleado/empleado_mod";

	public final static String empleado_reload = "redirect:/" + empleado_idx;

	/*PERSONAS*/
	public final static String persona_idx = "persona/persona_idx";

	public final static String personas_insert = "persona/persona_mod";

	public final static String personas_reload = "redirect:/"+ persona_idx;

	/*CLIENTES*/
	public final static String cliente_idx = "cliente/cliente_idx";

	public final static String cliente_insert = "cliente/cliente_mod";

	public final static String clientes_reload = "redirect:/"+ cliente_idx;

	/*LOTE*/
	public final static String LOTE_INDEX = "lote/index";
	public final static String LOTE_NEW = "lote/new";
	public final static String LOTE_UPDATE = "lote/update";
	public final static String LOTE_ROOT = "/lote";
	public final static String lote_idx = "lote/lote_idx";
	public final static String lote_insert = "lote/lote_mod";
	public final static String lote_reload = "redirect:/"+ lote_idx;


	/*PRODUCTO*/

	public final static String producto_idx = "producto/producto_idx";

	public final static String producto_insert = "producto/producto_mod";
	
	public final static String producto_ranking = "producto/ranking";
	
	public final static String producto_prodxfecha = "producto/prodXfecha";

	public final static String producto_reload = "redirect:/"+ producto_idx;
	
	public final static String producto_stock = "fragments/popOverStock";
	
	/*VENTAS*/

	public final static String venta_idx = "venta/venta_idx";

	public final static String venta_insert = "venta/venta_mod";

	public final static String venta_reload = "redirect:/"+ venta_idx;
	
	public final static String venta_items = "venta/venta_items";
	
	public final static String venta_detalles = "venta/venta_det";

	
	
	/*ESTADO DE VENTA*/

	public final static String estadoVenta_idx 		= "estadoVenta/estadoVenta_idx";

	public final static String estadoVenta_insert 	= "estadoVenta/estadoVenta_mod";

	public final static String estadoVenta_reload 	= "redirect:/"+ estadoVenta_idx;	
	
	
	/*PEDIDOS*/

	public final static String pedido_idx 		= "pedido/pedido_idx";

	public final static String pedido_insert 	= "pedido/pedido_mod";

	public final static String pedido_reload 	= "redirect:/"+ pedido_idx;	
	
	
	/*USER*/
	public final static String logout 		= "user/logout";
	
	public final static String home 		= "redirect:/home";
	
	public final static String errovalida 	= "fragments/errovalida";
	

	/*ITEMS*/

	public final static String item_idx 	= "item/item_idx";

	public final static String item_insert 	= "item/item_mod";

	public final static String item_reload 	= "redirect:/"+ item_idx;	
	
	
	/*PARAMETRO*/

	public final static String parametro_idx = "parametro/parametro_idx";

	public final static String parametro_reload = "redirect:/"+ parametro_idx;	
	
	public final static String parametro_insert = "parametro/parametro_mod";
	
	
	
	/*REPORTES*/
	public final static String productoxfecha = "fragments/productoxfecha";
	
	public final static String sin_registros = "fragments/sinRegistros";
	
	public final static String comisionesxfecha = "fragments/comisiones";
	
	/*HISTORICO COMISIONES*/
	public final static String historicoCom_idx = "historicoComisiones/historicoComisiones_idx";
	
	public final static String historico_cie = "historicoComisiones/cierre";
	
	public final static String historico_cieno = "historicoComisiones/cierreno";
	
	public final static String historico_ciesi = "historicoComisiones/cierresi";
	
	
}
