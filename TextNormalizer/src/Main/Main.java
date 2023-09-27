package Main;


import controller.TextNormalizerController;
import model.TextNormalizer;
import view.TextNormalizerView;

public class Main {

    public static void main(String[] args) {
        TextNormalizer model = new TextNormalizer();
        TextNormalizerView view = new TextNormalizerView();
        TextNormalizerController controller = new TextNormalizerController(model, view);

        String inputFileName = "C:\\Users\\TechCare\\OneDrive\\Documents\\NetBeansProjects\\TextNormalizer\\src\\resources\\input.txt";
        String outputFileName = "C:\\Users\\TechCare\\OneDrive\\Documents\\NetBeansProjects\\TextNormalizer\\src\\resources\\output.txt";

        controller.normalizeTextFromFile(inputFileName, outputFileName);
    }
}
