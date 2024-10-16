package org.example.mvc.view;

import static org.example.mvc.view.RedirectView.DEFAUlT_REDIRECT_PREFIX;

public class JspViewResolver implements ViewResolver {

    @Override
    public View resolveView(String viewName) {
        if(viewName.startsWith(DEFAUlT_REDIRECT_PREFIX)){
            return new RedirectView(viewName);
        }
        return new JspView(viewName + ".jsp");
    }
}
