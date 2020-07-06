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

    String mFilePath = android.os.Environment.getExternalStorageDirectory() + "\Download";
        File file = new File(mFilePath, "document.pdf");
        if (file.exists()) {

            pdfView.fromFile(new File(file.getPath()))
                    .enableSwipe(true)
                    .swipeVertical(true)
                    .defaultPage(1)
                    .load();
        }

4] XML code

    <com.surajsahijwani.pdflibrary.PDFView
        android:id="@+id/pdfView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
