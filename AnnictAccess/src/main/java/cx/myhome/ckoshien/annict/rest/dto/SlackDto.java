package cx.myhome.ckoshien.annict.rest.dto;

public class SlackDto {
	private String channnel;
	private String username;
	private String text;
	private String icon_url;
	private String icon_emoji;

	public String getChannnel() {
		return channnel;
	}
	public void setChannnel(String channnel) {
		this.channnel = channnel;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIcon_url() {
		return icon_url;
	}
	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}
	public String getIcon_emoji() {
		return icon_emoji;
	}
	public void setIcon_emoji(String icon_emoji) {
		this.icon_emoji = icon_emoji;
	}

}
