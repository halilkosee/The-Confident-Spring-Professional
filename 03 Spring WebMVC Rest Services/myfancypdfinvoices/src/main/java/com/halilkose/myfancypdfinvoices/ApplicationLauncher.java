package com.halilkose.myfancypdfinvoices;

import com.halilkose.myfancypdfinvoices.context.MyFancyPdfInvoicesApplicationConfiguration;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;

public class ApplicationLauncher {
    public static void main(String[] args)  throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort((8080));
        tomcat.getConnector();

        Context tomcatCtx = tomcat.addContext("",null);

        WebApplicationContext appCtx = createApplicationContext(tomcatCtx.getServletContext());
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appCtx);

        Wrapper servlet = Tomcat.addServlet(tomcatCtx,
                "dispatcherServlet",
                dispatcherServlet);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();
    }

    public static WebApplicationContext createApplicationContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyFancyPdfInvoicesApplicationConfiguration.class);
        ctx.setServletContext(servletContext);
        ctx.refresh();
        ctx.registerShutdownHook();
        return ctx;
    }
}
