package com.simonventas.automation.tests;

import org.apache.log4j.Logger;

import com.simonventas.automation.flow.CommonConsultationFlow;
import com.simonventas.automation.flow.HogarFlow;
import com.simonventas.automation.flow.RegressionFlow;
import com.simonventas.automation.flow.SaludFlow;

import io.qameta.allure.Step;

public class VentasStepDefSalud {
	
	public static Logger log=Logger.getLogger(VentasStepDefSalud.class);
	
	@Step
	public Salud_Test clickLogin(String url) {
		new RegressionFlow().login(url);
		return new Salud_Test();
	}
	
	@Step
	public Salud_Test saludCrearCotizacion(String rownum,String clave,String producto,
			String numdoc, String riesgo_Identification ,String Salud_occupacion,
			String fecha, String teleFono, String cuidad, String direccion) 
	{
		SaludFlow s=new SaludFlow();
		s.gotoSalud(rownum);
		s.enterClave(rownum, clave);
		s.selectProducto(producto);
		s.enterTomador(rownum,numdoc,fecha,teleFono,cuidad,direccion);
		s.enterRiesgo(rownum, riesgo_Identification,Salud_occupacion,fecha,cuidad );
		//s.enterValorAsegurado(rownum,edifico,no_electrico,electrico);
		return new Salud_Test();
	}

	@Step
	public Salud_Test saludCopiarCotizacion(String rownum,String clave,String producto, 
			String numdoc, String riesgo_Identification ,String Salud_occupacion, String weight, String height, String entidad) 
 {
		SaludFlow h=new SaludFlow();
		h.copiarCotizacion(rownum,producto,weight,height,entidad);
		return new Salud_Test();
}
}
	/*@Step
	public Hogar_Test hogarCommonConsultation(String rownum,String numeroPisos,String barrio) {
		CommonConsultationFlow c=new CommonConsultationFlow();
		c.gotoCommonConsult();
		c.consultaCotizaciones(rownum);
		c.doEmitir(rownum,numeroPisos,barrio);
		return new Hogar_Test();
	}
	
	@Step
	public Hogar_Test hogarCopiarCotizacion(String rownum,String clave,String producto, String numdoc,String ciudad,String direccion,String ano_construction,String edifico,String no_electrico,String electrico) {
		HogarFlow h=new HogarFlow();
		h.copiarCotizacion(rownum);
		return new Hogar_Test();
	}
	
	@Step
	public Hogar_Test hogarPDF(String rownum) {
		HogarFlow h=new HogarFlow();
		h.cotizacionPDF(rownum);
		return new Hogar_Test();
	}
	
   
    	
    
    
}
*/