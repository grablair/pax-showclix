package com.grablair.pax.showclix;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class ShowclixMain {
	public static final String SHOWCLIX_EVENTS_URL = "http://api.showclix.com/Seller/16886/events";
	public static final long DEFAULT_THRESHOLD_MILLIS = 5000; // 5 seconds
	public static final long WAIT_TIME_MILLIS = 1000;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, InterruptedException {
		URL url = new URL(SHOWCLIX_EVENTS_URL);
		
		long thresholdMillis = args.length > 0 ? Long.parseLong(args[0]) * 1000 : DEFAULT_THRESHOLD_MILLIS;
		
		Status status = new Status();
		int latestId = 0;
		long lastCheck = 0;
		for (;;) {
			try {
				if (System.currentTimeMillis() - lastCheck >= thresholdMillis) {
					HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
				    httpCon.addRequestProperty("User-Agent", "Mozilla/4.0");
					BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
					String jsonText = "";
					while (reader.ready()) {
						jsonText += reader.readLine();
					}
					reader.close();
					
					JSONObject obj = (JSONObject) JSONSerializer.toJSON(jsonText);
					
					int maxId = 0;
					for (String s : (Iterable<String>) obj.keySet()) {
						maxId = Math.max(maxId, Integer.parseInt((String) s));
					}
					
					status.setTotalEventCount(obj.size());
					
					if (maxId != latestId) {
						latestId = maxId;
						JSONObject eventObj = (JSONObject) obj.get(Integer.toString(maxId));
						status.setLatestEvent(eventObj.getString("event"));
						String eventUrl = "http://showclix.com/event/" + maxId;
						status.setLatestURL(eventUrl);
						try {
							Desktop.getDesktop().browse(new URI(eventUrl));
						} catch (IOException | URISyntaxException e) {
							e.printStackTrace();
						}
					}
					
					lastCheck = System.currentTimeMillis();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				status.setLatestShowclixCheck(System.currentTimeMillis() - lastCheck);
				Thread.sleep(WAIT_TIME_MILLIS);
			}
		}
	}
}
