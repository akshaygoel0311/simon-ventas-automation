package com.simonventas.automation.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.simonventas.automation.commons.BaseTest;
import com.simonventas.automation.commons.helpers.DriverFacade;

public class HogarUI extends BaseTest{
	
	protected DriverFacade driverFacade;
	
	@FindBy(xpath="//div[@id='pageError']")
	public static WebElement page_error;
	
	
	
	@FindBy(xpath="//a[contains(text(),'Inicio')]")
	public static WebElement inicio;

	@FindBy(xpath="//a[@class='arrow']/span[text()=' Cotizadores Hogar Test']")
	public static WebElement hogar_main;

	@FindBy(xpath="//a[text()=' Hogar Test']")
	public static WebElement hogar_menu;

	//clave page elements
	@FindBy(xpath="//input[@id='codAgente']")
	public static WebElement clave;

	@FindBy(xpath="//span[@id='codAgenteError']")
	public static WebElement clave_service_error;

	@FindBy(xpath="//div[@id='errorDiv']")
	public static WebElement clave_empty;

	@FindBy(xpath="//span[contains(text(),' Agente Inexistente')]")
	public static WebElement clave_inexistente;

	@FindBy(xpath="//span[@id='nombreAgente']")
	public static WebElement clave_nombre;

	@FindBy(xpath="//input[@id='step1C']")
	public static WebElement siguiente1;
	//clave page elements end

	//producto page elements
	@FindBy(xpath="//select[@name='codProductoSelect']")
	public static WebElement producto;
	
	@FindBy(xpath="//input[@id='step2C']")
	public static WebElement siguiente2;

	@FindBy(xpath="//input[@id='step3C']")
	public static WebElement siguiente3;
	//producto page elements end

	//tomador page elements
	@FindBy(xpath="//input[@id='numeroDocumento']")
	public static WebElement nrodocumento;
	
	@FindBy(xpath="//div[@id='errorSpan']")
	public static WebElement tomador_error;
	
	/*@FindBy(xpath="//div[@id='errorSpan']")
	public static By tomador_no_existe;*/
	
	public static String tomador_no_existe="//div[@id='errorSpan']";
	
	@FindBy(id="nombres")
	public static WebElement nombre;
	
	@FindBy(id="apellidos")
	public static WebElement apellidos;
	
	@FindBy(xpath="//input[@id='step4C']")
	public static WebElement siguiente4;
	//tomador page elements end   "//div[@id='errorSpan']"

	@FindBy(xpath="//input[@id='step5C']")
	public static WebElement riesgo_continuar;

	@FindBy(xpath="//input[@id='step6C']")
	public static WebElement siguiente6;

	@FindBy(xpath="//input[@id='step8C']")
	public static WebElement siguiente7;

	@FindBy(xpath="//label[@for='autorizaDatosCheck1']")
	public static WebElement autoriza_datos_chbx;

	@FindBy(xpath="//input[@id='continuarUSO']")
	public static WebElement continuar;

	@FindBy(id="codCiudad")
	public static WebElement ciudadRiesgo;

	@FindBy(id="direccionRiesgo")
	public static WebElement direccionRiesgo;
	
	@FindBy(xpath="//select[@id='estrato']")
	public static WebElement estrato;
	
	@FindBy(xpath="//label[@class='handle-cbx' and @for='rural']")
	public static WebElement rural_box;

	@FindBy(xpath="//select[@id='anosConstruccion']")
	public static WebElement anosConstruccion;

	@FindBy(id="valorAsegurado_formatted")
	public static WebElement vr_edificio;

	@FindBy(id ="valorNoElectrico_formatted")
	public static WebElement vr_contenido_no_electrico;

	@FindBy(id ="valorElectrico_formatted")
	public static WebElement vr_contenido_electrico;

	@FindBy(id="submitbutton")
	public static WebElement submit;

	@FindBy(xpath="//label[contains(text(),'N�mero de cotizaci�n')]")
	public static WebElement numero_cotizacion_text;

	@FindBy(xpath="//label[@id='quotNo']")
	public static WebElement quoteNo;

	@FindBy(id="formalize")
	public static WebElement emitir;

	@FindBy(id="continueAlerta")
	public static WebElement alert;
	
	//inspeccion UI elements
	@FindBy(xpath="//a[@id='continueAlertaInsp']")
	public static WebElement inspeccion_continuar;
	
	@FindBy(xpath="//input[@id='fechaSegurida']")
	public static WebElement fecha_segurida;
	
