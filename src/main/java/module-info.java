module com.jpmorgan {
    requires javafx.controls;
    requires javafx.fxml;
	requires scala.library;

    opens com.jpmorgan to javafx.fxml;
    exports com.jpmorgan;
    exports com.jpmorgan.scenes;
    opens com.jpmorgan.scenes to javafx.fxml;
}
