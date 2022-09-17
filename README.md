# pdfviewer
A simple PDF viewer library for android apps with Android X support

How to use library:

1] Build.gradle (Project)

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

2] Build.gradle (Module)

    implementation 'com.github.surajsahijwani:pdfviewer:1.0.1'

3] Java code

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

4] XML code

    <com.surajsahijwani.pdflibrary.PDFView
        android:id="@+id/pdfView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
