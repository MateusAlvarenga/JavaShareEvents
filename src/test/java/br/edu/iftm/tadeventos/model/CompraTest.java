package br.edu.iftm.tadeventos.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Rafael
 */
public class CompraTest {
    
    private Compra compra;
    
    @Mock
    private Evento evento;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        compra = new Compra();
    }

    @Test
    public void testAddQuantidade() {
        when(evento.getPrecoEntrada()).thenReturn(25.0);   
        
        compra.setEvento(evento);
        compra.setQuantidade(1);
        compra.addQuantidade();
        
        assertEquals(compra.getTotal(), 50.0, 0);
        assertEquals(compra.getQuantidade(), 2);
    }
    
}
