package test.pxy.newsreader.weather.weather;

public class EnvironmentBean {

	private String aqi;
	private String pm25;
	private String suggest;
	private String quality;
	private String MajorPollutants;
	public String getAqi() {
		return aqi;
	}
	public void setAqi(String aqi) {
		this.aqi = aqi;
	}
	public String getPm25() {
		return pm25;
	}
	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}
	public String getSuggest() {
		return suggest;
	}
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getMajorPollutants() {
		return MajorPollutants;
	}
	public void setMajorPollutants(String majorPollutants) {
		MajorPollutants = majorPollutants;
	}
	@Override
	public String toString() {
		return "EnvironmentBean [aqi=" + aqi + ", pm25=" + pm25 + ", suggest=" + suggest + ", quality=" + quality
				+ ", MajorPollutants=" + MajorPollutants + "]";
	}
	
}