	@FindBy(xpath="//input[@id='fechaSegurida2']")
	public static WebElement fecha_segurida2;
	
	@FindBy(xpath="//input[@id='submitbutton']")
	public static WebElement agendar;

	@FindBy(id="informaciónAdicional1")
	public static WebElement datos_adicionales_1;

	@FindBy(id="numeroDePisos1")
	public static WebElement numero_pisos;

	@FindBy(id="barrio1")
	public static WebElement barrio;

	@FindBy(id="tipoEnvio")
	public static WebElement tipo_envio;

	@FindBy(xpath="//label[@id='quotNo']")
	public static WebElement numero_poliza;

	@FindBy(xpath="//a[@class='btn btn-primary closePopUpForAcceptar']")
	public static WebElement acceptar;

	@FindBy(xpath="//a[@class='btn btn-primary']")
	public static WebElement continuar_poliza;

	@FindBy(xpath="//div[@id='errorSubmit']")
	public static WebElement error;

	@FindBy(xpath="//a[text()='Cancelar']")
	public static WebElement cancelar;
	
	//add tomador elements
	@FindBy(id="addTomador")
	public static WebElement addTomador;
	
	@FindBy(id="rol")
	public static WebElement rol;
	
	@FindBy(xpath="//input[@id='nombresC']")
	public static WebElement general_primer_nombre;
	
	@FindBy(xpath="//input[@id='primerApellido']")
	public static WebElement general_primer_appelido;
	
	@FindBy(xpath="//input[@id='fechaNacimientoC']")
	public static WebElement fecha_nacimiento;
	
	@FindBy(xpath="//input[@id='lugarNacimiento']")
	public static WebElement lugar_nacimiento;
	
	@FindBy(xpath="//select[@id='estadoCivils']")
	public static WebElement estado_civil;
	
	@FindBy(xpath="//select[@id='sexo']")
	public static WebElement sexo;
	
	@FindBy(xpath="//input[@id='dirResidencia']")
	public static WebElement direccion;
	
	@FindBy(xpath="//input[@id='ciudadResi']")
	public static WebElement ciudad;
	
	@FindBy(xpath="//input[@id='telefonoResidencia']")
	public static WebElement telephono;
	
	@FindBy(xpath="//input[@id='noCelular']")
	public static WebElement celular;
	
	@FindBy(xpath="//input[@id='email']")
	public static WebElement correo;
	
	@FindBy(xpath="//input[@id='goNext']")
	public static WebElement informacion_general_siguiente;
	
	@FindBy(xpath="//select[@id='ocupacion']")
	public static WebElement occupacion;
	
	@FindBy(xpath="//input[@id='goNext1']")
	public static WebElement actividad_econimica_siguiente;
	
	@FindBy(xpath="//input[@id='totalActivos']")
	public static WebElement total_activos;
	
	@FindBy(xpath="//input[@id='totalPasivos']")
	public static WebElement total_pasivos;
	
	@FindBy(xpath="//input[@id='totalPatrrimonio']")
	public static WebElement total_patrimonio;
	
	@FindBy(xpath="//input[@id='totalIngresoMensuals']")
	public static WebElement ingresos_mensuales;
	
	@FindBy(xpath="//input[@id='totalEgresosMensuales']")
	public static WebElement egresos_mensuales;
	
	@FindBy(xpath="//input[@id='goNextInformacionFinanCiera']")
	public static WebElement financiera_informacion_siguiente;
		
	@FindBy(xpath="//input[@id='submitbutton114']")
	public static WebElement declaracion_siguiente;
	
	@FindBy(xpath="//button[text()='Ok']")
	public static WebElement conocimiento_ok;
	
	@FindBy(xpath="//a[@id='refreshTomador']")
	public static WebElement refresh_tomador;
	
	@FindBy(xpath="//div[@id='saveDataErrorOnSubmit']")
	public static WebElement add_tomador_error;
	
	//CopiarCotizacion UI elements
	@FindBy(xpath="//input[@id='createSimilarQuotation']")
	public static WebElement copiar_quote;
	
	//PDF elements
	@FindBy(xpath="//span[@id='popUpPDF']")
	public static WebElement pdf;
	
	@FindBy(tagName="downloads-manager")
	public static WebElement downloads;
	
	@FindBy(css="downloads-item")
	public static WebElement downloads_item;
	
	@FindBy(xpath="//span[@id='warningMsg']")
	public static WebElement warning_message;
	
	
	
	
	
	
	
	

}
