package main.java.io.egen;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Rama on 6/29/2017.
 */
public class  ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected java.lang.Class<?>[] getRootConfigClasses() {
        return new Class[]{Application.class, JPAConfig.class};
    }

    protected java.lang.Class<?>[] getServletConfigClasses() {
        return new java.lang.Class[0];
    }

    protected java.lang.String[] getServletMappings() {
        return new String[]{"/api/*"};
    }
}
