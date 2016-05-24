package test.pxy.newsreader.weather.weather;

public class InfoBean {
	private String type;
	private String fengxiang;
	private String fengli;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFengxiang() {
		return fengxiang;
	}
	public void setFengxiang(String fengxiang) {
		this.fengxiang = fengxiang;
	}
	public String getFengli() {
		return fengli;
	}
	public void setFengli(String fengli) {
		this.fengli = fengli;
	}
	@Override
	public String toString() {
		return "InfoBean [type=" + type + ", fengxiang=" + fengxiang + ", fengli=" + fengli + "]";
	}
}
