package seedu.studybananas.ui.util;


public interface Observable {

    public void register(Observer<?> reader);

    public void unregister(Observer<?> reader);

    public void inform();
}
