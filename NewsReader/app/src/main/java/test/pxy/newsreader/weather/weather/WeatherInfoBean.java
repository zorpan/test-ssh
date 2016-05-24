package test.pxy.newsreader.weather.weather;

public class WeatherInfoBean {

	private String date;
	private String high;
	private String low;
	private InfoBean day;
	private InfoBean night;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public InfoBean getDay() {
		return day;
	}
	public void setDay(InfoBean day) {
		this.day = day;
	}
	public InfoBean getNight() {
		return night;
	}
	public void setNight(InfoBean night) {
		this.night = night;
	}
	@Override
	public String toString() {
		return "WeatherInfoBean [date=" + date + ", high=" + high + ", low=" + low + ", day=" + day + ", night=" + night
				+ "]";
	}
}
