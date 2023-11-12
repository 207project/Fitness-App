package interface_adapter.RecipeCancelButton;
import use_case.RecipeCancelButton.RecipeDoneInputBoundary;

public class RecipeDoneController {

    final RecipeDoneInputBoundary recipeCancelInputBoundary;

    public RecipeDoneController(RecipeDoneInputBoundary recipeCancelInputBoundary) {

        this.recipeCancelInputBoundary = recipeCancelInputBoundary;
    }

    public void execute() {

        recipeCancelInputBoundary.execute();
    }

}