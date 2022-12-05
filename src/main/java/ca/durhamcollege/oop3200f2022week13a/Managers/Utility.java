package ca.durhamcollege.oop3200f2022week13a.Managers;

import ca.durhamcollege.oop3200f2022week13a.core.Mathf;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

/* singleton */
public class Utility
{
    /****************************** SINGLETON ****************************/

    // Step 1 - create a private static instance member
    private static Utility m_instance = null;

    // Step 2 - make your default constructor private
    private Utility(){}

    // Step 3 - public static entry point
    public static Utility Instance()
    {
        // step 4 - ensure that your instance member variable is null
        if(m_instance == null)
        {
            // step 5 - instantiate a new instance of the singleton
            m_instance = new Utility();
        }
        // step 6 - return an instance (reference) of the class
        return m_instance;
    }

    /*********************************************************************/

    public float Distance(float x1, float y1, float x2, float y2)
    {
        float diffXs = x2 - x1;
        float diffYs = y2 - y1;
        return Mathf.Sqrt(diffXs * diffXs + diffYs * diffYs);
    }

    public void ConfigureVector2Spinner(Spinner<Double> spinner, double min, double max, double default_value, double increment_value)
    {
        // Configure each spinner in this way:
        // step 1. Define a SpinnerValueFactory
        SpinnerValueFactory<Double> spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, default_value, increment_value);
        // step 2. Set Value Factory
        spinner.setValueFactory(spinnerValueFactory);
        // step 3. get access to the spinner's textfield
        TextField spinnerTextField = spinner.getEditor();
        // step 4. create an event listener / event handler combo -> Observer Pattern
        spinnerTextField.textProperty().addListener((observable, oldValue, newValue) ->{
            try
            {
                Float.parseFloat(newValue);
            }
            catch(Exception e)
            {
                spinnerTextField.setText(oldValue);
            }
        });

    }
}
