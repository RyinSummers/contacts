package yaoyaoandus.contacts;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONObject;

/**
 * Created by LJY on 16/9/16.
 */
public class HttpUtils
{
    private static final String BASE_URL = "http://121.250.217.61";
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);

    }

    public static void post(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
        //client.post(getAbsoluteUrl(url), params, responseHandler);
        client.post(getAbsoluteUrl(url), params,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
            }

//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
//                // Pull out the first event on the public timeline
//                JSONObject firstEvent = timeline.get(0);
//                String tweetText = firstEvent.getString("text");
//
//                // Do something with the response
//                System.out.println(tweetText);
//            }
        });
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }


//
//    //5秒则超时
//    private static final int TIMEOUT_IN_MILLIONS = 30000;
//
//    private static String cookie=null;
//
//    public interface CallBack
//    {
//        void onRequestComplete(String result);
//    }
//
//    /**
//     * 异步的Get请求
//     *
//     * @param urlStr 传入的url
//     * @param callBack
//     */
//    public static void doGetAsyn(final String urlStr, final CallBack callBack)
//    {
//        new Thread()
//        {
//            public void run()
//            {
//                try
//                {
//                    String result = doGet(urlStr);
//                    if (callBack != null)
//                    {
//                        callBack.onRequestComplete(result);
//                    }
//                } catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
//
//            };
//        }.start();
//    }
//
//    /**
//     * 异步的Post请求
//     * @param urlStr
//     * @param params
//     * @param callBack
//     * @throws Exception
//     */
//    public static void doPostAsyn(final String urlStr, final String params,
//                                  final CallBack callBack) throws Exception
//    {
//        new Thread()
//        {
//            public void run()
//            {
//                try
//                {
//                    String result = doPost(urlStr, params);
//                    if (callBack != null)
//                    {
//                        callBack.onRequestComplete(result);
//                    }
//                } catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
//
//            };
//        }.start();
//
//    }
//
//    /**
//     * Get请求，获得返回数据
//     *
//     * @param urlStr
//     * @return
//     * @throws Exception
//     */
//    public static String doGet(String urlStr)
//    {
//        URL url = null;
//        HttpURLConnection conn = null;
//        InputStream is = null;
//        ByteArrayOutputStream baos = null;
//        try
//        {
////            java.net.CookieManager manager = new java.net.CookieManager();
////            manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
////            CookieHandler.setDefault(manager);
//
//            url = new URL(urlStr);
//            conn = (HttpURLConnection)url.openConnection();
//            conn.setReadTimeout(TIMEOUT_IN_MILLIONS);
//            conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("accept", "application/json");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            if(cookie!=null)
//                conn.setRequestProperty("Cookie",cookie);
//            conn.connect();
//
////            conn.getHeaderFields();
////            CookieStore store = manager.getCookieStore();
////            responseUpdateCookieHttpURL(store);
//
//            if (conn.getResponseCode() == 200)
//            {
//                is = conn.getInputStream();
//                baos = new ByteArrayOutputStream();
//                int len = -1;
//                byte[] buf = new byte[128];
//
//                while ((len = is.read(buf)) != -1)
//                {
//                    baos.write(buf, 0, len);
//                }
//                baos.flush();
//                return baos.toString();
//            } else
//            {
//                throw new RuntimeException(" responseCode is not 200 ... ");
//            }
//
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        } finally
//        {
//            try
//            {
//                if (is != null)
//                    is.close();
//            } catch (IOException e)
//            {
//            }
//            try
//            {
//                if (baos != null)
//                    baos.close();
//            } catch (IOException e)
//            {
//            }
//            cookie=conn.getHeaderField("set-cookie");
//            conn.disconnect();
//        }
//
//        return null ;
//
//    }
//
//    /**
//     * 向指定 URL 发送POST方法的请求
//     *
//     * @param url
//     *            发送请求的 URL
//     * @param param
//     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
//     * @return 所代表远程资源的响应结果
//     * @throws Exception
//     */
//    public static String doPost(String url, String param)
//    {
//        //PrintWriter out = null;
//        DataOutputStream out=null;
//        BufferedReader in = null;
//        String result = "";
//        HttpURLConnection conn = null;
//        try
//        {
////            java.net.CookieManager manager = new java.net.CookieManager();
////            manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
////            CookieHandler.setDefault(manager);
//
//            URL realUrl = new URL(url);
//            // 打开和URL之间的连接
//            conn = (HttpURLConnection) realUrl
//                    .openConnection();
//            // 设置通用的请求属性
//            conn.setRequestProperty("accept", "application/json");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type",
//                    "application/json");
//            conn.setRequestProperty("charset", "utf-8");
//            if(cookie!=null)
//                conn.setRequestProperty("Cookie",cookie);
//            conn.setUseCaches(false);
//            // 发送POST请求必须设置如下两行
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            conn.setReadTimeout(TIMEOUT_IN_MILLIONS);
//            conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);
//            conn.connect();
//
////            conn.getHeaderFields();
////            CookieStore store = manager.getCookieStore();
////            responseUpdateCookieHttpURL(store);
//            if (param != null && !param.trim().equals(""))
//            {
////                // 获取URLConnection对象对应的输出流
////                out = new PrintWriter(conn.getOutputStream());
////                // 发送请求参数
////                out.print(param);
////                // flush输出流的缓冲
////                out.flush();
//
//                out = new DataOutputStream(conn.getOutputStream());
//                byte[] content = param.getBytes("utf-8");
//                out.write(content, 0, content.length);
//                out.flush();
//            }
//            // 定义BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream(),"utf-8"));
//            String line="";
//            while ((line = in.readLine()) != null)
//            {
//                result += line;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        // 使用finally块来关闭输出流、输入流
//        finally
//        {
//            try
//            {
//                if (out != null)
//                {
//                    out.close();
//                }
//                if (in != null)
//                {
//                    in.close();
//                }
//            } catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
//            cookie=conn.getHeaderField("set-cookie");
//            conn.disconnect();
//        }
//        return result;
//
//    }
//
//    public static void responseUpdateCookieHttpURL(CookieStore store) {
//        boolean needUpdate = false;
//        List<HttpCookie> cookies = store.getCookies();
//        HashMap<String, String> cookieMap = null;
//        if (cookieMap == null) {
//            cookieMap = new HashMap<String, String>();
//        }
//        for (HttpCookie cookie : cookies) {
//            String key = cookie.getName();
//            String value = cookie.getValue();
//            if (cookieMap.size() == 0 || !value.equals(cookieMap.get(key))) {
//                needUpdate = true;
//            }
//            cookieMap.put(key, value);
//            //        BDebug.e(HTTP_COOKIE, cookie.getName() + "---->" + cookie.getDomain() + "------>" + cookie.getPath());
//        }
//
//    }
}
