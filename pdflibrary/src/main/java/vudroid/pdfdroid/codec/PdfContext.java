package vudroid.pdfdroid.codec;

import android.content.ContentResolver;

import vudroid.core.VuDroidLibraryLoader;
import vudroid.core.codec.CodecContext;
import vudroid.core.codec.CodecDocument;


public class PdfContext implements CodecContext {
    static {
        VuDroidLibraryLoader.load();
    }

    public CodecDocument openDocument(String fileName) {
        return PdfDocument.openDocument(fileName, "");
    }

    public void setContentResolver(ContentResolver contentResolver) {
        //TODO
    }

    public void recycle() {
    }
}
