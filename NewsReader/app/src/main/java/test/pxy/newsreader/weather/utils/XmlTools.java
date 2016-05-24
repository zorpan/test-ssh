package test.pxy.newsreader.weather.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import test.pxy.newsreader.weather.weather.EnvironmentBean;
import test.pxy.newsreader.weather.weather.InfoBean;
import test.pxy.newsreader.weather.weather.WeatherBean;
import test.pxy.newsreader.weather.weather.WeatherInfoBean;
import test.pxy.newsreader.weather.weather.ZhishuBean;


public class XmlTools {

	public static WeatherBean parseXML(InputStream inputStream, String encode) throws Exception {

		List<WeatherInfoBean>weathers=null;
		List<ZhishuBean>zhishus = null;

		boolean flag = true;
		boolean flag1 = true;
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser paser = factory.newPullParser();
		
		paser.setInput(inputStream, encode);
		int evenType = paser.getEventType();
		InfoBean info = new InfoBean();
		WeatherBean weather = new WeatherBean();
		WeatherInfoBean wi = null;
		EnvironmentBean eb = new EnvironmentBean();
		ZhishuBean zhishu = new ZhishuBean();
		while (evenType != XmlPullParser.END_DOCUMENT) {
			switch (evenType) {
			case XmlPullParser.START_DOCUMENT:
				weathers = new ArrayList<>();
				zhishus = new ArrayList<>();
				break;
			case XmlPullParser.START_TAG:
				switch (paser.getName()) {
				case "city":
					weather.setPlace(paser.nextText());
					break;
				case "updatetime":
					weather.setUpdatetime(paser.nextText());
					break;
				case "wendu":
					weather.setWendu(paser.nextText());
					break;
				case "fengli":
					if (flag) {
						weather.setFengli(paser.nextText());
						flag = false;
					}else if(!flag){
						info.setFengli(paser.nextText());
					}
					break;
				case "fengxiang":
					if(flag1){
						weather.setFengxiang((paser.nextText()));
						flag1=false;
					}else if(!flag1){
						info.setFengxiang(paser.nextText());
					}
					break;
				case "shidu":
					weather.setShidu(paser.nextText());
					break;
				case "sunrise_1":
					weather.setSunrise_1(paser.nextText());
					break;
				case "sunset_1":
					weather.setSunset_1(paser.nextText());
					break;
				// environment
				case "aqi":
					eb.setAqi(paser.nextText());
					break;
				case "pm25":
					eb.setPm25(paser.nextText());
					break;
				case "suggest":
					eb.setSuggest(paser.nextText());
					break;
				case "quality":
					eb.setQuality(paser.nextText());
					break;
				case "MajorPollutants":
					eb.setMajorPollutants(paser.nextText());
					break;
				// forecast
				case "weather":
					wi = new WeatherInfoBean();
					break;
				case "date":
					wi.setDate(paser.nextText());
					break;
				case "high":
					wi.setHigh(paser.nextText());
					break;
				case "low":
					wi.setLow(paser.nextText());
					break;
				case "type":
					info.setType(paser.nextText());
					break;
				//zhishu
				case "name":
					zhishu.setName(paser.nextText());
					break;
				case "value":
					zhishu.setValue(paser.nextText());
					break;
				case "detail":
					zhishu.setDetail(paser.nextText());
					break;
				}
				break;
			case XmlPullParser.END_TAG:
				if ("day".equals(paser.getName())) {
					wi.setDay(info);
					info = new InfoBean();
				}else if("night".equals(paser.getName())){
					wi.setNight(info);
					info = new InfoBean();
				}
				else if ("weather".equals(paser.getName())) {
					weathers.add(wi);
				} else if ("environment".equals(paser.getName())) {
					weather.setEb(eb);
				}else if("forecast".equals(paser.getName())){
					weather.setWeathers(weathers);
				}else if("zhishu".equals(paser.getName())){
					zhishus.add(zhishu);
					zhishu = new ZhishuBean();
				}else if("zhishus".equals(paser.getName())){
					weather.setZhishus(zhishus);
				}
				break;
			}

			evenType = paser.next();
		}
		return weather;
	}
}
