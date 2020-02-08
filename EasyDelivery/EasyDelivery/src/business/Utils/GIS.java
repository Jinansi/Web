/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Utils;


import business.Person.Address;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * @author Gunjan
 */
public class GIS 
{
    private static final String GOOGLEAPIBASELINK = "http://maps.googleapis.com/maps/api/distancematrix/json?";
    
    public GIS() 
    {
        
    }
    
    public static Double getDistance(Address origin, Address destination)
    {
        
        try
        {
        String originString = (origin.getAddressline1()+","+origin.getCity()+","+origin.getState()+","+origin.getCountry());
        String destinationString =(destination.getAddressline1()+","+destination.getCity()+","+destination.getState()+","+destination.getCountry());

        String response = getJsonResponse(originString,destinationString);
        Double result = parseJsonFileForDistance(response);

            return result;
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Sorry, No address found");
        }
        return 10000.0;
    }
    
      //To get all response Data
    public static String getJsonResponse(String origin, String destination)
    {
        //Final Url to be Pinged is generated
        String address = buildUrl(origin,destination);
        
        //Return
        String content = null;

        try
        {
            URL url = new URL(address);

            try
            (InputStream stream = url.openStream()) {
                int available = stream.available();

                byte[] bytes = new byte[available];

                stream.read(bytes);

                content = new String(bytes);
            }

            return (String) content.toString();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    //To generate the format accepted by Google API 
    public static String buildUrl(String origin,String destination)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(GOOGLEAPIBASELINK);
        builder.append("origins=");
        builder.append(origin.replaceAll(" ", "+"));
        builder.append("&destinations=");
        builder.append(destination.replaceAll(" ", "+"));
        builder.append("&mode=driving&units=imperial&language=En&sensor=false");
        //System.out.println(builder.toString());
        return builder.toString();
    }

    public static Double parseJsonFileForDistance(String response)
    {
        String[] lines = response.split("\n");
        Double dist=0.0;

        for (int i = 0; i < lines.length; i++)
        {
            if ("\"distance\" : {".equals(lines[i].trim()))
            {
                dist = getOrdinate(lines[i+1]);
                break;
            }
        }

        return dist;
    }

    public static Double getOrdinate(String s)
    {
        String[] split = s.trim().split(" ");
       
        if (split.length < 1)
        {
            return null;
        }

        String ord = split[2];
       
        // Check that the result is a valid double
        String ord1=ord.replaceAll(",", "");
        String ord2=ord1.replaceAll("\"", "");
        Double d=Double.parseDouble(ord2);
        return d;
    }
    
}
