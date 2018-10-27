package translator;
 
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
/**
 *
 * @author Linhht-uet
 */
public class GoogleTranslator {
     
    public String content;
	public String urlTest;
	private final String googleTranslatorURL = "http://translate.google.com/translate_a/t?";
	private LANGUAGE srcLang = LANGUAGE.AUTO;
	private LANGUAGE destLang = LANGUAGE.VIETNAMESE;
	private String userAgent = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16";

	public String translate(String query) throws MalformedURLException, IOException, ParseException {
		URL url = new URL(this.buildURLRequestWith(query));
		urlTest = this.buildURLRequestWith(query);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setDoOutput(true);
		conn.setRequestProperty("X-HTTP-Method-Override", "GET");
		conn.setRequestProperty("referer", "accounterlive.com");

		conn.addRequestProperty("User-Agent", this.userAgent);
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(30000);
		conn.connect();
		
		InputStream inputStream = conn.getInputStream();
		BufferedReader bis = new BufferedReader(new InputStreamReader(inputStream, "UTF8"));
		content = bis.readLine();

		inputStream.close();
		bis.close();
		conn.disconnect();

		   StringBuilder contentBuilder = new StringBuilder();
		   
	        JSONParser parser = new JSONParser();
	        JSONObject jsonData = (JSONObject) parser.parse(content);
	        JSONArray sentences = (JSONArray) jsonData.get("sentences");
	 
	        for (Object sentence : sentences) {
	            contentBuilder.append(((JSONObject) sentence).get("trans").toString().trim());
	        }
	 
	        return contentBuilder.toString().trim().replace(" .", ". ");
	    }

	public String buildURLRequestWith(String query) {
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(this.googleTranslatorURL);
		urlBuilder.append("client=gtrans");
		urlBuilder.append("&sl=en");
		urlBuilder.append("&tl=").append(this.destLang);

		urlBuilder.append("&format=html");
		urlBuilder.append("&v=2.0");
		String queryEncoded = "";
		try {
			queryEncoded = URLEncoder.encode(query, "UTF-8");
		} catch (Exception e) {
		}
		urlBuilder.append("&q=").append(queryEncoded);
		return urlBuilder.toString();
	}

	public LANGUAGE getSrcLang() {
		return srcLang;
	}

	public void setSrcLang(LANGUAGE srcLang) {
		this.srcLang = srcLang;
	}

	public LANGUAGE getDestLang() {
		return destLang;
	}

	public void setDestLang(LANGUAGE destLang) {
		this.destLang = destLang;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public static enum LANGUAGE {
		ENGLISH("en"), VIETNAMESE("vi"), AUTO("auto");

		private String lang = "";

		private LANGUAGE(String lang) {
			this.lang = lang;
		}

		@Override
		public String toString() {
			return this.lang;
		}
	}
         
}
