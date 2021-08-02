package com.simonventas.automation.tests;

import java.util.Hashtable;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.simonventas.automation.commons.Hooks;
import com.simonventas.automation.utils.DataProviders;
import com.simonventas.automation.utils.Log;


@Listeners(com.simonventas.automation.utils.TestListener.class)	
public class Hogar_Test extends Hooks{

		
	public static Log log=new Log(Hogar_Test.class.getName());
	ThreadLocal<VentasStepDef> steps= ThreadLocal.withInitial(VentasStepDef::new);

	@Test(enabled=true,dataProviderClass=DataProviders.class,dataProvider="getData")
	public void hogarFlows(Hashtable<String,String> data) {
		String scenario=data.get("S.no");
		
		switch(scenario) {
				case "1":
					log.info("Existing Tercero");
					steps.get()
					.hogarCrearCotizacion(String.valueOf(data.get("S.no")), String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), String.valueOf(data.get("Num_Doc")), String.valueOf(data.get("Ciudad")),String.valueOf(data.get("Direccion")),String.valueOf(data.get("Estrato")), String.valueOf(data.get("Ano_Construccion")),String.valueOf(data.get("Rural")),String.valueOf(data.get("Edifico")), String.valueOf(data.get("No_Electrico")), String.valueOf(data.get("Electrico")));
					//.hogarEmisionPoliza(data.get("S.no"),data.get("Insp_FechaSegurida"),data.get("Insp_FechaSegurida2"),data.get("Numero_Pisos"),data.get("Barrio"));
					break;
				case "2":
					log.info("Non Existing");
					//steps.get().hogarCrearCotizacion(String.valueOf(data.get("S.no")), String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), String.valueOf(data.get("Num_Doc")), String.valueOf(data.get("Ciudad")),  String.valueOf(data.get("Direccion")),String.valueOf(data.get("Estrato")), String.valueOf(data.get("Ano_Construccion")),String.valueOf(data.get("Edifico")), String.valueOf(data.get("No_Electrico")), String.valueOf(data.get("Electrico")));
					//steps.get().hogarEmisionPoliza(data.get("S.no"),data.get("Numero_Pisos"),data.get("Barrio"));
					break;
				case "3":
					log.info("Copiar Cotizacion");
					//steps.get().hogarCrearCotizacion(String.valueOf(data.get("S.no")), String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), String.valueOf(data.get("Num_Doc")), String.valueOf(data.get("Ciudad")),  String.valueOf(data.get("Direccion")),String.valueOf(data.get("Estrato")), String.valueOf(data.get("Ano_Construccion")),String.valueOf(data.get("Edifico")), String.valueOf(data.get("No_Electrico")), String.valueOf(data.get("Electrico")));
					//steps.get().hogarCopiarCotizacion(String.valueOf(data.get("S.no")), String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), String.valueOf(data.get("Num_Doc")), String.valueOf(data.get("Ciudad")),  String.valueOf(data.get("Direccion")),String.valueOf(data.get("Estrato")), String.valueOf(data.get("Ano_Construccion")),String.valueOf(data.get("Edifico")), String.valueOf(data.get("No_Electrico")), String.valueOf(data.get("Electrico")));
					break;
				case "4":
					log.info("Common Consultation");
					//steps.get().hogarCommonConsultation(String.valueOf(data.get("S.no")),data.get("Numero_Pisos"),data.get("Barrio"));
					break;
				case "5":
					log.info("Cotizacion_PDF");
					//steps.get().hogarCrearCotizacion(String.valueOf(data.get("S.no")), String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), String.valueOf(data.get("Num_Doc")), String.valueOf(data.get("Ciudad")),  String.valueOf(data.get("Direccion")),String.valueOf(data.get("Estrato")), String.valueOf(data.get("Ano_Construccion")),String.valueOf(data.get("Edifico")), String.valueOf(data.get("No_Electrico")), String.valueOf(data.get("Electrico")));
					//steps.get().hogarCotizacionPDF(String.valueOf(data.get("S.no")));
					break;
				case "6":
					log.info("Poliza PDF");
					//steps.get().hogarCrearCotizacion(String.valueOf(data.get("S.no")), String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), String.valueOf(data.get("Num_Doc")), String.valueOf(data.get("Ciudad")),  String.valueOf(data.get("Direccion")),String.valueOf(data.get("Estrato")), String.valueOf(data.get("Ano_Construccion")),String.valueOf(data.get("Edifico")), String.valueOf(data.get("No_Electrico")), String.valueOf(data.get("Electrico")));
					//steps.get().hogarPolicyPDF(data.get("S.no"),data.get("Numero_Pisos"),data.get("Barrio"));
					break;
		}
	}
	
}
