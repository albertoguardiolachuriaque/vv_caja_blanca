import com.cajanegra.EmptyCollectionException;
import com.practica.cajablanca.Editor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMetodosGenerales {
    @Test
    void testLeerFicheroUnElem(){
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
    void testLeerFicheroVariosElem(){
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
    void testSizeUnElem(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionUnElem.txt");
        assertEquals(1,editor.size());
    }
    @Test
    void testSizeVariosElem(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionVariosElem.txt");
        assertEquals(2,editor.size());
    }
    @Test
    void testSizeNoElem(){
        Editor editor= new Editor();
        assertEquals(0,editor.size());
    }
    @Test
    void testEditorIsEmptyVacio(){
        Editor editor= new Editor();
        assertEquals(true,editor.editIsEmpty());
    }
    @Test
    void testEditorIsEmptyNoVacio(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionUnElem.txt");
        assertEquals(false,editor.editIsEmpty());
    }
    @Test
    void testGetLineaVacia(){
        Editor editor= new Editor();
        assertThrows(EmptyCollectionException.class,()->{editor.getLinea(1);});
    }
    @Test
    void testGetLineaNegativa(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionUnElem.txt");
        assertThrows(IllegalArgumentException.class,()->{editor.getLinea(-1);});
    }
    @Test
    void testGetLineaAlta(){
        Editor editor= new Editor();
        editor.leerFichero("ConfiguracionUnElem.txt");
        assertThrows(IllegalArgumentException.class,()->{editor.getLinea(125);});
    }
    @Test
    void testGetLineaValida(){
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
    @Test
    void testNumPalabrasVacio(){
        Editor editor= new Editor();
        assertThrows(EmptyCollectionException.class,()->{editor.numPalabras();});
    }
    @Test
    void testNumPalabrasUna(){
        Editor editor= new Editor();
        int l1=0;
        editor.leerFichero("ConfiguracionUnElem.txt");
        try {
            l1 = editor.numPalabras();
        }catch (EmptyCollectionException e){
            System.out.println("Error");
        };
        assertEquals(1,l1);
    }
    @Test
    void testNumPalabrasVarias(){
        Editor editor= new Editor();
        int l1=0;
        editor.leerFichero("ConfiguracionVariosElem.txt");
        try {
            l1 = editor.numPalabras();
        }catch (EmptyCollectionException e){
            System.out.println("Error");
        };
        assertEquals(2,l1);
    }




}
