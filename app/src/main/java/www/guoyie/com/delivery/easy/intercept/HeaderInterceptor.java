package www.guoyie.com.delivery.easy.intercept;


import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import www.guoyie.com.delivery.easy.util.MarvelService;

/**
 * Retrofit2 Cookie拦截器。用于保存和设置Cookies
 *
 * @author yuyh.
 * @date 16/8/6.
 */
public final class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
//        //请求体定制：统一添加token参数
//        //post参数
        Request.Builder requestBuilder = original.newBuilder();
        RequestBody formBody = new FormBody.Builder()
                .add(MarvelService.TIME, MarvelService.getTime())
                .add(MarvelService.TOKEN, MarvelService.getToken())
                .add(MarvelService.AUTH_TOKEN, MarvelService.getAuthToken())
                .build();
        String postBodyString = bodyToString(original.body());
        postBodyString += ((postBodyString.length() > 0) ? "&" : "") + bodyToString(formBody);
        original = requestBuilder.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"),
                postBodyString))
                .build();

        return chain.proceed(original);
    }

    private static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
}
