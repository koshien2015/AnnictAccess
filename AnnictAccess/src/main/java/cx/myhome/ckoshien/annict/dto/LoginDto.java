package cx.myhome.ckoshien.annict.dto;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

@Component(instance = InstanceType.SESSION)
public class LoginDto implements Serializable{
	private static final long serialVersionUID = -2905338599040084095L;
	private String access_token;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

}
