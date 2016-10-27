package sudokupattern;

import sudokupattern.Observer.CGrille9x9;
import sudokupattern.Interface.CSolveur9x9Impl;

public class CSolveur9x9 implements CSolveur9x9Impl {

    // Sudoku size K=square size, N=grid size (N=K*K)
    private final int K = 3;
    private final int N = 9;

    // the grid to solve
    private int[][] solution;

    // marker for the initial (fixed) values
    private boolean[][] fixed;

    // locks on the rows, columns and squares
    private boolean[][] lockrow, lockcol, locksqr;

    // initialize/reset structures
    private void initialize() {
        solution = new int[N][N];
        fixed = new boolean[N][N];
        lockrow = new boolean[N][N];
        lockcol = new boolean[N][N];
        locksqr = new boolean[N][N];
    }

    // load initial grid
    private void load(String grid) {
        for (int i = 0; i < grid.length(); i++) {
            char c = grid.charAt(i);
            int row = i / N, col = i % N, val = c - '0';
            if (c == '.') continue;
            solution[row][col] = val;
            fixed[row][col] = true;
            setlock(row, col, val, true);
        }
    }

    // set/unset locks for the tuple (row,col,value)
    private void setlock(int row, int col, int val, boolean state) {
        int sqr = (col / this.K) + this.K * (row / this.K);
        this.lockrow[row][val - 1] = state;
        this.lockcol[col][val - 1] = state;
        this.locksqr[sqr][val - 1] = state;
    }

    // check if a tuple (row,col,value) is locked
    private boolean islocked(int row, int col, int val) {
        if (this.lockrow[row][val - 1]) return true;
        if (this.lockcol[col][val - 1]) return true;
        int sqr = (col / this.K) + this.K * (row / this.K);
        if (this.locksqr[sqr][val - 1]) return true;
        return false;
    }

    //conversion from Cgrille object to string object
    public String gridToString(CGrille9x9 grid) {
        String grid_string = new String();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid.get(j + 1, i + 1) == 0) {
                    grid_string += ".";
                } else {
                    grid_string += grid.get(j + 1, i + 1);
                }
            }
        }
        return grid_string;
    }

    // solver
    public CGrille9x9 solve(CGrille9x9 grid) {

        String grid_string = gridToString(grid);

        // init structures
        initialize();

        // load and print initial grid
        load(grid_string);

        boolean backtrack = false;
        int position = 0;

        // complete tree exploration with backtracking
        while (position >= 0 && position < N * N) {
            int row = position / N;
            int col = position % N;

            // fixed cell : skip  and continue
            if (fixed[row][col]) {
                if (backtrack) position--;
                else position++;
                continue;
            }

            // remove the previous lock (if any)
            if (solution[row][col] > 0) setlock(row, col, solution[row][col], false);

            // lookup for a possible value
            int val = solution[row][col] + 1;
            while (val <= N && islocked(row, col, val)) val++;

            if (val <= N) {
                // value found: add to current solution
                solution[row][col] = val;
                // set the lock
                setlock(row, col, val, true);
                // go next
                backtrack = false;
                position++;
            } else {
                // no value found: backtrack
                solution[row][col] = 0;
                // go previous
                backtrack = true;
                position--;
            }
            // end loop
        }

        // exited the loop while backtracking => no solution.
        if (position < 0) {
            System.out.println("Pas de solution !!!");
            return null;
        } else {

            //Avert the observer a new solution
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid.set(i + 1, j + 1, solution[i][j]);
                }
            }

            return grid;
        }
    }
}

