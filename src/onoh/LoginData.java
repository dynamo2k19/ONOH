/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onoh;

/**
 *
 * @author rishu
 */
public class LoginData {
    static String hid;
    
    LoginData(String id)
    {
        hid = id;
    }
    
    LoginData()
    {
        //hid = "ID99887766";     //hospital
        //hid = "ID11223344";   //user
        hid = "ID00998877";   //store
    }
}
