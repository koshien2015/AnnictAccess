package cx.myhome.ckoshien.annict.task;

import java.util.HashMap;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import cx.myhome.ckoshien.annict.dto.LoginDto;
import cx.myhome.ckoshien.annict.rest.RestClient;
import cx.myhome.ckoshien.annict.rest.dto.AnnictAuthorizeDto;
import cx.myhome.ckoshien.annict.rest.dto.UserDto;
import cx.myhome.ckoshien.annict.util.MemoryUtil;

public class AnnictCallTask implements Callable<String>{
	private static Logger logger = Logger.getLogger("rootLogger");
	private LoginDto loginDto;
	public AnnictCallTask(LoginDto loginDto){
		this.loginDto=loginDto;
	}


	@Override
	public String call(){
		logger.info("タスク開始");
		RestClient client = new RestClient();
		String uri = "https://api.annict.com/v1/me?access_token="+loginDto.getAccess_token();
		HashMap<String, String> header= new HashMap<String, String>();
		AnnictAuthorizeDto entity= new AnnictAuthorizeDto();
		entity=null;
		UserDto json2=client.sendRequest(uri, "GET", entity, UserDto.class,header);
		String username=json2.getName()+"(@"+json2.getUsername()+")";
		logger.info(username);
		MemoryUtil.viewMemoryInfo();
		return null;
	}
}
