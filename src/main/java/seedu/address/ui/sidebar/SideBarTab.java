package seedu.address.ui.sidebar;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import seedu.address.ui.UiPart;

public class SideBarTab extends UiPart<Region> {
    private static final String FXML = "SideBarTab.fxml";

    @FXML
    private ImageView tabImage;
    @FXML
    private Label tabText;

    public SideBarTab(Image image, String description) {
        super(FXML);
        tabImage.setImage(image);
        tabText.setText(description);
    }
}
