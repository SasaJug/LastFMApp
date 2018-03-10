package com.sasaj.lastfmapp.httpclient;

import android.content.Context;

import com.sasaj.lastfmapp.utility.FileUtility;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by sjugurdzija on 3/10/2018.
 */

public class OfflineMockInterceptor implements Interceptor {

    private static final MediaType MEDIA_JSON = MediaType.parse("application/json");
    private Context mContext;

    public OfflineMockInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

    /* http://sample.com/hello will return "/hello" */
        String path = request.url().encodedPath();

    /* I put a 'hello' file in debug/assets/mockData */
        InputStream stream = mContext.getAssets().open("ChartArtistsResponseSampleJson.txt");

    /* Just read the file. */
        String json = FileUtility.parseStream(stream);

        Response response = new Response.Builder()
                .body(ResponseBody.create(MEDIA_JSON, json))
                .request(chain.request())
                .protocol(Protocol.HTTP_2)
                .code(200)
                .message("OK")
                .build();

        return response;
    }
}
