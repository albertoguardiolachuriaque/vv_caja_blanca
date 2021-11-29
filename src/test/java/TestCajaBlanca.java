import com.cajanegra.EmptyCollectionException;
import com.practica.cajablanca.Editor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
