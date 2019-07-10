package bbs.bbs.model.dto;

public class BbsDTO {
	private String loginId;
	private String password;
	private String title;
	private String content;
	private String idx;
	
	private String contentIdx;
	private String replyContent;
	
	
	
	public String getContentIdx() {
		return contentIdx;
	}
	public void setContentIdx(String contentIdx) {
		this.contentIdx = contentIdx;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
