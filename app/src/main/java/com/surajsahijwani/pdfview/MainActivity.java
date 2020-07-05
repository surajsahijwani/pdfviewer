package com.surajsahijwani.pdfview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.surajsahijwani.pdflibrary.PDFView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private PDFView pdfView;
    private String downloadDirectoryName = "/Download";

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

        String mFilePath = android.os.Environment.getExternalStorageDirectory() + downloadDirectoryName;
        File file = new File(mFilePath, "document.pdf");
        if (file.exists()) {

            pdfView.fromFile(new File(file.getPath()))
                    .enableSwipe(true)
                    .swipeVertical(true)
                    .defaultPage(0)
                    .load();
        }
    }
}