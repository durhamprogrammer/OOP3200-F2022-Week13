module ca.durhamcollege.oop3200f2022week13a {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.durhamcollege.oop3200f2022week13a to javafx.fxml;
    exports ca.durhamcollege.oop3200f2022week13a;
    exports ca.durhamcollege.oop3200f2022week13a.core;
    opens ca.durhamcollege.oop3200f2022week13a.core to javafx.fxml;
    exports ca.durhamcollege.oop3200f2022week13a.objects;
    opens ca.durhamcollege.oop3200f2022week13a.objects to javafx.fxml;
    exports ca.durhamcollege.oop3200f2022week13a.Controllers;
    opens ca.durhamcollege.oop3200f2022week13a.Controllers to javafx.fxml;
    exports ca.durhamcollege.oop3200f2022week13a.Managers;
    opens ca.durhamcollege.oop3200f2022week13a.Managers to javafx.fxml;
}