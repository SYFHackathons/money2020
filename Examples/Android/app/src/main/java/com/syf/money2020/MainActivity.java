package com.syf.money2020;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.syf.money2020.models.FinancialAdvisorRequest;
import com.syf.money2020.models.FinancialAdvisorResponse;
import com.syf.money2020.models.LoyaltyRequest;
import com.syf.money2020.models.LoyaltyResponse;
import com.syf.money2020.models.NextPurchaseRequest;
import com.syf.money2020.models.NextPurchaseResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.response)
    TextView responseTextView;

    private Retrofit retrofit;
    private SyfService syfService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //create retrofit object
        retrofit = new Retrofit.Builder()
                .baseUrl("https://syf2020.syfwebservices.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //attach our interface to Retrofit
        syfService = retrofit.create(SyfService.class);

    }


    /**
     * Call the Loyalty service
     */
    @OnClick(R.id.loyalty)
    public void loyaltyButton() {

        //build the request object (quantity and requestedAmount are optional)
        LoyaltyRequest request = new LoyaltyRequest();
        request.setAccountNumber(1337);
        request.setSku("item-1234");

        //retrofit call with callbacks
        syfService.getLoyalty(request).enqueue(new Callback<LoyaltyResponse>() {
            @Override
            public void onResponse(Call<LoyaltyResponse> call, Response<LoyaltyResponse> response) {
                responseTextView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<LoyaltyResponse> call, Throwable t) {
                responseTextView.setText(t.toString());
            }
        });


    }


    /**
     * Call the Financial Advice service
     */
    @OnClick(R.id.advice)
    public void adviceButton() {

        //Build the request object
        FinancialAdvisorRequest request = new FinancialAdvisorRequest();
        request.setAccountNumber(1337);

        //retrofit call with callbacks
        syfService.getAdvice(request).enqueue(new Callback<FinancialAdvisorResponse>() {
            @Override
            public void onResponse(Call<FinancialAdvisorResponse> call, Response<FinancialAdvisorResponse> response) {
                responseTextView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<FinancialAdvisorResponse> call, Throwable t) {
                responseTextView.setText(t.toString());
            }
        });


    }

    @OnClick(R.id.nextpurchase)
    public void nextPurchaseButton() {

        //Build the request object
        NextPurchaseRequest request = new NextPurchaseRequest();
        request.setAccountNumber(1337);

        //retrofit call with callbacks
        syfService.getNextPurchase(request).enqueue(new Callback<NextPurchaseResponse>() {
            @Override
            public void onResponse(Call<NextPurchaseResponse> call, Response<NextPurchaseResponse> response) {
                responseTextView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<NextPurchaseResponse> call, Throwable t) {
                responseTextView.setText(t.toString());
            }
        });


    }


    /**
     * Interface used by Retrofit for calls
     */
    public interface SyfService {

        @POST("v1_0/loyalty")
        Call<LoyaltyResponse> getLoyalty(@Body LoyaltyRequest loyaltyRequest);

        @POST("v1_0/advice")
        Call<FinancialAdvisorResponse> getAdvice(@Body FinancialAdvisorRequest financialAdvisorRequest);

        @POST("v1_0/next_purchase")
        Call<NextPurchaseResponse> getNextPurchase(@Body NextPurchaseRequest nextPurchaseRequest);

    }

}
