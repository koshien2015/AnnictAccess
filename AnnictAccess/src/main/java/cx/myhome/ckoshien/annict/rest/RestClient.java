package cx.myhome.ckoshien.annict.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import net.arnx.jsonic.JSON;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestClient {
	public Client getClient() {
		ClientConfig config = new DefaultClientConfig();
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);//この設定をすることで　JSON　を　POJO　にパースできる
		Client client = Client.create(config);
		return client;
	}

	@SuppressWarnings("finally")
	public <E> E sendRequest(String uri,String method,Object requestEntity,Class<E> cls,HashMap<String,String> header){
		RestClient restClient=new RestClient();
		Client client=restClient.getClient();
		ClientRequest.Builder builder=ClientRequest.create();
		builder.type(MediaType.APPLICATION_JSON_TYPE);
		if(requestEntity!=null){
			//entityがnullでない場合は自動的にPOSTになってしまうため
			builder.entity(JSON.encode(requestEntity));
		}
		for(Map.Entry<String, String> entry : header.entrySet()) {
			builder.header(entry.getKey(), entry.getValue());
		}
		ClientRequest request;
		ClientResponse response = null;
		E json = null;
		try {
			request = builder.build(new URI(uri), method);
			response=client.handle(request);
			if(response.getStatus()==200){
				json=response.getEntity(cls);
			}else{
				System.out.println(response.getEntity(String.class));
			}
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}catch(Throwable e){
			e.printStackTrace();
		}finally{
			return json;
		}
	}
}
