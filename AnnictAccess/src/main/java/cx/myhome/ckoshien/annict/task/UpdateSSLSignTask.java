package cx.myhome.ckoshien.annict.task;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.seasar.chronos.core.annotation.task.Task;
import org.seasar.chronos.core.annotation.trigger.CronTrigger;

@Task
@CronTrigger(expression = "0 0 13 * * ?")
//@NonDelayTrigger
public class UpdateSSLSignTask {
	private static Logger logger = Logger.getLogger("rootLogger");
	public void doExecute() {
		String[] strs = new String[1];
		strs[0]="api.annict.com:443";
		InstallCert certLogic=new InstallCert();
		try {
			certLogic.main(strs);
		} catch (Exception e) {
			logger.error(e);
			//e.printStackTrace();
		}
	}
}
