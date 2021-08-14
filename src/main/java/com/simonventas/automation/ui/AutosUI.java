package com.simonventas.automation.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.simonventas.automation.commons.BaseTest;
import com.simonventas.automation.commons.helpers.DriverFacade;

public class AutosUI extends BaseTest{
	protected DriverFacade driverFacade;
	
	@FindBy(xpath="//div[@id='pageError']")
	public static WebElement page_error;
	
	@FindBy(xpath="//a[contains(text(),'Inicio')]")
	public static WebElement inicio;
	
	@FindBy(xpath="//span[normalize-space()='Autos Test autosIcon.png']")
	public static WebElement autos_main;
	
	@FindBy(xpath="//a[text()=' Cotización Autos']")
	public static WebElement autos_menu;
	
	//clave page elements
	@FindBy(xpath="//input[@id='codAgente']")
	public static WebElement clave;
	
	@FindBy(xpath="//span[@id='nombreAgente']")
	public static WebElement clave_nombre;
	
	@FindBy(xpath="//span[@id='codAgenteError']")
	public static WebElement clave_service_error;
	
	@FindBy(xpath="//select[@name='subProducto']")
	public static WebElement subproducto;
	
	@FindBy(xpath="//label[@for='marcaLikeCheckbox']")
	public static WebElement marcaCheckbox;

	@FindBy(xpath="//input[@id='marcaLike']")
	public static WebElement marcaDescription;
	
	@FindBy(xpath="//input[@id='buscar']")
	public static WebElement placa_marcaContinuar; 
	
	@FindBy(xpath="tbody[role='alert']")
	public static WebElement marcaConsultationTable;
	
	@FindBy(xpath="//div[@id='errorMarcaPlaca']")
	public static WebElement errorMarcaPlaca;
	
	@FindBy(xpath="//tbody[@role='alert']//tr[1]")
	public static WebElement firstmarca;
	
	@FindBy(xpath="//table[@id='modelYears']//tr[@class='odd']")
	public static WebElement modelo;
}
