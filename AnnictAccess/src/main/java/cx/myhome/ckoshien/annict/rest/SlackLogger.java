package cx.myhome.ckoshien.annict.rest;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.seasar.framework.util.ResourceUtil;

import cx.myhome.ckoshien.annict.rest.dto.SlackDto;

public class SlackLogger {
	static Logger logger = Logger.getLogger("rootLogger");

	public void info(Object message) {
		RestClient client = new RestClient();
		String uri=ResourceUtil.getProperties("config.properties").getProperty("SLACK_URI");
		HashMap<String, String> header= new HashMap<String, String>();
		SlackDto entity=new SlackDto();
		entity.setText(message.toString());
		entity.setUsername("AnnictAccessBot");
		String json=client.sendRequest(uri, "POST", entity, String.class,header);
		logger.info(json);
	}

}
