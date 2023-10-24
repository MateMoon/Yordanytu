package com.example.yordanytu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView_);

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new JavaScriptInterface(),"appInterface");

    }
    public void LoadURL (View view){
        EditText urleEditText = findViewById(R.id.txt_Ingrese);

        String url = urleEditText.getText().toString();

        if(url.isEmpty()){
            Toast.makeText(this, "Ingrese una URL válida", Toast.LENGTH_SHORT).show();
        }
        else {
            webView.loadUrl(url);
        }
    }
    private class JavaScriptInterface{
        @android.webkit.JavascriptInterface

        public void showToast(String message){
        }
    }
}