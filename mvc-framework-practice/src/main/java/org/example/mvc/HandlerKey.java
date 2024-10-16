package org.example.mvc;

import org.example.mvc.controller.RequestMethod;

import java.util.Objects;

public class HandlerKey {

    private final RequestMethod reqeustMethod;
    private final String urlPath;

    public HandlerKey(RequestMethod requestMethod, String urlPath) {
        this.reqeustMethod = requestMethod;
        this.urlPath = urlPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final HandlerKey that = (HandlerKey) o;
        return reqeustMethod == that.reqeustMethod && Objects.equals(urlPath, that.urlPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reqeustMethod, urlPath);
    }
}
