package com.simonventas.automation.tests;

import org.apache.log4j.Logger;

import com.simonventas.automation.flow.CommonConsultationFlow;
import com.simonventas.automation.flow.HogarFlow;
import com.simonventas.automation.flow.RegressionFlow;

import io.qameta.allure.Step;

public class VentasStepDef {
	
	public static Logger log=Logger.getLogger(VentasStepDef.class);
	
	@Step
	public Hogar_Test clickLogin(String url) {
		new RegressionFlow().login(url);
		return new Hogar_Test();
	}
	
	@Step
	public VentasStepDef hogarCrearCotizacion(String rownum,String clave,String producto, String numdoc,String ciudad,String direccion,String estrato,String ano_construction,String rural,String edifico,String no_electrico,String electrico) {
		HogarFlow h=new HogarFlow();
		h.gotoHogar(rownum);
		h.enterClave(rownum, clave);
		h.selectProducto(producto);
		h.enterTomador(rownum,numdoc);
		h.enterRiesgoInmueble(ciudad,direccion,estrato,ano_construction,rural);
		h.enterValorAsegurado(rownum,edifico,no_electrico,electrico);
		return this;
	}
	
	@Step
	public Hogar_Test hogarEmisionPoliza(String rownum,String fecha_segurida,String fecha_segurida2,String numeroPisos,String barrio) {
		HogarFlow h=new HogarFlow();
		h.doEmitir(rownum,fecha_segurida,fecha_segurida2,numeroPisos,barrio);
		return new Hogar_Test();
	}
	
	@Step
	public Hogar_Test hogarCommonConsultation(String rownum,String numeroPisos,String barrio) {
		CommonConsultationFlow c=new CommonConsultationFlow();
		c.gotoCommonConsult();
		c.consultaCotizaciones(rownum);
		c.doEmitir(rownum,numeroPisos,barrio);
		return new Hogar_Test();
	}
	
	@Step
	public Hogar_Test hogarCopiarCotizacion(String rownum,String clave,String producto, String numdoc,String ciudad,String direccion,String estrato,String ano_construction,String edifico,String no_electrico,String electrico) {
		HogarFlow h=new HogarFlow();
		h.copiarCotizacion(rownum);
		return new Hogar_Test();
	}
	
	@Step
	public Hogar_Test hogarCotizacionPDF(String rownum) {
		HogarFlow h=new HogarFlow();
		h.cotizacionPDF(rownum);
		return new Hogar_Test();
	}
	@Step
	public Hogar_Test hogarPolicyPDF(String rownum,String numeroPisos,String barrio) {
		HogarFlow h=new HogarFlow();
		h.doEmitirPDF(rownum, numeroPisos, barrio);
		h.policyPDF(rownum);
		return new Hogar_Test();
	}
	
   
    	
    
    
}
