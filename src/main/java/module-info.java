module ec.edu.espol.proyectopoofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyectopoofx to javafx.fxml;
    exports ec.edu.espol.proyectopoofx;
}
