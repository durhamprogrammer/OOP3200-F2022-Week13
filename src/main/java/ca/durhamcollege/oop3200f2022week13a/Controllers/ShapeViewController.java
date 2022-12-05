package ca.durhamcollege.oop3200f2022week13a.Controllers;
import ca.durhamcollege.oop3200f2022week13a.Managers.SceneManager;
import ca.durhamcollege.oop3200f2022week13a.Managers.Utility;
import ca.durhamcollege.oop3200f2022week13a.core.Vector2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShapeViewController implements Initializable
{
    @FXML
    private Button AddVectorButton;

    @FXML
    private Button CalculateDistanceButton;

    @FXML
    private Button DrawShapeButton;

    @FXML
    private Label TotalDistanceLabel;

    @FXML
    private TextField TotalDistanceTextView;

    @FXML
    private ListView<Vector2> Vector2ListView;

    @FXML
    private Spinner<Double> XInputSpinner;

    @FXML
    private Spinner<Double> YInputSpinner;

    @FXML
    void AddVectorButton_Clicked(ActionEvent event)
    {
            float x = XInputSpinner.getValue().floatValue();
            float y = YInputSpinner.getValue().floatValue();

            Vector2 newVector2 = new Vector2(x, y);
            Vector2ListView.getItems().add(newVector2);
            XInputSpinner.getEditor().setText("0");
            YInputSpinner.getEditor().setText("0");
            TotalDistanceTextView.clear();
    }

    @FXML
    void CalculateDistanceButton_Clicked(ActionEvent event)
    {
        var selectedItemsList = Vector2ListView.getSelectionModel().getSelectedItems();
        var distance = Vector2.Distance(selectedItemsList.get(0), selectedItemsList.get(1));
        TotalDistanceTextView.setText(Float.toString(distance));
    }

    @FXML
    void DrawShapeButton_Clicked(ActionEvent event) throws IOException
    {
        var selectedItemsList = Vector2ListView.getSelectionModel().getSelectedItems().stream().toList();

        SceneManager.Instance().changeScene(event, "vector2-canvas.fxml", selectedItemsList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Vector2ListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Vector2ListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->
        {

            if(Vector2ListView.getSelectionModel().getSelectedItems().size() == 2)
            {
                showDistanceUI();
            }
            else
            {
                hideDistanceUI();
            }

            if(Vector2ListView.getSelectionModel().getSelectedItems().size() == 2)
            {
                DrawShapeButton.setVisible(true);
            }
            else
            {
                DrawShapeButton.setVisible(false);
            }
        });

        // Configure the XInputSpinner
        Utility.Instance().ConfigureVector2Spinner(XInputSpinner, -1000.0, 1000.0, 0.0, 0.1);
        // Configure the YInputSpinner
        Utility.Instance().ConfigureVector2Spinner(YInputSpinner, -1000.0, 1000.0, 0.0, 0.1);

    }

    private void showDistanceUI()
    {
        CalculateDistanceButton.setVisible(true);
        TotalDistanceLabel.setVisible(true);
        TotalDistanceTextView.setVisible(true);
    }

    private void hideDistanceUI()
    {
        CalculateDistanceButton.setVisible(false);
        TotalDistanceLabel.setVisible(false);
        TotalDistanceTextView.setVisible(false);
        TotalDistanceTextView.clear();
    }
}