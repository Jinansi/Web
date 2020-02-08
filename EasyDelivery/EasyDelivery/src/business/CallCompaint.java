/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Call;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Renu
 */
public class CallCompaint {
     public static final String ACCOUNT_SID = "AC2af0cafffe8b0ba585bc789564a82f52"; 
 public static final String AUTH_TOKEN = "3d9608c0db33177c2b815de986f09738"; 
 
 public void initiateCall() throws TwilioRestException{
     TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
 
	// Build the parameters 
	List<NameValuePair> params = new ArrayList<NameValuePair>(); 
	params.add(new BasicNameValuePair("To", "6314825267")); 
	params.add(new BasicNameValuePair("From", "+16312573719"));
	params.add(new BasicNameValuePair("Url", "https://demo.twilio.com/welcome/voice/"));  
	params.add(new BasicNameValuePair("Method", "GET"));  
	params.add(new BasicNameValuePair("FallbackMethod", "GET"));  
	params.add(new BasicNameValuePair("StatusCallbackMethod", "GET"));    
	params.add(new BasicNameValuePair("Record", "false")); 
 
	CallFactory callFactory = client.getAccount().getCallFactory(); 
	Call call = callFactory.create(params); 
 }
 public static void main(String[]args) throws TwilioRestException { 
     
 } 
}
