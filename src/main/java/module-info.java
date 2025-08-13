module com.norbertdominkiewicz.adminhut {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.norbertdominkiewicz.adminhut to javafx.fxml;
    opens com.norbertdominkiewicz.adminhut.controllers to javafx.fxml;
    exports com.norbertdominkiewicz.adminhut;
}
