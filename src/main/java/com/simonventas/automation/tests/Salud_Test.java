package com.simonventas.automation.tests;

import java.util.Hashtable;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.simonventas.automation.commons.Hooks;
import com.simonventas.automation.utils.DataProviders;
import com.simonventas.automation.utils.Log;


@Listeners(com.simonventas.automation.utils.TestListener.class)	

public class Salud_Test extends Hooks{

		
	public static Log log=new Log(Salud_Test.class.getName());
	ThreadLocal<VentasStepDefSalud> steps= ThreadLocal.withInitial(VentasStepDefSalud::new);

	@Test(priority=2,enabled=true,dataProviderClass=DataProviders.class,dataProvider="getDataSalud")
	public void saludFlows(Hashtable<String,String> data) {
		String scenario=data.get("S.no");	
		switch(scenario) {
				case "1":
					log.info("Existing/NonExisting Tercero");
					 steps.get().saludCrearCotizacion(String.valueOf(data.get("S.no")), 
							 String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), 
							 String.valueOf(data.get("Num_Doc")),
							 String.valueOf(data.get("Identification_Riesgo")),
							 String.valueOf(data.get("Occupacion")),
									 String.valueOf(data.get("Fecha")),
									 String.valueOf(data.get("Telefono_Celular")),
									 String.valueOf(data.get("Ciudad")),
									 String.valueOf(data.get("Dirección")));
					break;
				  /*case "2":
					log.info("Non Existing");
					 steps.get().saludCrearCotizacion(String.valueOf(data.get("S.no")), 
							 String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), 
							 String.valueOf(data.get("Num_Doc")),
							 String.valueOf(data.get("Identification_Riesgo")),
							 String.valueOf(data.get("Occupacion")),
							 String.valueOf(data.get("Fecha")),
							 String.valueOf(data.get("Telefono_Celular")),
							 String.valueOf(data.get("Ciudad")),
							 String.valueOf(data.get("Dirección")));
					        break;*/
					case "2":
					log.info("Copiar Cotizacion");
					steps.get().saludCopiarCotizacion(String.valueOf(data.get("S.no")),
							String.valueOf(data.get("Clave")), 
							String.valueOf(data.get("Producto")), 
						    String.valueOf(data.get("Num_Doc")),
							String.valueOf(data.get("Identification_Riesgo")),
							String.valueOf(data.get("Occupacion")),
							String.valueOf(data.get("Weight")),
							String.valueOf(data.get("Height")),
							String.valueOf(data.get("Entidad")));
					        break;
				case "3":
					log.info("Common Consultation");
					//steps.get().hogarCommonConsultation(String.valueOf(data.get("S.no")),data.get("Numero_Pisos"),data.get("Barrio"));
					break;
				/*case "5":
					log.info("Cotizacion_PDF");
					//steps.get().hogarCrearCotizacion(String.valueOf(data.get("S.no")), String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), String.valueOf(data.get("Num_Doc")), String.valueOf(data.get("Ciudad")),  String.valueOf(data.get("Direccion")), String.valueOf(data.get("Ano_Construccion")),String.valueOf(data.get("Edifico")), String.valueOf(data.get("No_Electrico")), String.valueOf(data.get("Electrico")));
					//teps.get().hogarPDF(String.valueOf(data.get("S.no")));
					break;
				case "6":
					log.info("Poliza PDF");*/
					//break;
		}
	}
}
