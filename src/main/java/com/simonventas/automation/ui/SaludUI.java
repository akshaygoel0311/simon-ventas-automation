package com.simonventas.automation.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.simonventas.automation.commons.BaseTest;
import com.simonventas.automation.commons.helpers.DriverFacade;

public class SaludUI extends BaseTest{
	
	protected DriverFacade driverFacade;
	
	@FindBy(xpath="//div[@id='pageError']")
	public static WebElement page_error;
	
	@FindBy(xpath="//a[contains(text(),'Inicio')]")
	public static WebElement inicio;

	@FindBy(xpath="//a[@class='arrow']/span[text()=' Cotizadores Salud Test']")
	public static WebElement salud_main;

	@FindBy(xpath="//a[text()=' Salud Test']")
	public static WebElement salud_menu;

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
	@FindBy(xpath="//select[@name='codProducto']")
	public static WebElement producto;
	
	@FindBy (xpath="//*[@id='optionDePlanesId673']")
	public static WebElement plan;
	
	@FindBy(xpath="//input[@id='step2C']")
	public static WebElement siguiente2;

	//@FindBy(xpath="//input[@id='step3C']")
	//public static WebElement siguiente3;
	//producto page elements end

	//tomador page elements
	@FindBy(xpath="//input[@id='numeroDocumento']") 
	public static WebElement nrodocumento;
	
	@FindBy(xpath="//span[@id='errorSpan']")
	public static WebElement tomador_error;
	
	/*@FindBy(xpath="//div[@id='errorSpan']")
	public static By tomador_no_existe;*/
	
	public static String tomador_no_existe="//span[@id='errorSpan']";
	
	@FindBy(id="nombres")
	public static WebElement nombre;
	
	@FindBy(id="apellidos")
	public static WebElement apellidos;
	
	@FindBy(xpath="//*[@id='autorizaDatosCheck1']")
	public static WebElement autoriza_datos_chbx;

	@FindBy(xpath="//input[@id='continuarUSO']")
	public static WebElement continuar;
	
	@FindBy(xpath="//input[@id='step3C']")
	public static WebElement siguiente3;
	//tomador page elements end   "//div[@id='errorSpan']"

	@FindBy(xpath="//*[@id='identificationR']")
	public static WebElement riesoIdentification;

	@FindBy(xpath="//*[@id='ocupacion']")
	public static WebElement occupacion;

	@FindBy(xpath="//*[@id='addriskbutton']")
	public static WebElement addriesgo;
	
	@FindBy(xpath="//*[@id='liquidarbutton4']")
	public static WebElement liqidarprima;
	
	@FindBy(xpath="//*[@id='optionDePlanesId1']")
	public static WebElement selectPlan;
	
	@FindBy(xpath="//*[@id='submitbutton']")
	public static WebElement crearCotizacion;
	
	@FindBy(xpath="//label[@id='quotNo']")
	public static WebElement quoteNo;

	@FindBy(xpath="//*[@id='errorSubmit']")
	public static WebElement error;
	
	@FindBy(xpath="//*[@id='createSimilarQuotation']")
	public static WebElement copiarCotizacion;

	@FindBy(xpath="//a[text()='Cancelar']")
	public static WebElement cancelar;
	
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
	
	@FindBy(xpath="//*[@id='textMessage']")
	public static WebElement decNo;
	
	@FindBy(xpath="//*[@id='continuarDeclaration']")
	public static WebElement decContinuar;
	
	@FindBy(xpath="//*[@id='continueFormalize']")
	public static WebElement emitir;
	
	@FindBy(xpath="//*[@id='step4C']")
	public static WebElement siguiente4;
	
	@FindBy(xpath="//*[@id='entidadEPS0']")
	public static WebElement entidad;
	
	@FindBy(xpath="//*[@id='step5C']")
	public static WebElement siguiente5;
	
	@FindBy(xpath="//*[@id='observaciones']")
	public static WebElement observaciones;
	
	@FindBy(xpath="//*[@id='errorSubmitTextVidaPopup']")
	public static WebElement numeroPoliza;
	
	@FindBy(xpath="//*[@id='ncmntoFecha']")
	public static WebElement fecha;
	
	@FindBy(xpath="//*[@id='fechaNamiciento']")
	public static WebElement fechaReisgo;
	
	@FindBy(xpath="//*[@id='ciudadDescRisk']")
	public static WebElement cuidadRiesgo;
	
	@FindBy(xpath="//*[@id='celularFormated']")
	public static WebElement teleFono;
	
	@FindBy(xpath="//*[@id='ciudadDesc']")
	public static WebElement cuidad;

	@FindBy(xpath="//*[@id='direccionofSalud']")
	public static WebElement direccion;
	
	@FindBy(xpath="//*[@id='errorSpanIdentificationR']")
	public static WebElement riesgo_error ;
	
	public static String riesgo_no_existe="//*[@id='errorSpanIdentificationR']";
	
	@FindBy(id="apellidoR")
	public static WebElement apellidoRiesgo;
	
	@FindBy(id="nombresRR")
	public static WebElement nombreRiesgo;
	
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
		public static WebElement direccion1;
		
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
		public static WebElement occupacion1;
		
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
		@FindBy(xpath="//*[@id='imprimir']")
		public static WebElement cotizacion_pdf;
		
		@FindBy(xpath="//a[@class='btn btn-primary closePopUpForAcceptar']")
		public static WebElement acceptar;

		@FindBy(xpath="//a[@class='btn btn-primary']")
		public static WebElement continuar_poliza;
		
		@FindBy(xpath="//*[@id='suggestionText']")
		public static WebElement suggestionText;
		
		@FindBy(xpath="//*[@id='closeFeedbackPopup']")
		public static WebElement closeRating;
		
		@FindBy(xpath="//a[@class='arrow']/span[text()=' Consulta Cotizaciones Test']")
		public static WebElement consultationMenu;

		@FindBy(xpath="//a[text()=' Consulta Cotización por Rango de Fechas Test']")
		public static WebElement clickConsultation;
		
		@FindBy(xpath="//*[@id='imprimir']")
		public static WebElement pdf_download;
		
		 
}
