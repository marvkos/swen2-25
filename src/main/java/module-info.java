module at.technikum.javafx {
    requires java.net.http;

    requires javafx.controls;
    requires javafx.web;
    requires javafx.fxml;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;

    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens at.technikum.javafx to javafx.fxml;
    opens at.technikum.javafx.view to javafx.fxml;
    opens at.technikum.javafx.entity;
    opens at.technikum.javafx.service;
    opens at.technikum.javafx.service.openrouteservice;

    exports at.technikum.javafx;
    exports at.technikum.javafx.view;
    exports at.technikum.javafx.viewmodel;
}
