package com.rymon.exampel.wifi_encrypted_messaging;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rymon.exampel.wifi_encrypted_messaging.Client.ClientActivity;
import com.rymon.exampel.wifi_encrypted_messaging.Models.Client;
import com.rymon.exampel.wifi_encrypted_messaging.Models.Server;
import com.rymon.exampel.wifi_encrypted_messaging.Server.ServerActivity;
import com.rymon.exampel.wifi_encrypted_messaging.Utils.RSAKeyPairGenerator;
import com.rymon.exampel.wifi_encrypted_messaging.Utils.SecurityUtils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetOnclickListeners();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            TestRSA();
        } else {

            Toast.makeText(this, "Security Function is not supported", Toast.LENGTH_LONG).show();
        }
    }

    private void SetOnclickListeners() {
        Button btnServer = (Button) findViewById(R.id.be_server);
        Button btnClient = (Button) findViewById(R.id.be_client);
        btnServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchServerActivity();
            }
        });

        btnClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchClientActivity();
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void TestRSA() {
        String TAG = "RSA-test";
        boolean isTestKey = false;
        try {
            RSAKeyPairGenerator keyPairGenerator1 = new RSAKeyPairGenerator();

            String ServerPublicKey = Base64.getEncoder().encodeToString(keyPairGenerator1.getPublicKey().getEncoded());
            String ServerPrivateKey = Base64.getEncoder().encodeToString(keyPairGenerator1.getPrivateKey().getEncoded());



            RSAKeyPairGenerator keyPairGenerator2 = new RSAKeyPairGenerator();

            String ClientPublicKey = Base64.getEncoder().encodeToString(keyPairGenerator2.getPublicKey().getEncoded());
            String ClientPrivateKey = Base64.getEncoder().encodeToString(keyPairGenerator2.getPrivateKey().getEncoded());

            if(isTestKey){
                ServerPublicKey = "S1erverPubl1cKey ";
                ServerPrivateKey= "S1erverPr1vateKey";
                ClientPublicKey = "C1lientPubl1cKey ";
                ClientPrivateKey= "C1lientPr1vateKey";

            }
            else
            {
                String encryptedString = Base64.getEncoder().encodeToString(SecurityUtils.encrypt("123  ashad asghhd ahsd ghagsdagsdygasydga dsga sdgya sdyagsdha gdgaydgyhasgdha gdh agsdyg ad4567891011", ServerPublicKey));

                Log.i(TAG, "RSA:encryptedString:  " + encryptedString);
                String decryptedString = SecurityUtils.decrypt(encryptedString, ServerPrivateKey);
                Log.i(TAG, "RSA: decryptedString: " + decryptedString);

                Log.e(TAG, "RSA: ServerPublicKey: " + ServerPublicKey);
                Log.e(TAG, "RSA: ServerPrivateKey: " + ServerPrivateKey);
            }


            Client client = Client.getInstance();
            client.setProperty(ClientPublicKey,ClientPrivateKey,true);

            Server server = Server.getInstance();
            server.setProperty(ServerPublicKey,ServerPrivateKey,true);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {

            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

    }

    private void launchServerActivity() {

        Intent intent = new Intent(this, ServerActivity.class);
        startActivity(intent);
//        this.finish();
    }

    private void launchClientActivity() {

        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
//        this.finish();

    }
}
