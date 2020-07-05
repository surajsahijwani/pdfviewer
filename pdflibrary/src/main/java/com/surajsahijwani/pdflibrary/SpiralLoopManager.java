package com.surajsahijwani.pdflibrary;

class SpiralLoopManager {

    private SpiralLoopListener listener;

    public SpiralLoopManager(SpiralLoopListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("SpiralLoopListener must not be null");
        }
        this.listener = listener;
    }

    public void startLoop(int nbRows, int nbCols, int startRow, int startCol) {

        int totalNbCells = nbCols * nbRows;
        int nbMarkedCells = 0;

        int row = startRow, col = startCol;
        int progress = 1;
        int variation = 1;

        // First row
        listener.onLoop(row, col);
        nbMarkedCells++;

        while (nbMarkedCells < totalNbCells) {

            // Progress horizontal
            for (int i = 0; i < progress; i++) {
                row += variation;
                if (isValidCell(row, col, nbRows, nbCols)) {
                    nbMarkedCells++;
                    boolean canContinue = listener.onLoop(row, col);
                    if (!canContinue) return;
                }
            }

            // Progress vertical
            for (int i = 0; i < progress; i++) {
                col += variation;
                if (isValidCell(row, col, nbRows, nbCols)) {
                    nbMarkedCells++;
                    boolean canContinue = listener.onLoop(row, col);
                    if (!canContinue) return;
                }
            }

            // Change size of progress
            progress++;

            // Change sign of variation
            variation *= -1;
        }
    }

    private boolean isValidCell(int row, int col, int nbRows, int nbCols) {
        return !(row < 0 || row >= nbRows || col < 0 || col >= nbCols);
    }

    public static interface SpiralLoopListener {
        /**
         * Called on loop update
         * @param row The row number (starting with 0)
         * @param col The col number (starting with 0)
         * @return true if you want to continue, false otherwise
         */
        boolean onLoop(int row, int col);
    }
}
