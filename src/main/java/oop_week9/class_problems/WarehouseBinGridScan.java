package main.java.oop_week9.class_problems;

public class WarehouseBinGridScan {
    public static class Summary {
        public int totalItems;
        public int maxRow;
        public int maxCol;

        public Summary(int totalItems, int maxRow, int maxCol) {
            this.totalItems = totalItems;
            this.maxRow = maxRow;
            this.maxCol = maxCol;
        }

        @Override
        public String toString() {
            return "total = " + totalItems + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")";
        }
    }

    public static Summary warehouseSummary(int[][] grid) {
        int totalItems = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                totalItems += grid[r][c];
                if (grid[r][c] > maxVal) {
                    maxVal = grid[r][c];
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        return new Summary(totalItems, maxRow, maxCol);
    }
}