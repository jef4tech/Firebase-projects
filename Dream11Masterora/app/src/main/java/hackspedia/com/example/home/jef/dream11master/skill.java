package hackspedia.com.example.home.jef.dream11master;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class skill  extends AppCompatActivity {

    private WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fou );
        String url = "https://skillup.dream11.com/";


        wv1= findViewById(R.id.webView);
        wv1.setWebViewClient(new MyBrowser());
                wv1.getSettings().setLoadsImagesAutomatically(true);
                wv1.getSettings().setJavaScriptEnabled(true);
        wv1.getSettings().setDomStorageEnabled(true);
        wv1.getSettings().setAppCacheEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wv1.getSettings().setMixedContentMode( WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        wv1.setScrollBarStyle( View.SCROLLBARS_INSIDE_OVERLAY);
                wv1.loadUrl(url);
            }

    }

    class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

