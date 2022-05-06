package br.com.juliocauan.model.api.apiClient.MarvelClient;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.juliocauan.model.api.apiClient.ApiClient;

public class MarvelApiClient extends ApiClient<MarvelEndpoint>{

    
    public MarvelApiClient() {
        super("1871e6caf897d7c908703e2b49bcb025", "https://gateway.marvel.com/v1/public/");
    }

    @Override
    protected String makeUrl(MarvelEndpoint request) {
        String ts = String.valueOf(System.currentTimeMillis());
        String hash = getHashMd5(ts + privateKey + getApiKey());
        return String.format("%s%s?ts=%s&apikey=%s&hash=%s",
            getApiUrl(), request.endpoint, ts, getApiKey(), hash);
    }
    
    private final String getHashMd5(String value) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, md.digest(value.getBytes()));
			return hash.toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
