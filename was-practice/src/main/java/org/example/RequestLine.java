package org.example;

import java.util.Objects;

public class RequestLine {
    private final String method;
    private final String urlpath;
    private QueryStrings queryStrings;

    public RequestLine(String get, String urlpath, String queryString) {
        this.method = get;
        this.urlpath = urlpath;
        this.queryStrings = new QueryStrings(queryString);
    }

    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];
        String[] urlPathTokens= tokens[1].split("\\?");
        this.urlpath = urlPathTokens[0];

        if(urlPathTokens.length == 2) {
            this.queryStrings = new QueryStrings(urlPathTokens[1]);
        }
    }

    public boolean isGetRequest() {
        return "GET".equals(method);
    }

    public boolean mathPath(String requestPath) {
        return urlpath.equals(requestPath);
    }
    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlpath, that.urlpath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlpath, queryStrings);
    }



}
