/*
 * Tumi Snær Gíslason
 * 25.10.2014
 * Makes http request and gets a response String
 * 
 * THIS CLASS IS NOT BEING USED FOR NOW
 */
package hbv1.farfuglinn;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class NOT_BEING_USED_GetData {

	public final static int GET = 1;
	static String response = null;

	public NOT_BEING_USED_GetData() {

	}


	public String getDataFromService(String url, int method) {
		return this.getDataFromService(url, method, null);
	}


	public String getDataFromService(String url, int method,
			List<NameValuePair> params) {
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpEntity httpEntity = null;
			HttpResponse httpResponse = null;

			// assume that GET is used
			if (params != null) {
				String paramString = URLEncodedUtils
						.format(params, "utf-8");
				url += "?" + paramString;
			}
			HttpGet httpGet = new HttpGet(url);

			httpResponse = httpClient.execute(httpGet);


			httpEntity = httpResponse.getEntity();
			response = EntityUtils.toString(httpEntity);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;

	}

}
