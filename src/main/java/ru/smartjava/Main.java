package ru.smartjava;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException, LifecycleException {
        final Tomcat tomcat = new Tomcat();
        final Path tomcatBaseDir = Files.createTempDirectory("tomcat");
        tomcatBaseDir.toFile().deleteOnExit();
        tomcat.setBaseDir(tomcatBaseDir.toAbsolutePath().toString());

        final Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);

        tomcat.getHost().setAppBase(".");
        tomcat.addWebapp("", ".");

        tomcat.start();
        tomcat.getServer().await();
    }
}