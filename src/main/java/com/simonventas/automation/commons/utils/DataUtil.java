package com.simonventas.automation.commons.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	
	public static ExcelReader dataExcel=new ExcelReader(System.getProperty("user.dir")+File.separatorChar+PropertyManager.getConfigValueByKey("dataExcel"));
	
	public static String url=PropertyManager.getConfigValueByKey("url");
	public static String browser=PropertyManager.getConfigValueByKey("browserName");
	public static String inputExcelSheetName=PropertyManager.getConfigValueByKey("inputExcelSheetName");
	public static String newTomadorNombre=PropertyManager.getConfigValueByKey("newTomadorNombre");
	public static String newTomadorApellido=PropertyManager.getConfigValueByKey("newTomadorApellido");

	public static String newRiesgoNombre=PropertyManager.getConfigValueByKey("newRiesgoNombre");
	public static String newRiesgoApellido=PropertyManager.getConfigValueByKey("newRiesgoApellido");
	
	public static String tipoEnvio=PropertyManager.getConfigValueByKey("tipoEnvio");
	
	public static String general_rol=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel1"), 2);
	public static String general_primer_nombre=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel1"), 3);
	public static String general_primer_appelido=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel1"), 4);
	public static String general_fecha_nacimiento=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel1"), 5);
	public static String general_lugar_nacimiento=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel1"), 6);
	public static String general_estado_civil=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel1"), 7);
	public static String general_sexo=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel1"), 8);
	public static String general_direccion=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel1"), 9);
	public static String general_ciudad=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel1"), 10);
	public static String general_telephono=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel1"), 11);
	public static String general_celular=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel1"), 12);
	public static String general_correo=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel1"), 13);	

	public static String actividad_economica_occupacion=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel2"), 2);
	public static String actividad_economica_expuesta=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel2"), 3);
	public static String actividad_economica_familiares_expuesta=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel2"), 4);
	
	
	public static String financiera_activos=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel3"), 2);
	public static String financiera_pasivos=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel3"), 3);
	public static String financiera_patrimonio=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel3"), 4);
	public static String financiera_ingresos_menusales=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel3"), 5);
	public static String financiera_egresos_mensuales=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel3"), 6);
	public static String financiera_ingresos_adicionales=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel3"), 7);
	public static String financiera_moneda_extranjera=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel3"), 8);
	public static String financiera_operaciones_internacionales=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel3"), 9);
	public static String financiera_en_el_exterior=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel3"), 10);
	
	
	public static String declaracion_autoriza_compartir=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel4"), 2);
	public static String declaracion_autoriza_recibir=dataExcel.getCellData(PropertyManager.getConfigValueByKey("newTomadorSheetName"), PropertyManager.getConfigValueByKey("conociementoPanel4"), 3);
	
	public static String common_consultation_campania=dataExcel.getCellData(PropertyManager.getConfigValueByKey("commonConsultSheetName"), 1, 2);
	public static String common_consultation_seccion=dataExcel.getCellData(PropertyManager.getConfigValueByKey("commonConsultSheetName"), 2, 2);
	public static String common_consultation_producto=dataExcel.getCellData(PropertyManager.getConfigValueByKey("commonConsultSheetName"), 3, 2);
	
	public static String salud_common_consultation_campania=dataExcel.getCellData(PropertyManager.getConfigValueByKey("commonConsultSheetName"), 1, 3);
	public static String salud_common_consultation_seccion=dataExcel.getCellData(PropertyManager.getConfigValueByKey("commonConsultSheetName"), 2, 3);
	public static String salud_common_consultation_producto=dataExcel.getCellData(PropertyManager.getConfigValueByKey("commonConsultSheetName"), 3, 3);
	
	public static String salud_common_consultation_desde=dataExcel.getCellData(PropertyManager.getConfigValueByKey("commonConsultSheetName"), 4, 3);
	public static String salud_common_consultation_hasta=dataExcel.getCellData(PropertyManager.getConfigValueByKey("commonConsultSheetName"), 5, 3);
	
}


