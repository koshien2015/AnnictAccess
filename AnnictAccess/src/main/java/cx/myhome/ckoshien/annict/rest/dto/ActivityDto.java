package cx.myhome.ckoshien.annict.rest.dto;

import java.sql.Timestamp;
import java.util.HashMap;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.junit.Ignore;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ActivityDto {
	private String action;
	private Timestamp created_at;
	private HashMap<String,Object> work;
	private HashMap<String,Object> episode;
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public HashMap<String, Object> getWork() {
		return work;
	}
	public void setWork(HashMap<String, Object> work) {
		this.work = work;
	}
	public HashMap<String, Object> getEpisode() {
		return episode;
	}
	public void setEpisode(HashMap<String, Object> episode) {
		this.episode = episode;
	}

}
