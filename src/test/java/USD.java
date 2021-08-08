import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class USD extends Coin {

    private final double value = 0.31;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double input) {
        return input * getValue();
    }

    public void value () throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.exchangeratesapi.io/v1/latest?access_key=3f1b2b2de625b310c3b4ec5eb2316dee&symbols=USD,ILS")
                .build();
        Response response = client.newCall(request).execute();
        String jsonData = response.body().string();
        // parse JSON
        JSONObject mainJsonObject = new JSONObject(jsonData);
        // get Json object
        JSONObject resultsJson = mainJsonObject.getJSONObject("rates");
        // get value
        double ilsValue = resultsJson.getDouble("ILS");
        double usdValue = resultsJson.getDouble("USD");
        double dollarToIlsRate = ilsValue/usdValue;



    }
}
