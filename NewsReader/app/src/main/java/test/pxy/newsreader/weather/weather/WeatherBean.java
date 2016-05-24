package test.pxy.newsreader.weather.weather;

import java.util.List;

public class WeatherBean {
	private String place;
	private String updatetime;
	private String wendu;
	private String fengli;
	private String shidu;
	private String fengxiang;
	private String sunrise_1;
	private String sunset_1;
	private EnvironmentBean eb;
	private List<WeatherInfoBean>weathers;
	private List<ZhishuBean>zhishus;
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getWendu() {
		return wendu;
	}
	public void setWendu(String wendu) {
		this.wendu = wendu;
	}
	public String getFengli() {
		return fengli;
	}
	public void setFengli(String fengli) {
		this.fengli = fengli;
	}
	public String getShidu() {
		return shidu;
	}
	public void setShidu(String shidu) {
		this.shidu = shidu;
	}
	public String getFengxiang() {
		return fengxiang;
	}
	public void setFengxiang(String fengxiang) {
		this.fengxiang = fengxiang;
	}
	public String getSunrise_1() {
		return sunrise_1;
	}
	public void setSunrise_1(String sunrise_1) {
		this.sunrise_1 = sunrise_1;
	}
	public String getSunset_1() {
		return sunset_1;
	}
	public void setSunset_1(String sunset_1) {
		this.sunset_1 = sunset_1;
	}
	public EnvironmentBean getEb() {
		return eb;
	}
	public void setEb(EnvironmentBean eb) {
		this.eb = eb;
	}
	public List<WeatherInfoBean> getWeathers() {
		return weathers;
	}
	public void setWeathers(List<WeatherInfoBean> weathers) {
		this.weathers = weathers;
	}
	public List<ZhishuBean> getZhishus() {
		return zhishus;
	}
	public void setZhishus(List<ZhishuBean> zhishus) {
		this.zhishus = zhishus;
	}
	@Override
	public String toString() {
		return "城市：" + place + "\n更新时间：" + updatetime + "\n温度：" + wendu + "\n风力：" + fengli
				+ "\n湿度：" + shidu + "\n风向：" + fengxiang + "\n日落时间：" + sunrise_1 + "\n日出时间："
				+ sunset_1 + "\neb=" + eb + ", weathers=" + weathers + ", zhishus=" + zhishus + "]";
	}
}
