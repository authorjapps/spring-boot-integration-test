package com.springboot.testrunner.httpclient;

import org.apache.http.client.CookieStore;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsmart.zerocode.core.httpclient.BasicHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class ProjectApacheHttpClient extends BasicHttpClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectApacheHttpClient.class);

    public ProjectApacheHttpClient() {
    }

    public ProjectApacheHttpClient(CloseableHttpClient httpclient) {
        super(httpclient);
    }

    @Override
    public CloseableHttpClient createHttpClient() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        LOGGER.info("###Used Project SSL Enabled Http Client for both Http and Https connections");
        SSLContext sslContext = (new SSLContextBuilder()).loadTrustMaterial((KeyStore)null, (certificate, authType) -> {
            return true;
        }).build();

        CookieStore cookieStore = new BasicCookieStore();
        return HttpClients.custom().setSSLContext(sslContext).setSSLHostnameVerifier(new NoopHostnameVerifier()).setDefaultCookieStore(cookieStore).build();
    }

}

