/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package cx.myhome.ckoshien.annict.action;

import java.util.HashMap;

import javax.annotation.Resource;

import org.seasar.framework.util.ResourceUtil;
import org.seasar.struts.annotation.Execute;

import cx.myhome.ckoshien.annict.dto.LoginDto;
import cx.myhome.ckoshien.annict.rest.RestClient;
import cx.myhome.ckoshien.annict.rest.dto.AnnictAuthorizeDto;
import cx.myhome.ckoshien.annict.rest.dto.ResultDto;


public class IndexAction {
	public String code;
	public String result;
	public ResultDto resultDto;
	@Resource
	private LoginDto loginDto;
	private AnnictAuthorizeDto entity;
	private HashMap<String, String> header;
	private RestClient client;

    @Execute(validator = false)
	public String index() {
    	RestClient client = new RestClient();
		String uri = "https://api.annict.com/oauth/token";
		AnnictAuthorizeDto entity= new AnnictAuthorizeDto();
		HashMap<String, String> header= new HashMap<>();
		entity.setClient_id(ResourceUtil.getProperties("config.properties").getProperty("client_id"));
		entity.setRedirect_uri("http://localhost:8080/AnnictAccess");
		entity.setResponse_type("code");
		entity.setScope("read");
		entity.setClient_secret(ResourceUtil.getProperties("config.properties").getProperty("secret_key"));
		entity.setGrant_type("authorization_code");
		entity.setCode(code);
		AnnictAuthorizeDto json=client.sendRequest(uri, "POST", entity, AnnictAuthorizeDto.class,header);
		loginDto.setAccess_token(json.getAccess_token());
		return "/index2&redirect=true";
	}

    @Execute(validator = false)
    public String index2(){
    	String uri="https://api.annict.com/v1/me/programs?filter_unwatched=true&accessToken="+loginDto.getAccess_token();
    	header= new HashMap<>();
    	client = new RestClient();
    	header.put("Authorization", "Bearer "+loginDto.getAccess_token());
		entity=null;
		resultDto= new ResultDto();
		resultDto=client.sendRequest(uri, "GET", entity, ResultDto.class,header);
        return "index.jsp";
    }
}
