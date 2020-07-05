package com.surajsahijwani.pdflibrary;

import android.net.Uri;
import android.os.AsyncTask;

import vudroid.core.DecodeService;
import vudroid.core.DecodeServiceBase;
import vudroid.pdfdroid.codec.PdfContext;

public class DecodingAsyncTask extends AsyncTask<Void, Void, Void> {

    /**
     * The decode service used for decoding the PDF
     */
    private DecodeService decodeService;

    private boolean cancelled;

    private Uri uri;

    private PDFView pdfView;

    public DecodingAsyncTask(Uri uri, PDFView pdfView) {
        this.cancelled = false;
        this.pdfView = pdfView;
        this.uri = uri;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            decodeService = new DecodeServiceBase(new PdfContext());
            decodeService.setContentResolver(pdfView.getContext().getContentResolver());
            decodeService.open(uri);
        } catch (RuntimeException rte) {
            cancelled = true;
            decodeService = null;
        }
        return null;
    }

    protected void onPostExecute(Void result) {
        if (!cancelled) {
            pdfView.loadComplete(decodeService);
        }
    }

    protected void onCancelled() {
        cancelled = true;
    }
}
