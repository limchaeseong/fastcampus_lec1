package org.example.mvc.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class RedirectView implements View {

    private static final Logger log = LoggerFactory.getLogger(RedirectView.class);

    public static final String DEFAULT_REDIRECT_PREFIX = "redirect:";
    private final String name;

    public RedirectView(String name) {
        this.name = name;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("Redirect [{}]", name);
        response.sendRedirect(name.substring(DEFAULT_REDIRECT_PREFIX.length()));
    }
}
