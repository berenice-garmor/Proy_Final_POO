package controllers;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Login
{
    private Scanner sc;
    
    public void leerTxt()
    {
        try
        {
            sc = new Scanner (new File("C:\\Users\\Hp\\Documents\\CETYS\\POO\\uc\\list.txt"));
        }
        catch(Exception e)
        {
            System.out.println("No se encontro el archivo");
        }
    }
    
    public boolean validar(String usuario, String contraseña)
    {
        leerTxt();
        boolean valid=false;//esta variable solo valida que un user o pass existan 
        boolean val=false;//esta variable es la que va a validar abrir el otro form osea que user y pass solo sean correctos
        
        try
        {
            while(sc.hasNextLine())//mientras siga habiendo texto en la linea 
            {
                try
                {
                    String linea = sc.nextLine();
                    int u = (linea.indexOf(",")+1);//te da el index de la coma
                    
                    if(linea.contains(usuario))//si la linea contine el user
                    {
                      String pass = (linea.substring(u,linea.length())); //obtener el password
                      val=true;
                      
                      if (contraseña.equals(pass))//si txtContraseña = a lo del txtList
                      {
                        valid=true;//la contraseña es correcta
                        val=true;//la contra es correcta para abrir el form
                        JOptionPane.showMessageDialog(null, "Usuario valido");
                        break;
                      }
                      else
                      {
                          valid=true;//contraseña incorrecta pero el user si existe
                          val=false;//contra incorrecta no abre el form
                          JOptionPane.showMessageDialog(null, "contraseña incorrecta");
                          break;
                      }
                    }
                    else//si la linea no contiene el user no existe el user
                    {
                        valid=false;   
                    }
                    
                }
                catch(Exception ex)
                {
                  System.out.println(ex.getMessage());
                }
            }
            if(!valid)// si la varibale valid quedo en false entonces el user no existe
            {
              //System.out.println(valid);
              JOptionPane.showMessageDialog(null, "el usuario no existe");
            }
            
        }
        catch(Exception exc)
        {
            System.out.println(exc.getMessage());
        }
        
        return val;//lo que se va a gregresar para validar abrir el sig. form
 }
    
   
    
    public boolean valida(String usuario, String contraseña)
    {
        leerTxt();
        boolean valid=false;
        
        
            while(sc.hasNextLine())
            {
                try
                {
                    String linea = sc.nextLine();
                    int u = (linea.indexOf(",")+1);
                    
//                    int coma = (linea.lastIndexOf(","));
//                    String user= (linea.substring(0, coma));
//                    System.out.println(user);
                    
                    if(linea.contains(usuario)&&linea.contains(contraseña))
                    {
                      String pass = (linea.substring(u)); 
                      //System.out.println(pass);

                        valid=true;
                        JOptionPane.showMessageDialog(null, "Usuario valido");
                        break;
                    }
                      else
                      {
                          valid=false;
                          JOptionPane.showMessageDialog(null, "contraseña incorrecta");
                          break;
                      }
                }
                catch(Exception ex)
                {
                  System.out.println(ex.getMessage());
                }
            }
        
        return valid;
    }
}