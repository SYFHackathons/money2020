package com.syf.synchronymoney2020;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Button getRewardsButton = (Button) findViewById(R.id.getRewardsButton);
        getRewardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetRewardsTask().execute();
            }
        });

        Button nextMostLikelyPurchaseButton = (Button) findViewById(R.id.nextMostLikelyPurchaseButton);
        nextMostLikelyPurchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NextMostLikelyPurchaseTask().execute();
            }
        });

        Button applyForCreditButton = (Button) findViewById(R.id.applyForCreditButton);
        applyForCreditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ApplyForCreditTask().execute();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class GetRewardsTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {

                URL url = new URL("https://syf2020.syfwebservices.com/syf/getRewards");

                // Open connection
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("password", "Sh0wT!me");
                connection.setRequestProperty("username", "giveitatry");
                connection.setRequestProperty("Content-Type", "application/json");

                JSONObject request = new JSONObject();
                JSONObject requestBodyHeader = new JSONObject();

                requestBodyHeader.put("trans_id", "demorewards");
                request.put("Header", requestBodyHeader);
                request.put("gps_syf_profileid", "6ff47aed18048b7708dd84b47152ee75db535e0eaa90b46fc3b7dc20745780dd");


                Log.d("REQUEST", request.toString());

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
                outputStreamWriter.write(request.toString());
                outputStreamWriter.flush();
                outputStreamWriter.close();


                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();


                Log.d("RESPONSE", response.toString());



            }
            catch (IOException e) {
                System.out.println(e);
            }
            catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

    }

    private class NextMostLikelyPurchaseTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {

                URL url = new URL("https://syf2020.syfwebservices.com/syf/nextMostLikelyPurchase");

                // Open connection
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("password", "Sh0wT!me");
                connection.setRequestProperty("username", "giveitatry");
                connection.setRequestProperty("Content-Type", "application/json");

                JSONObject request = new JSONObject();

                request.put("accountNum", 100009);


                Log.d("REQUEST", request.toString());

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
                outputStreamWriter.write(request.toString());
                outputStreamWriter.flush();
                outputStreamWriter.close();


                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();


                Log.d("RESPONSE", response.toString());


            } catch (IOException e) {
                System.out.println(e);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
    }


    private class ApplyForCreditTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {

                URL url = new URL("https://syf2020.syfwebservices.com/syf/applyForCredit");

                // Open connection
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("password", "Sh0wT!me");
                connection.setRequestProperty("username", "giveitatry");
                connection.setRequestProperty("Content-Type", "application/json");

                JSONObject request = new JSONObject();
                JSONObject apply = new JSONObject();
                JSONObject applyRequest = new JSONObject();
                JSONObject authCosApplicantData = new JSONObject();
                JSONObject authCosApplicantDataAddress = new JSONObject();
                JSONObject spouseDetails = new JSONObject();
                JSONObject spouseDetailsAddress = new JSONObject();
                JSONObject merchantData = new JSONObject();
                JSONObject primaryApplicant = new JSONObject();
                JSONObject primaryApplicantAddress = new JSONObject();
                JSONObject primaryApplicantPreviousAddress = new JSONObject();


                authCosApplicantDataAddress.put("address2app", "");
                authCosApplicantDataAddress.put("stateapp", "");
                authCosApplicantDataAddress.put("address1app", "");
                authCosApplicantDataAddress.put("cityapp", "");
                authCosApplicantDataAddress.put("zipCodeapp", "");

                authCosApplicantData.put("lastNameapp", "");
                authCosApplicantData.put("firstNameapp", "");
                authCosApplicantData.put("middleInitialapp", "");
                authCosApplicantData.put("suffixapp", "");
                authCosApplicantData.put("ssn1", "");
                authCosApplicantData.put("birthDateapp", "");
                authCosApplicantData.put("driverLicenseNumberapp", "");
                authCosApplicantData.put("driverLicenseStateapp", "");
                authCosApplicantData.put("signatureIndicatorapp", "");
                authCosApplicantData.put("titleapp", "");
                authCosApplicantData.put("occupationCodeapp", "");
                authCosApplicantData.put("incomeAnnualapp", "");
                authCosApplicantData.put("address", authCosApplicantDataAddress);
                authCosApplicantData.put("membershipNumberapp", "");
                authCosApplicantData.put("ssnOverrideapp", "");
                authCosApplicantData.put("driverLicenseExpiryDateapp", "");


                spouseDetailsAddress.put("address2spd", "");
                spouseDetailsAddress.put("statespd", "");
                spouseDetailsAddress.put("address1spd", "");
                spouseDetailsAddress.put("cityspd", "");
                spouseDetailsAddress.put("zipCodespd", "");

                spouseDetails.put("spFirstName", "");
                spouseDetails.put("spMiddleName", "");
                spouseDetails.put("spLastName", "");
                spouseDetails.put("address", spouseDetailsAddress);


                merchantData.put("clientDepartment", "");
                merchantData.put("iovationRequestType", "application");
                merchantData.put("operator", "ECOM");
                merchantData.put("clientData", "");
                merchantData.put("merchantNumber", "0000000000010032");
                merchantData.put("country", "US");
                merchantData.put("deviceType", "T");
                merchantData.put("originalProductCode", "010");
                merchantData.put("rewardsCode", "");
                merchantData.put("membershipNumber", "");
                merchantData.put("primaryGroup", "000");
                merchantData.put("empAccountCode", "Y");
                merchantData.put("salesPerson", "213006748");
                merchantData.put("clientDataShare", "");
                merchantData.put("sendEmail", "");
                merchantData.put("referalCode", "");
                merchantData.put("register", "REGISTER");
                merchantData.put("clientId", "TJX");
                merchantData.put("referCode", "");
                merchantData.put("comment", "");
                merchantData.put("secondaryGroup", "000");



                primaryApplicantAddress.put("address2", "");
                primaryApplicantAddress.put("state", "IL");
                primaryApplicantAddress.put("address1", "21 KING ARTHUR CT");
                primaryApplicantAddress.put("city", "FANTASY ISLAND");
                primaryApplicantAddress.put("zipCode", "60750");

                primaryApplicantPreviousAddress.put("address2prvad", "");
                primaryApplicantPreviousAddress.put("stateprvad", "");
                primaryApplicantPreviousAddress.put("address1prvad", "");
                primaryApplicantPreviousAddress.put("cityprvad", "");
                primaryApplicantPreviousAddress.put("zipCodeprvad", "");

                primaryApplicant.put("tempPassDays", "");
                primaryApplicant.put("longitude", "");
                primaryApplicant.put("cardIndSEDS", "");
                primaryApplicant.put("promoTrack", "");
                primaryApplicant.put("employerState", "");
                primaryApplicant.put("spCode", "");
                primaryApplicant.put("bankCardNumber", "");
                primaryApplicant.put("signatureIndicator", "");
                primaryApplicant.put("customerLoanTerm", "");
                primaryApplicant.put("passportIssuingCountry", "");
                primaryApplicant.put("swipeEdit", "");
                primaryApplicant.put("address", primaryApplicantAddress);
                primaryApplicant.put("plateCode", "");
                primaryApplicant.put("ssn", "666010080");
                primaryApplicant.put("permanentResidentCard", "");
                primaryApplicant.put("passportNumber", "");
                primaryApplicant.put("cardIndVISA", "");
                primaryApplicant.put("cardIndAMEX", "");
                primaryApplicant.put("mobileStoreDistance", "");
                primaryApplicant.put("bankCardType", "");
                primaryApplicant.put("employerName", "");
                primaryApplicant.put("redemptionAmount", "");
                primaryApplicant.put("timeAtHome", "");
                primaryApplicant.put("latitude", "");
                primaryApplicant.put("applicationCountry", "");
                primaryApplicant.put("homePhone", "1234567891");
                primaryApplicant.put("requestedlineOfCredit", "");
                primaryApplicant.put("relativeInfo", "");
                primaryApplicant.put("memberNumber", "");
                primaryApplicant.put("employerPhone", "");
                primaryApplicant.put("imageDocID", "");
                primaryApplicant.put("secLastName", "");
                primaryApplicant.put("optOutFlag", "");
                primaryApplicant.put("eBillEnrollment", "");
                primaryApplicant.put("cardIndMC", "");
                primaryApplicant.put("birthDate", "19700605");
                primaryApplicant.put("promoCode", "");
                primaryApplicant.put("incomeAnnual", "12000000");
                primaryApplicant.put("companyPhone", "");
                primaryApplicant.put("maidenName", "");
                primaryApplicant.put("authCosCode", "");
                primaryApplicant.put("insuranceCode", "");
                primaryApplicant.put("onlineLetter", "");
                primaryApplicant.put("billingLastName", "");
                primaryApplicant.put("caCivicNumber", "");
                primaryApplicant.put("previousAddress", primaryApplicantPreviousAddress);
                primaryApplicant.put("mobileDeviceType", "");
                primaryApplicant.put("lastName", "APPROVAL");
                primaryApplicant.put("billinngCycle", "");
                primaryApplicant.put("firstName", "JOE");
                primaryApplicant.put("ipAddress", "");
                primaryApplicant.put("purchaseAmount", "");
                primaryApplicant.put("extensionPhoneNumber", "");
                primaryApplicant.put("driverLicenseState", "");
                primaryApplicant.put("sourceCode", "");
                primaryApplicant.put("mothersBirthDate", "");
                primaryApplicant.put("driverLicenseExpiryDate", "");
                primaryApplicant.put("dlSsoId", "");
                primaryApplicant.put("memberSinceDate", "");
                primaryApplicant.put("email", "t@t.com");
                primaryApplicant.put("reissueDate", "");
                primaryApplicant.put("modelIndicator", "");
                primaryApplicant.put("billingFirstName", "");
                primaryApplicant.put("residenceCode", "");
                primaryApplicant.put("timeAtJob", "");
                primaryApplicant.put("vehicleOwn", "");
                primaryApplicant.put("relativePhone", "");
                primaryApplicant.put("creditLineRqd", "");
                primaryApplicant.put("contractNumber", "");
                primaryApplicant.put("passportBirthCity", "");
                primaryApplicant.put("employerZip", "");
                primaryApplicant.put("cardDeptStrInd", "");
                primaryApplicant.put("blackBoxId", "");
                primaryApplicant.put("title", "");
                primaryApplicant.put("bankAccountCode", "");
                primaryApplicant.put("regionalBusinessCode", "");
                primaryApplicant.put("occupationCode", "");
                primaryApplicant.put("employerAddress", "");
                primaryApplicant.put("driverLicenseNumber", "");
                primaryApplicant.put("applicationType", "");
                primaryApplicant.put("accoutInfo", "");
                primaryApplicant.put("mortgageOrRentPay", "");
                primaryApplicant.put("extensionOverride", "");
                primaryApplicant.put("employerCity", "");
                primaryApplicant.put("middleName", "");
                primaryApplicant.put("suffix", "");
                primaryApplicant.put("ssnOverride", "");
                primaryApplicant.put("currentEmployer", "");
                primaryApplicant.put("relativeCode", "");
                primaryApplicant.put("routingNumber", "");
                primaryApplicant.put("cellPhone", "");
                primaryApplicant.put("frnLangIndicator", "E");
                primaryApplicant.put("checkingAccountNumber", "");
                primaryApplicant.put("memberType", "");


                applyRequest.put("authCosApplicantData", authCosApplicantData);
                applyRequest.put("spouseDetails", spouseDetails);
                applyRequest.put("merchantData", merchantData);
                applyRequest.put("primaryApplicant", primaryApplicant);

                apply.put("applyRequest", applyRequest);
                request.put("apply", apply);





                Log.d("REQUEST", request.toString());

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
                outputStreamWriter.write(request.toString());
                outputStreamWriter.flush();
                outputStreamWriter.close();


                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();


                Log.d("RESPONSE", response.toString());


            } catch (IOException e) {
                System.out.println(e);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

    }

}
