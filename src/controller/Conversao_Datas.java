package controller;

import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
 
public class Conversao_Datas{
 
    public static void main(String[] args) throws ParseException{
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
      
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dats = sdf.parse("12/01/1995") ;
        System.out.println("Data formatada: "+sdf.format(data));
        if (data.before(dats)) {
        	System.out.print("Já Passou");
        }else {
        	System.out.print("Ainda não passou");
        }
    }
}