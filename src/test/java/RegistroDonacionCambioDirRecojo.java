import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class RegistroDonacionCambioDirRecojo {

    static AndroidDriver<MobileElement> driver;

    public static void main(String[] args) {
        try {
            ejecutarPruebaAutomatizada();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void ejecutarPruebaAutomatizada() throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "SM-G935F");
        capabilities.setCapability("udid", "ce10171ab5e6d0700c");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("appPackage", "com.upc.movil");
        capabilities.setCapability("appActivity", "com.upc.movil.activities.MainActivity");

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver<MobileElement>(url, capabilities);
        System.out.println("Iniciando prueba automatizada de Registro Nuevo de Donacion...");

        // Ir a Login
        MobileElement imageLogin = driver.findElementByXPath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView");
        imageLogin.click();

        // Iniciando sesion
        MobileElement txtUsername = driver.findElement(By.id("com.upc.movil:id/TextCorreo"));
        MobileElement txtPassword = driver.findElement(By.id("com.upc.movil:id/TextPasswordLog"));
        MobileElement btnLogin = driver.findElement(By.id("com.upc.movil:id/btnLogin"));
        txtUsername.click();
        txtUsername.setValue("jperez");
        txtPassword.click();
        txtPassword.setValue("123");
        btnLogin.click();

        System.out.println("Login exitoso");

        Thread.sleep(3000);

        // Nueva Donacion
        MobileElement imageNuevaDonacion = driver.findElementByXPath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView");
        imageNuevaDonacion.click();
        Thread.sleep(1000);

        // Click en cambio de direccion
        MobileElement imgBtnDireccion = driver.findElement(By.id("com.upc.movil:id/ibDireccionDonacion"));
        imgBtnDireccion.click();
        Thread.sleep(5000);

        // Aceptar permiso de maps
        MobileElement btnAceptarPermiso = driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
        btnAceptarPermiso.click();
        Thread.sleep(1000);

        // Buscar Tottus Santa Anita
        TouchAction touchAction = new TouchAction(driver).tap(PointOption.point(210,190)).release();
        touchAction.perform();
        Thread.sleep(500);

        // Ingresando nueva direccion
        MobileElement txtBusqueda = driver.findElement(By.id("com.upc.movil:id/places_autocomplete_search_bar"));
        txtBusqueda.click();
        txtBusqueda.sendKeys("tottus santa anita");
        txtBusqueda.click();
        Thread.sleep(500);

        // Seleccionar direccion
        touchAction = new TouchAction(driver).tap(PointOption.point(90,360)).release();
        touchAction.perform();
        Thread.sleep(5000);

        // Confirmar direccion
        touchAction = new TouchAction(driver).tap(PointOption.point(740,1350)).release();
        touchAction.perform();
        Thread.sleep(2000);

        // Mover de la ubicacion actual, hacia una nueva ubicacion
        /*TouchAction touchAction = new TouchAction(driver)
                .press(PointOption.point(540,530))
                .moveTo(PointOption.point(540,530));
                //tap(PointOption.point(540,530)).release();
        touchAction.perform();
        Thread.sleep(2000);*/

        // Ingresando producto
        MobileElement txtProducto = driver.findElement(By.id("com.upc.movil:id/etProducto"));
        txtProducto.click();
        txtProducto.sendKeys("leche");
        Thread.sleep(2000);
        touchAction = new TouchAction(driver).tap(PointOption.point(340,250)).release();
        touchAction.perform();
        Thread.sleep(2000);

        MobileElement txtTipoProducto = driver.findElement(By.id("com.upc.movil:id/etTipoProducto"));
        System.out.println("Producto seleccionado : " + txtProducto.getText());
        System.out.println("Tipo de Producto seleccionado : " + txtTipoProducto.getText());
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(200);

        // Ingresando cantidad
        MobileElement txtCantidad = driver.findElement(By.id("com.upc.movil:id/etCantProducto"));
        txtCantidad.click();
        txtCantidad.sendKeys("20");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(200);

        // Seleccionando tipo Caja de 24
        MobileElement cboPeso = driver.findElementByXPath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Spinner[1]/android.widget.CheckedTextView");
        cboPeso.click();
        driver.pressKey(new KeyEvent(AndroidKey.PAGE_DOWN));
        driver.pressKey(new KeyEvent(AndroidKey.PAGE_DOWN));
        driver.pressKey(new KeyEvent(AndroidKey.PAGE_DOWN));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(200);

        // Seleccionando fecha de vencimiento
        MobileElement txtFechaVencimiento = driver.findElement(By.id("com.upc.movil:id/etFechaVencimiento"));
        txtFechaVencimiento.click();
        Thread.sleep(2000);
        MobileElement fechaSelecElement = driver.findElementByXPath("//android.view.View[@content-desc=\"27 noviembre 2020\"]\n");
        fechaSelecElement.click();
        Thread.sleep(200);
        MobileElement btnAceptar = driver.findElement(By.id("android:id/button1"));
        btnAceptar.click();
        Thread.sleep(200);

        // Ingrsando alguna descripcion u observacion
        MobileElement txtDescDonacion = driver.findElement(By.id("com.upc.movil:id/etDescDonacion"));
        txtDescDonacion.sendKeys("PRUEBA AUTOMATIZADA");

        MobileElement btnRegistrarDonacion = driver.findElement(By.id("com.upc.movil:id/btnRegistrarDonacion"));
        btnRegistrarDonacion.click();

        Thread.sleep(3000);

        System.out.println("Registro exitoso de nueva donacion");
        btnAceptar = driver.findElement(By.id("android:id/button1"));
        btnAceptar.click();

        System.out.println("Prueba automatizada finalizada...");

    }

}
