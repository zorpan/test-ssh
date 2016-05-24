package test.pxy.newsreader.weather.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public class HttpUtils {

	public static InputStream getInputStream(final String path) throws IOException {
		InputStream inputstream = null;
		HttpURLConnection httpURLConnection = null;
		URL url;
		url = new URL(path);
		if (url != null)
			httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setConnectTimeout(4 * 1000);
		httpURLConnection.setDoInput(true);
		httpURLConnection.setRequestMethod("GET");
		int responseCode = httpURLConnection.getResponseCode();
		if (responseCode == 200) {
			inputstream = httpURLConnection.getInputStream();
		}
		return getXmlStringFromGZIP(inputstream);
	}

	private static InputStream getXmlStringFromGZIP(InputStream is) {
		try {
			BufferedInputStream bis = new BufferedInputStream(is);
			bis.mark(2);
			// 取前两个字节
			byte[] header = new byte[2];
			int result = bis.read(header);
			// reset输入流到开始位置
			bis.reset();
			// 判断是否是GZIP格式
			int headerData = getShort(header);
			if (result != -1 && headerData == 0x1f8b) {
				is = new GZIPInputStream(bis);
			} else {
				is = bis;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

	private static int getShort(byte[] data) {
		return (int) ((data[0] << 8) | data[1] & 0xFF);
	}
}
