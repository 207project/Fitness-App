package view;

import interface_adapter.RecipePageViewModel.RecipePageState;
import interface_adapter.RecipePageViewModel.RecipePageViewModel;
import interface_adapter.RecipeDoneButton.RecipeDoneController;
import interface_adapter.RecipeSearchButton.RecipeSearchButtonController;
import interface_adapter.SearchWorkoutByNameState;
import interface_adapter.SearchWorkoutByNameViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.Workout.WorkoutViewModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchWorkoutByNameView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Workout Name Search View";

    private final SearchWorkoutByNameViewModel searchWorkoutByNameViewModel;

    private final JTextField workoutnameInputField = new JTextField(25);
    private final JButton search;
    private final JButton clear;
    private final JButton Done;


    public SearchWorkoutByNameView(SearchWorkoutByNameViewModel searchWorkoutByNameViewModel, ViewManagerModel viewManagerModel, WorkoutViewModel workoutViewModel) {
        this.searchWorkoutByNameViewModel = searchWorkoutByNameViewModel;
        this.searchWorkoutByNameViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(searchWorkoutByNameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel workoutnameinfo = new LabelTextPanel(
                new JLabel(searchWorkoutByNameViewModel.WORKOUT_NAME_LABEL), workoutnameInputField);


        JPanel buttons = new JPanel();
        search = new JButton(RecipePageViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(search);
        clear = new JButton("Clear");
        buttons.add(clear);
        Done = new JButton(RecipePageViewModel.Done_BUTTON_LABEL);
        buttons.add(Done);






        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(search)) {
                    // TODO: Add the controller
                }
            }
        });


        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(clear)) {
                    SearchWorkoutByNameState currentState = searchWorkoutByNameViewModel.getState();
                    currentState.setworkoutname("");
                    searchWorkoutByNameViewModel.setState(currentState);
                    searchWorkoutByNameViewModel.firePropertyChanged();

                }
            }
        });



        Done.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(Done)) {
                    viewManagerModel.setActiveView(workoutViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
            }
        });

        workoutnameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SearchWorkoutByNameState currentState = searchWorkoutByNameViewModel.getState();
                String text = workoutnameInputField.getText() + e.getKeyChar();
                currentState.setworkoutname(text);
                searchWorkoutByNameViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(workoutnameinfo);
        this.add(buttons);
    }





    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        RecipePageState state = (RecipePageState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(RecipePageState state) {
        workoutnameInputField.setText(state.getRecipename());

    }
}
