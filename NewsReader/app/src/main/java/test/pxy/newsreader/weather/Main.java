//package test.pxy.newsreader.weather;
//
//import android.os.Handler;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//import test.pxy.newsreader.weather.service.HttpUtils;
//import test.pxy.newsreader.weather.utils.XmlTools;
//import test.pxy.newsreader.weather.weather.WeatherBean;
//
//
//public class Main {
//	private static Scanner in;
//	private static InputStream is = null;
//	private static WeatherBean weather = null;
//	private static String url = null;
//	@SuppressWarnings("resource")
//	public Main(){
//
//	}
//	public static String  main() {
//		in = new Scanner(System.in);
//		//System.out.println("请输入要查询的天气信息：");
//		url = in.nextLine();
//		final String path = "http://wthrcdn.etouch.cn/WeatherApi?citykey=";
//		File file = new File("D://eclipse/Weather/location.xml");
//		Map<String, String> locations = new HashMap<>();
//		FileInputStream fi;
//		try {
//			fi = new FileInputStream(file);
//			BufferedReader br = new BufferedReader(new InputStreamReader(fi, "utf-8"));
//			String line = "";
//			while ((line = br.readLine()) != null) {
//				String[] rs = line.split("=");
//				locations.put(rs[1], rs[0]);
//			}
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		if (locations.containsKey(url)) {
//			url = locations.get(url);
//			System.out.println("yes");
//			new Thread() {
//				public void run() {
//					try {
//						is = HttpUtils.getInputStream(path + url);
//						weather = XmlTools.parseXML(is, "utf-8");
//					} catch (IOException e) {
//						e.printStackTrace();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				};
//			}.start();
//		} else {
//			System.out.println("no place!!!");
//		}
//	}
//}
