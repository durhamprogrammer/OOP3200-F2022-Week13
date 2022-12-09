package ca.durhamcollege.oop3200f2022week13a.Controllers;

import ca.durhamcollege.oop3200f2022week13a.Managers.SceneManager;
import ca.durhamcollege.oop3200f2022week13a.Managers.Utility;
import ca.durhamcollege.oop3200f2022week13a.core.Line;
import ca.durhamcollege.oop3200f2022week13a.core.Vector2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Vector2CanvasController implements Initializable
{
    public List<Vector2> vector2List;
    public Line line;

    @FXML
    private Button VectorListButton;

    @FXML
    private Canvas canvas;

    @FXML
    void VectorListButton_Clicked(ActionEvent event) throws IOException
    {
        SceneManager.Instance().changeScene(event, "shape-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        line= SceneManager.Instance().line;
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Utility.Instance().DrawLine(gc, line);
    }
}