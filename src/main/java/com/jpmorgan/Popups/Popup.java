package com.jpmorgan.Popups;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public abstract class Popup {

    private final AnchorPane anchorPane;

    private Node content;

    public Popup(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public void openPopup() {
        content = createContent();
        content.setId("popup");
        anchorPane.getChildren().add(content);
    }

    public void changeContent(Node newContent) {
        newContent.setId("popup");
        int index = anchorPane.getChildren().indexOf(content);
        anchorPane.getChildren().set(index, newContent);
    }


    protected abstract Node createContent();

    protected void changeContentToSelf(Popup popup) {
        Node node = createContent();
        popup.changeContent(node);
    }

    public void closePopup() {
        anchorPane.getChildren().removeIf(node -> node.getId() != null && node.getId().equals("popup"));
    }

    public Node getContent() {
        return content;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
