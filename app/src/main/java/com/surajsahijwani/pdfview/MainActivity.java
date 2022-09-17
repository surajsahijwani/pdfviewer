package com.surajsahijwani.pdfview;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.surajsahijwani.pdflibrary.PDFView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdfView = findViewById(R.id.pdfview);

        loadPDF();
    }

    /**
     * Function to load PDF from storage
     */
    private void loadPDF() {

        String PDF_EXTENSION = ".pdf";
        String downloadDirectoryName = "/Download";
        String downloadFileName = "document";
        File file;

        try {
            file = new File(Environment.getExternalStorageDirectory() + downloadDirectoryName + "/" + downloadFileName + PDF_EXTENSION);
        } catch (Exception e) {
            try {
                file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "/" + downloadFileName + PDF_EXTENSION);
            } catch (Exception ex) {
                file = new File(String.valueOf(getExternalFilesDir(downloadFileName + PDF_EXTENSION)));
            }
        }

        if (file.exists()) {

            File finalFile = file;
            new Handler().postDelayed(() -> pdfView.fromFile(new File(finalFile.getPath()))
                    .enableSwipe(true)
                    .swipeVertical(true)
                    .defaultPage(1)
                    .load(), 100);

        }
    }
}