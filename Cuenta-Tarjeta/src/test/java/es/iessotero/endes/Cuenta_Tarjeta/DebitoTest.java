package es.iessotero.endes.Cuenta_Tarjeta;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DebitoTest {

    @Test
    public void testRetirar() throws Exception {
        Cuenta cuenta = new Cuenta("123456789", "John Doe");
        cuenta.ingresar(1000);
        
        Debito debito = new Debito("987654321", "John Doe", new Date());
        debito.setCuenta(cuenta);
        
        debito.retirar(500); 

        assertEquals(500, cuenta.getSaldo(), 0.001);
    }

    @Test
    public void testIngresar() throws Exception {
        Cuenta cuenta = new Cuenta("123456789", "John Doe");
        cuenta.ingresar(1000);
        
        Debito debito = new Debito("987654321", "John Doe", new Date());
        debito.setCuenta(cuenta);
        
        debito.ingresar(200); 
        

        assertEquals(1200, cuenta.getSaldo(), 0.001);
    }

    @Test
    public void testPagoEnEstablecimiento() throws Exception {

        Cuenta cuenta = new Cuenta("123456789", "John Doe");
        cuenta.ingresar(1000);
        
        Debito debito = new Debito("987654321", "John Doe", new Date());
        debito.setCuenta(cuenta);
     
        debito.pagoEnEstablecimiento("Tienda XYZ", 300); 
        assertEquals(700, cuenta.getSaldo(), 0.001); 
    }

    @Test
    public void testGetSaldo() throws Exception {

        Cuenta cuenta = new Cuenta("123456789", "John Doe");
        cuenta.ingresar(1500);
        
        Debito debito = new Debito("987654321", "John Doe", new Date());
        debito.setCuenta(cuenta);

        assertEquals(1500, debito.getSaldo(), 0.001);
    }
}