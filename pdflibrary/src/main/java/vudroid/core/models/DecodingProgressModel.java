package vudroid.core.models;

import vudroid.core.events.DecodingProgressListener;
import vudroid.core.events.EventDispatcher;

public class DecodingProgressModel extends EventDispatcher {
    private int currentlyDecoding;

    public void increase() {
        currentlyDecoding++;
        dispatchChanged();
    }

    private void dispatchChanged() {
        dispatch(new DecodingProgressListener.DecodingProgressEvent(currentlyDecoding));
    }

    public void decrease() {
        currentlyDecoding--;
        dispatchChanged();
    }
}
