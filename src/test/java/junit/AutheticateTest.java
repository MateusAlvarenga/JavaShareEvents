package junit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.iftm.tadeventos.util.Authenticator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author informatica
 */
public class AutheticateTest {
    
    public AutheticateTest() {
    }
    
    @Test
    public void Test_CorrectUser(){
        String login_teste = "admin3";
        String pass_teste = "123456";      
        
        Authenticator authenticator = new Authenticator();
        String response = authenticator.authenticate(login_teste, pass_teste);        
        Assert.assertEquals("success", response);
        
    }
    
    @Test
    public void Test_WrongUser(){
        String login_teste = "haudskembrithkestrobilobaldofhacasFaustaoskbatman##d";
        String pass_teste = "aieulAminoacidosfjsdlkasd@@alfafaljslidjfaklmseleniumcasdça";      
        
        Authenticator authenticator = new Authenticator();
        String response = authenticator.authenticate(login_teste, pass_teste);        
        Assert.assertEquals("failure", response);
        
    }
    
}
