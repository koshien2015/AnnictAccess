package cx.myhome.ckoshien.annict.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import cx.myhome.ckoshien.annict.form.UserForm;
import cx.myhome.ckoshien.annict.rest.RestClient;
import cx.myhome.ckoshien.annict.rest.dto.ActivityDto;
import cx.myhome.ckoshien.annict.rest.dto.Result2Dto;
import net.arnx.jsonic.JSON;


public class UserAction {
	@Resource
	@ActionForm
	private UserForm userForm;
	public String json2;
	public Result2Dto result2Dto;
	public List<ActivityDto> list;

	@Execute(urlPattern="{username}",validator = false)
	public String user() {
		HashMap<Long, Integer> records= new HashMap<Long, Integer>();
		list=new ArrayList<ActivityDto>();
		for(int i=1;i<25;i++){
			String uri = "https://annict.com/api/internal/activities?page="+i+"&username="+userForm.username;
			RestClient client = new RestClient();
			HashMap<String, String> header= new HashMap<String, String>();
			String entity=null;
			Result2Dto json=client.sendRequest(uri, "GET", entity, Result2Dto.class,header);
			result2Dto=new Result2Dto();
			if(json!=null){
				for(int j=0;j<json.getActivities().size();j++){
					if(json.getActivities().get(j).getAction().equals("create_record")){
						list.add(json.getActivities().get(j));
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						//String dateStr="";
						Date date=null;
						try {
							date = sdf.parse(json.getActivities().get(j).getCreated_at().toString());
						} catch (Exception e) {
							e.printStackTrace();
						}
						long time=date.getTime()/1000;
						if(records.containsKey(time)){
							records.put(time, records.get(time)+1);
						}else{
							records.put(time,1);
						}
					}
				}
			}else{
				break;
			}
			System.out.println(i);
		}
		for (Iterator<Integer> i = records.values().iterator(); i.hasNext();) {
			if (i.next().intValue()==0) {
				  i.remove();
			}
		}

		json2=JSON.encode(records);

		return "index.jsp";
	}
}
