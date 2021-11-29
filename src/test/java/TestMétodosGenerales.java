import com.cajanegra.EmptyCollectionException;
import com.practica.cajablanca.Editor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMétodosGenerales {
    @Test
    void testLeerFicheroCP1(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionUnElem.txt");
        String l1 = null;
        try {
            l1 = editor.getLinea(1).toString();
        }catch (EmptyCollectionException e){
            System.out.println("Error");
        };
        assertEquals("[A]",l1);
    }
    @Test
    void testLeerFicheroCP2(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionVariosElem.txt");
        String l1 = null;
        String l2 = null;
        try {
            l1 = editor.getLinea(1).toString();
            l2 = editor.getLinea(2).toString();
        }catch (EmptyCollectionException e){
            System.out.println("Error");
        };
        assertEquals("[A]",l1);
        assertEquals("[B]",l2);
    }
    @Test
    void testSizeCP1(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionUnElem.txt");
        assertEquals(1,editor.size());
    }
    @Test
    void testSizaCP2(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionVariosElem.txt");
        assertEquals(2,editor.size());
    }
    @Test
    void testSizaCP3(){
        Editor editor= new Editor();
        assertEquals(0,editor.size());
    }
    @Test
    void testEditorIsEmptyCP1(){
        Editor editor= new Editor();
        assertEquals(true,editor.editIsEmpty());
    }
    @Test
    void testEditorIsEmptyCP2(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionUnElem.txt");
        assertEquals(false,editor.editIsEmpty());
    }
    @Test
    void testGetLineaCP1(){
        Editor editor= new Editor();
        assertThrows(EmptyCollectionException.class,()->{editor.getLinea(1);});
    }
    @Test
    void testGetLineaCP2(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionUnElem.txt");
        assertThrows(IllegalArgumentException.class,()->{editor.getLinea(-1);});
    }
    @Test
    void testGetLineaCP3(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionUnElem.txt");
        assertThrows(IllegalArgumentException.class,()->{editor.getLinea(125);});
    }
    @Test
    void testGetLineaCP4(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionUnElem.txt");
        String l1=null;
        try {
            l1 = editor.getLinea(1).toString();
        }catch (EmptyCollectionException e){
            System.out.println("Error");
        };
        assertEquals("[A]",l1);
    }




}
