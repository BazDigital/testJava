package com.gs.TestAppium;

import com.gs.TestAppium.util.Driver;
import com.gs.TestAppium.util.ScreenShot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	
    	/*
    	 * Escribir las lineas de codigo que realicen el siguiente flujo
    	 * 
    	 * Después de desplegar la aplicaciòn
    	 * Presionar el boton "YA SOY CLIENTE" con el id = btn_log_in
    	 * Posteriormente ingresar un usuario (puede ser cualquier nombre) en el campo de texto "Usuario" con el id = edt_user
    	 * Enseguida ingresar el password (puede ser cualquier password) en el campo de texto "Contraseña" con el id = edt_hotword
    	 * 
    	 * A continuación se debe de tomar una impresion de pantalla, esta funcionalidad se debe de realizar en la clase ScreenShot en
    	 * la ruta com.gs.TestAppium.util, y se debe de mandar a llamar desde aqui sin necesiadad de instanciar un objeto de la
    	 * clase ScreenShot, un ejemplo de como se deberia de mandar a llamar serìa:
    	 * 
    	 * ScreenShot.takePicture(driver);
    	 * 
    	 * Dentro de este metodo se debe de tomar el screen shot y guardarlo en la siguiente ruta:
    	 * (Dentro de la clase se encuentra declarada una variable con la ruta)
    	 * 
    	 *  /src/main/resources/assets/takePhotoTmp/
    	 *  
    	 *  Se debe de considerar el caso en que la carpeta "takePhotoTmp" no exista, en esta situaciòn se debe de crear automaticamente
    	 *  
    	 *  Y para finalizar el flujo se debe de presionar el boton "SIGUIENTE" con id = btn_next
    	 * 
    	 * 
    	 * */
		
		Driver driverConfig = new Driver();
		AppiumDriver<MobileElement> driver = driverConfig.getDriver();		
		


		
    	
    }
}
