package vudroid.core.models;


import vudroid.core.events.CurrentPageListener;
import vudroid.core.events.EventDispatcher;

public class CurrentPageModel extends EventDispatcher {
    private int currentPageIndex;

    public void setCurrentPageIndex(int currentPageIndex) {
        if (this.currentPageIndex != currentPageIndex) {
            this.currentPageIndex = currentPageIndex;
            dispatch(new CurrentPageListener.CurrentPageChangedEvent(currentPageIndex));
        }
    }
}
