import com.cajanegra.EmptyCollectionException;
import com.practica.cajablanca.Editor;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCajaBlanca {
    @Test
    public void testSustituirPalabrasCP1(){
        Editor lista= new Editor();
        lista.sustituirPalabra("A","Z");
        assertEquals(true,lista.editIsEmpty());
    }
    @Test
    public void testSustituirPalabrasCP3(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionUnElem.txt");
        editor.sustituirPalabra("A","Z");
        String l1 = null;
        try {
            l1 = editor.getLinea(1).toString();
        }catch (Exception e){
            System.out.println("Error");
        };
        assertEquals("[Z]",l1);
    }
    @Test
    public void testSustituirPalabrasCP4(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionUnElem.txt");
        editor.sustituirPalabra("B","Z");
        String l1 = null;
        try {
            l1 = editor.getLinea(1).toString();
        }catch (EmptyCollectionException e){
            System.out.println("Error");
        };
        assertEquals("[A]",l1);
    }
    @Test
    public void testSustituirPalabrasCP5(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionVariosElem.txt");
        editor.sustituirPalabra("A","Z");
        String l1 = null;
        String l2 = null;
        try {
            l1 = editor.getLinea(1).toString();
            l2 = editor.getLinea(2).toString();
        }catch (EmptyCollectionException e){
            System.out.println("Error");
        };
        assertEquals("[Z]",l1);
        assertEquals("[B]",l2);
    }
    @Test
    public void testMayorLongitudCP1(){
        Editor editor=new Editor();
        String L= null;
        try {
            L = editor.mayorLongitud();
        }catch (EmptyCollectionException e){
            System.out.println("Error");
        }
        assertEquals(null,L,"El método devuelve: "+ L +", en vez de null");

    }
    @Test
    public void testMayorLongitudCP4(){
        Editor editor=new Editor();
        editor.leerFichero("ConfiguracionUnElem.txt");
        String L= null;
        try {
            L = editor.mayorLongitud();
        }catch (EmptyCollectionException e){
            System.out.println("Error");
        }
        assertEquals("A",L,"El método devuelve: "+ L +", en vez de A");
    }
    @Test
    public void testMayorLongitudCP5(){
        Editor editor=new Editor();
        editor.leerFichero("ConfiguracionCasoPrueba5_MayorLongitud.txt");
        String L= null;
        try {
            L = editor.mayorLongitud();
        }catch (EmptyCollectionException e){
            System.out.println("Error");
        }
        assertEquals("AB",L,"El método devuelve: "+ L +", en vez de AB");
    }
    @Test
    public void testMayorLongitudCP6(){
        Editor editor=new Editor();
        editor.leerFichero("ConfiguracionCasoPrueba6_MayorLongitud.txt");
        String L= null;
        try {
            L = editor.mayorLongitud();
        }catch (EmptyCollectionException e){
            System.out.println("Error");
        }
        assertEquals("AB",L,"El método devuelve: "+ L +", en vez de AB");
    }
    @Nested
    public class numPalabrasTest{
        @Test
        public void testNumPalabrasCP1(){
            Editor editor = new Editor();
            editor.leerFichero("NumPalabrasVacio.txt");
            try {
                assertThrows(IllegalArgumentException.class, () -> {
                    editor.numPalabras(0, 1, "California");
                });
            }
            catch (IllegalArgumentException e){
                System.out.println("Error");
            }
        }
        @Test
        public void testNumPalabrasCP2(){
            Editor editor = new Editor();
            editor.leerFichero("NumPalabras1.txt");
            int numPalabras = -1;
            try {
                assertThrows(IllegalArgumentException.class, () -> {
                    editor.numPalabras(1, editor.size() + 1, "California");
                });
            }
            catch (IllegalArgumentException e){
                System.out.println("Error");
            }
        }
        @Test
        public void testNumPalabrasCP3(){
            Editor editor = new Editor();
            editor.leerFichero("NumPalabrasVacio.txt");
            int numPalabras = 0;
            try {
                numPalabras = editor.numPalabras(1, 0 , "California");
            }
            catch (IllegalArgumentException e){
                System.out.println("Error");
            }
            finally{
                assertEquals(0, numPalabras, "El método devuelve " + numPalabras);
            }
        }
        @Test
        public void testNumPalabrasCP4(){
            Editor editor = new Editor();
            editor.leerFichero("NumPalabras1.txt");
            int numPalabras = 0;
            try {
                numPalabras = editor.numPalabras(2, 1 , "California");
            }
            catch (IllegalArgumentException e){
                System.out.println("Error");
            }
            finally{
                assertEquals(0, numPalabras, "El método devuelve " + numPalabras);
            }
        }
        @Test
        public void testNumPalabrasCP5(){
            Editor editor = new Editor();
            editor.leerFichero("NumPalabras1.txt");
            int numPalabras = 0;
            try {
                numPalabras = editor.numPalabras(1, 2 , "California");
            }
            catch (IllegalArgumentException e){
                System.out.println("Error");
            }
            finally{
                assertEquals(0, numPalabras, "El método devuelve " + numPalabras);
            }
        }
        @Test
        public void testNumPalabrasCP6(){
            Editor editor = new Editor();
            editor.leerFichero("NumPalabras1.txt");
            int numPalabras = 0;
            try {
                numPalabras = editor.numPalabras(1, 2 , "Alabama");
            }
            catch (IllegalArgumentException e){
                System.out.println("Error");
            }
            finally{
                assertEquals(1, numPalabras, "El método devuelve " + numPalabras);
            }
        }
    }

}
