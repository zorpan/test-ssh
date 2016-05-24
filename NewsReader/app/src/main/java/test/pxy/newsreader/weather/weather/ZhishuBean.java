package test.pxy.newsreader.weather.weather;

public class ZhishuBean {

	private String name;
	private String value;
	private String detail;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "ZhishuBean [name=" + name + ", value=" + value + ", detail=" + detail + "]";
	}
}
