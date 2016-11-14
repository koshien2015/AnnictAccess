package cx.myhome.ckoshien.annict.rest.dto;

import java.util.Date;
import java.util.HashMap;

public class ProgramsDto {
	private Integer id;
	private Date started_at;
	private boolean is_rebroadcast;
	private HashMap<String,Object> channel;
	private HashMap<String,Object> work;
	private HashMap<String,Object> episode;
	private long dayDiff;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getStarted_at() {
		return started_at;
	}
	public void setStarted_at(Date started_at) {
		this.started_at = started_at;
	}
	public boolean isIs_rebroadcast() {
		return is_rebroadcast;
	}
	public void setIs_rebroadcast(boolean is_rebroadcast) {
		this.is_rebroadcast = is_rebroadcast;
	}
	public HashMap<String, Object> getChannel() {
		return channel;
	}
	public void setChannel(HashMap<String, Object> channel) {
		this.channel = channel;
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
	public long getDayDiff() {
		return dayDiff;
	}
	public void setDayDiff(long dayDiff) {
		this.dayDiff = dayDiff;
	}
}
