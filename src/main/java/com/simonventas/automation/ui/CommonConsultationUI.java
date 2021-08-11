package com.simonventas.automation.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.simonventas.automation.commons.BaseTest;
import com.simonventas.automation.commons.helpers.DriverFacade;

public class CommonConsultationUI extends BaseTest{

	protected DriverFacade driverFacade;

	@FindBy(xpath="//a[@class='arrow']/span[text()=' Consulta Cotizaciones Test']")
	public static WebElement consulta_cotizaciones_main;

	@FindBy(xpath="//a[text()=' Consulta Cotización por Rango de Fechas Test']")
	public static WebElement consulta_cotizaciones_menu;

	@FindBy(xpath="//select[@id='company']")
	public static WebElement compania;

	@FindBy(xpath="//input[@id='fechaInicio']")
	public static WebElement fecha_desde;

	@FindBy(xpath="//select[@id='seccion']")
	public static WebElement seccion;

	@FindBy(xpath="//select[@id='product']")
	public static WebElement producto;

	@FindBy(xpath="//input[@id='numDeCotizacion']")
	public static WebElement numero_cotizacion;
	
	@FindBy(xpath="//input[@id='fechaFin']")
	public static WebElement fecha_hasta;

	@FindBy(xpath="//input[@id='consultar']")
	public static WebElement consultar;

	@FindBy(xpath="//table[@id='searchResult']//a[@class='btn btn-success']")
	public static WebElement emitir;

	@FindBy(xpath="//*[@id='continueFormalize']")
	public static WebElement emitirCotiz;
	
	@FindBy(xpath="//input[@id='HogarcontinueAlertaAdvance']")
	public static WebElement alert;

	@FindBy(xpath="//input[@id='step1C']")
	public static WebElement siguiente1;

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
	
	@FindBy(xpath="//label[@for='autorizaDatosCheck1']")
	public static WebElement autoriza_datos_chbx;

	@FindBy(xpath="//input[@id='continuarUSO']")
	public static WebElement continuar;
	
	@FindBy(xpath="//input[@id='step2C']")
	public static WebElement siguiente2;

	@FindBy(xpath="//input[@id='step3C']")
	public static WebElement siguiente3;
	
	@FindBy(xpath="//input[@id='step4C']")
	public static WebElement siguiente4;
	
	@FindBy(id="informaciónAdicional1")
	public static WebElement datos_adicionales_1;

	@FindBy(id="numeroDePisos1")
	public static WebElement numero_pisos;

	@FindBy(id="barrio1")
	public static WebElement barrio;

	@FindBy(id="tipoEnvio")
	public static WebElement tipo_envio;
	
	@FindBy(xpath="//input[@id='step5C']")
	public static WebElement riesgo_continuar;

	@FindBy(xpath="//input[@id='step6C']")
	public static WebElement siguiente6;
	
	@FindBy(xpath="//input[@id='step8C']")
	public static WebElement siguiente7;
	
	@FindBy(id="submitbutton")
	public static WebElement submit;
	
	@FindBy(xpath="//div[@id='errorSubmit']")
	public static WebElement error;
	
	@FindBy(xpath="//a[text()='Cancelar']")
	public static WebElement cancelar;
	
	@FindBy(xpath="//label[@id='quotNo']")
	public static WebElement numero_poliza;

	@FindBy(xpath="//a[@class='btn btn-primary closePopUpForAcceptar']")
	public static WebElement acceptar;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	public static WebElement continuar_poliza;

    @FindBy(xpath="//select[@id='ocupacion']")
	public static WebElement occupacion1;
    
    @FindBy(xpath="//input[@id='dirResidencia']")
	public static WebElement direccion1;

    @FindBy(xpath="//*[@class='riskFirstSpan']//*[text()='Haga clic aquí para completar la Declaración de riesgos']")
	public static WebElement decLink;
	
	/*@FindBy (xpath="//*[@id='optionDePlanesId673']")
	public static WebElement plan;*/
	
	
	@FindBy(xpath="//*[@id='peso_1']")
	public static WebElement weight;
	
	@FindBy(xpath="//*[@id='estatura_1']")
	public static WebElement height;
	
	@FindBy(xpath="//*[@id='30001179_8']")
	public static WebElement decQue;
	
	@FindBy(xpath="//*[@id='30001178_8']")
	public static WebElement decQue1;
	
	@FindBy(xpath="//*[@id='30001180_8']")
	public static WebElement decQue2;
	
	@FindBy(xpath="//*[@id='30001181_8']")
	public static WebElement decQue3;
	
	@FindBy(xpath="//*[@id='30000714_8']")
	public static WebElement decQue4;
	
	@FindBy(xpath="//*[@id='30000718_8']")
	public static WebElement decQue5;

	@FindBy(xpath="//*[@id='30000726_8']")
	public static WebElement decQue6;
	
	@FindBy(xpath="//*[@id='30000744_8']")
	public static WebElement decQue7;
	
	@FindBy(xpath="//*[@id='30000318_8']")
	public static WebElement decQue8;
	
	@FindBy(xpath="//*[@id='30000319_8']")
	public static WebElement decQue9;
	
	@FindBy(xpath="//*[@id='30000321_8']")
	public static WebElement decQue10;
	
	@FindBy(xpath="//*[@id='30000322_8']")
	public static WebElement decQue11;
	
	@FindBy(xpath="//*[@id='30000323_8']")
	public static WebElement decQue12;
	
	@FindBy(xpath="//*[@id='30000720_8']")
	public static WebElement decQue13;
	
	@FindBy(xpath="//*[@id='30000723_8']")
	public static WebElement decQue14;
	
	@FindBy(xpath="//*[@id='submitbutton']")
	public static WebElement submitDec;
	
	@FindBy(xpath="//*[@id='continuarDeclaration']")
	public static WebElement decContinuar;

	@FindBy(xpath="//*[@id='entidadEPS0']")
	public static WebElement entidad;
	
	@FindBy(xpath="//*[@id='step5C']")
	public static WebElement siguiente5;
	
	@FindBy(xpath="//*[@id='closeFeedbackPopup']")
	public static WebElement closeRating;
	
	@FindBy(xpath="//*[@id='errorSubmitTextVidaPopup']")
	public static WebElement numeroPoliza;
	
	@FindBy(xpath="//*[@id='textMessage']")
	public static WebElement decNo;
}
