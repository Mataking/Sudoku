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


    public String chiffresPossibles(CGrille9x9 g, int l, int c) {

    /* au depart, tout est possible */
        boolean[] hyp = new boolean[9];
        for (int i = 0; i < hyp.length; i++)
            hyp[i] = true;

    /* invalide les chiffres sur la ligne */
        for (int idxc = 0; idxc < 9; idxc++) {
            int nb = g.get(idxc + 1, l);
            if (nb != 0) {
                hyp[nb - 1] = false;
            }
        }
    /* invalide les chiffre sur la colonne */
        for (int idxl = 0; idxl < 9; idxl++) {
            int nb = g.get(c, idxl + 1);
            if (nb != 0) {
                hyp[nb - 1] = false;
            }
        }
    /* invalide les chiffre dans le bloc */
        int[] debc = {0, 0, 0, 3, 3, 3, 6, 6, 6}; // debut d'un bloc (colonne)
        int[] debl = {0, 0, 0, 3, 3, 3, 6, 6, 6}; // debut d'un bloc (ligne)
        int col = debc[c - 1];  // 1er elem colonne du bloc
        int lig = debl[l - 1];  // 1er elem ligne du bloc
    // recopie bloc dans une ligne pour simplifier
        int elem[] = new int[9];
        int rang = 0;
        for (int idxc = col; idxc < col + 3; idxc++) {
            for (int idxl = lig; idxl < lig + 3; idxl++) {
                elem[rang++] = g.get(idxc + 1, idxl + 1);
            }
        }
    // tous chiffres compris entre 0 et 9
        for (int idx = 0; idx < 9; idx++) {
            if (elem[idx] != 0) {
                hyp[elem[idx] - 1] = false;
            }
        }

        String chiffres = "";
        for (int t = 0; t < 9; t++) {
            if (hyp[t]) {
                chiffres = chiffres + (t + 1);
            }
        }
        return chiffres;
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

