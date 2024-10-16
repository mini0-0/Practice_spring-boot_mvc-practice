package org.example.mvc.view;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface View {
    void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
