/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checker;

import java.util.Random;

import static checker.Checker.ini;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class result {

    int utility;
    ArrayList<Integer> data;

    result() {
        utility = 0;
        data = new ArrayList<Integer>();
    }

    result(int u, ArrayList<Integer> s) {
        data = new ArrayList<Integer>();

        utility = u;
        int i;
        for (i = 0; i < s.size(); i++) {
            data.add(s.get(i));
        }
    }

    result(int u, int sz) {
        data = new ArrayList<Integer>();

        utility = u;
        int i;
        for (i = 0; i < sz; i++) {
            data.add(i);
        }
    }

};

class compute {

    result nextmove(ArrayList<ArrayList<Integer>> ini, int ch, int dep) {

        int i, j, k, l;

        int ai = 0;
        int safe_ai = 0, safe_usr = 0;
        int usr = 0;

        int n = ini.size();

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (ini.get(i).get(j) >= 1) {
                    usr += ini.get(i).get(j);

                    if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                        safe_usr += ini.get(i).get(j);
                    }
                }
                if (ini.get(i).get(j) <= -1) {
                    ai += (-ini.get(i).get(j));

                    if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                        safe_ai += ((-ini.get(i).get(j)));
                    }
                }
            }
        }
//        vector<int> nn;
        ArrayList<Integer> nn = new ArrayList<Integer>();

        if (ai == 0) {
            return new result(Integer.MAX_VALUE, 0);
//            return {INT_MAX, nn
//  };
        }
        if (usr == 0) {
            return new result(Integer.MIN_VALUE, 0);
//            return {INT_MIN, nn
//            };
        }

        /*
        
        123
        456
        78-1
        
        
         */
        if (dep == 5) {
            int cost;

//            cost = 50 * (usr - ai) + 10 * (safe_usr - safe_ai);
            cost = 100 * (usr - ai) + 10 * (safe_usr-safe_ai) + (usr-ai);

            Random rd = new Random(); // creating Random object
            int rnd = rd.nextInt();
            rnd = (rnd % 3);

            cost += rnd;
            
//            return {cost, nn
//            };
            return new result(cost, nn);

        }

        if (ch == -1) {
            int noofmov = 0;

            int mini = Integer.MAX_VALUE;

            ArrayList<Integer> ret = new ArrayList<Integer>();
            ArrayList<Integer> movesf = new ArrayList<Integer>();
            ArrayList<Integer> movess = new ArrayList<Integer>();

            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (ini.get(i).get(j) <= -1) {
                        movesf.add(i);
                        movess.add(j);
                    }
//                    if (ini[i][j] == -1) {
//                        moves.PB(
//                    }
//                    {i, j
//                    });
                }
            }

            for (int itt = 0; itt < movesf.size(); itt++) {

                int x = movesf.get(itt);
                int y = movess.get(itt);
                int pp = ini.get(x).get(y);

                if (pp == -2) {

                    if (x > 0 && y > 0) {
//                    if (ini[x - 1][y - 1] == 0) {
                        if (ini.get(x - 1).get(y - 1) == 0) {

//                        ini[x - 1][y - 1] = 1;
//if(ini.get(x-1).get(y-1)==1){
                            ini.get(x - 1).set(y - 1, pp);
//                        ini[x][y] = 0;
                            ini.get(x).set(y, 0);

                            result it = nextmove(ini, -ch, dep + 1);
                            noofmov++;
                            if (it.utility < mini) {
                                mini = it.utility;
                                ret.clear();
                                ret.add(x);
                                ret.add(y);
                                ret.add(x - 1);
                                ret.add(y - 1);

                                ret.add(1);
                            }

//                        ini[x][y] = 1
                            ini.get(x).set(y, pp);

//                        ini[x - 1][y - 1] = 0;
                            ini.get(x - 1).set(y - 1, 0);

                            // return 1;
                        }
                    }
                    if (x > 0 && y + 1 < n) {
//                    if (ini[x - 1][y + 1] == 0) {
                        if (ini.get(x - 1).get(y + 1) == 0) {

//                        ini[x - 1][y + 1] = 1;
                            ini.get(x - 1).set(y + 1, pp);
//                        ini[x][y] = 0;
                            ini.get(x).set(y, 0);
                            result it = nextmove(ini, -ch, dep + 1);
                            noofmov++;

                            if (it.utility < mini) {
                                mini = it.utility;
                                ret.clear();
                                ret.add(x);
                                ret.add(y);
                                ret.add(x - 1);
                                ret.add(y + 1);
                                ret.add(1);
                            }
//                        ini[x][y] = 1;
                            ini.get(x).set(y, pp);

//                        ini[x - 1][y + 1] = 0;
                            ini.get(x - 1).set(y + 1, 0);

                            // return 2;
                        }
                    }

                    if (x - 2 >= 0 && y - 2 >= 0) {
//                        if 1(ini[x - 2][y - 2] == 0) {
                        if (ini.get(x - 2).get(y - 2) == 0) {
//                            if (ini[x - 1][y - 1] == -1) {
                            if (ini.get(x - 1).get(y - 1) >= 1) {
                                int qq = ini.get(x - 1).get(y - 1);

//                                ini[x - 2][y - 2] = 1;
                                ini.get(x - 2).set(y - 2, pp);

//                                ini[x][y] = 0;
                                ini.get(x).set(y, 0);

//                                ini[x - 1][y - 1] = 0;
                                ini.get(x - 1).set(y - 1, 0);

                                result it = nextmove(ini, -ch, dep + 1);
                                noofmov++;

                                if (it.utility < mini) {
                                    mini = it.utility;
                                    ret.clear();
                                    ret.add(x);
                                    ret.add(y);
                                    ret.add(x - 2);
                                    ret.add(y - 2);
                                    ret.add(1);
                                }
//                                ini[x - 1][y - 1] = -1;
                                ini.get(x - 1).set(y - 1, qq);

//                                ini[x][y] = 1;
                                ini.get(x).set(y, pp);

//                                ini[x - 2][y - 2] = 0;
                                ini.get(x - 2).set(y - 2, 0);

                                // return 3;
                            }
                        }
                    }

                    if (x - 2 >= 0 && y + 2 < n) {
//                        if (ini[x - 2][(y + 2)] == 0) {
                        if (ini.get(x - 2).get(y + 2) == 0) {
//                            if (ini[x - 1][y + 1] == -1) {

                            if (ini.get(x - 1).get(y + 1) >= 1) {
                                int qq = ini.get(x - 1).get(y + 1);

//                                ini[x - 2][y + 2] = 1;
                                ini.get(x - 2).set(y + 2, pp);
//                                ini[x][y] = 0;
                                ini.get(x).set(y, 0);

//                                ini[x - 1][y + 1] = 0;
                                ini.get(x - 1).set(y + 1, 0);

                                result it = nextmove(ini, -ch, dep + 1);
                                noofmov++;

                                if (it.utility < mini) {
                                    mini = it.utility;
                                    ret.clear();
                                    ret.add(x);
                                    ret.add(y);
                                    ret.add(x - 2);
                                    ret.add(y + 2);

                                    ret.add(1);
                                }
//                                ini[x - 1][y + 1] = -1;
                                ini.get(x - 1).set(y + 1, qq);
//                                ini[x][y] = 1;
                                ini.get(x).set(y, pp);

//                                ini[x - 2][y + 2] = 0;
                                ini.get(x - 2).set(y + 2, 0);
// return 4;
                            }
                        }
                    }

                }

                // xy
//             x-1 y-1  x-1 y+1
                if (x + 1 < n && y > 0) {
//                    if (ini[x + 1][y - 1] == 0) {
                    // return 1;

                    if (ini.get(x + 1).get(y - 1) == 0) {
//                        ini[x + 1][y - 1] = -1;
                        ini.get(x + 1).set(y - 1, pp);
//                        ini[x][y] = 0;
                        ini.get(x).set(y, 0);

                        result it = nextmove(ini, -ch, dep + 1);

                        noofmov++;
                        if (it.utility < mini) {

                            mini = it.utility;
                            ret.clear();
//                            ret.PB(x);
                            ret.add(x);

//                            ret.PB(y);
                            ret.add(y);
//                            ret.PB(x + 1);
                            ret.add(x + 1);
//                            ret.PB(y - 1);
                            ret.add(y - 1);

                            ret.add(-1);
//                            ret.PB(-1);
                        }

//                        ini[x][y] = -1;
                        ini.get(x).set(y, pp);
//                        ini[x + 1][y - 1] = 0;
                        ini.get(x + 1).set(y - 1, 0);

                    }
                }
                if (x + 1 < n && y + 1 < n) {
//                    if (ini[x + 1][y + 1] == 0) {
                    if (ini.get(x + 1).get(y + 1) == 0) {

//                        ini[x + 1][y + 1] = -1;
                        ini.get(x + 1).set(y + 1, pp);
//ini[x][y] = 0;
                        ini.get(x).set(y, 0);

                        result it = nextmove(ini, -ch, dep + 1);
                        noofmov++;
                        if (it.utility < mini) {
                            mini = it.utility;
                            ret.clear();
                            ret.add(x);
                            ret.add(y);
                            ret.add(x + 1);
                            ret.add(y + 1);

                            ret.add(-1);
                        }

//                        ini[x][y] = -1;
                        ini.get(x).set(y, pp);
//                        ini[x + 1][y + 1] = 0;
                        ini.get(x + 1).set(y + 1, 0);

                        // return 2;
                    }
                }

                if (x + 2 < n && y - 2 >= 0) {
//                    if (ini[x + 2][y - 2] == 0) {
                    if (ini.get(x + 2).get(y - 2) == 0) {
//                        if (ini[x + 1][y - 1] == 1) {
                        if (ini.get(x + 1).get(y - 1) >= 1) {
                            int qq = ini.get(x + 1).get(y - 1);

//                            ini[x + 2][y - 2] = -1;
                            ini.get(x + 2).set(y - 2, pp);
//                            ini[x][y] = 0;
                            ini.get(x).set(y, 0);

//                            ini[x + 1][y - 1] = 0;
                            ini.get(x + 1).set(y - 1, 0);

                            result it = nextmove(ini, -ch, dep + 1);
                            noofmov++;

                            if (it.utility < mini) {
                                mini = it.utility;
                                ret.clear();
                                ret.add(x);
                                ret.add(y);
                                ret.add(x + 2);
                                ret.add(y - 2);

                                ret.add(-1);
                            }

//                            ini[x + 1][y - 1] = 1;
                            ini.get(x + 1).set(y - 1, qq);
//                            ini[x][y] = -1;
                            ini.get(x).set(y, pp);
//                            ini[x + 2][y - 2] = 0;
                            ini.get(x + 2).set(y - 2, 0);

                            // return 3;
                        }
                    }
                }

                if (x + 2 < n && y + 2 < n) {
//                    if (ini[x + 2][y + 2] == 0) {
                    if (ini.get(x + 2).get(y + 2) == 0) {
//                        if (ini[x + 1][y + 1] == 1) {
                        if (ini.get(x + 1).get(y + 1) >= 1) {
                            int qq = ini.get(x + 1).get(y + 1);

//                            ini[x + 2][y + 2] = -1;
                            ini.get(x + 2).set(y + 2, pp);
//                         -   ini[x][y] = 0;
                            ini.get(x).set(y, 0);

//                            ini[x + 1][y + 1] = 0;
                            ini.get(x + 1).set(y + 1, 0);

                            result it = nextmove(ini, -ch, dep + 1);
                            noofmov++;

                            if (it.utility < mini) {
                                mini = it.utility;
                                ret.clear();
                                ret.add(x);
                                ret.add(y);
                                ret.add(x + 2);
                                ret.add(y + 2);

                                ret.add(-1);
                            }

//                            ini[x + 1][y + 1] = 1;
                            ini.get(x + 1).set(y + 1, qq);

//                            ini[x][y] = -1;
                            ini.get(x).set(y, pp);
//                            ini[x + 2][y + 2] = 0;
                            ini.get(x + 2).set(y + 2, 0);
                            // return 4;
                        }
                    }
                }

                // return 0;
            }

            if (noofmov == 0) {

                return nextmove(ini, -ch, dep + 1);
            }
            if (mini == Integer.MAX_VALUE) {
                return nextmove(ini, -ch, dep + 1);

                // draw
                // return {0, ret};
                // cerr << "no moves available";
                // exit(0);
                // return {mini, ret};
            }
            return new result(mini, ret);
//            return {mini, ret
//            };
        } else {

            int numofmov = 0;

            int maxi = Integer.MIN_VALUE;

//            vector<int> ret;
            ArrayList<Integer> ret = new ArrayList<Integer>();

//            vector<pair<int, int>> moves;
            ArrayList<Integer> movesf = new ArrayList<Integer>();
            ArrayList<Integer> movess = new ArrayList<Integer>();

            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
//                    if (ini[i][j] == 1) {
                    if (ini.get(i).get(j) >= 1) {
//                        moves.PB(
//                    }
//                    {i, j
//                    });
                        movesf.add(i);
                        movess.add(j);
                    }
                }

            }

            for (int itt = 0; itt < movesf.size(); itt++) {
                int x = movesf.get(itt);
                int y = movess.get(itt);

                int pp = ini.get(x).get(y);

                if (pp == 2) {

                    if (x + 1 < n && y > 0) {
//                    if (ini[x + 1][y - 1] == 0) {
                        // return 1;

                        if (ini.get(x + 1).get(y - 1) == 0) {
//                        ini[x + 1][y - 1] = -1;
                            ini.get(x + 1).set(y - 1, pp);
//                        ini[x][y] = 0;
                            ini.get(x).set(y, 0);

                            result it = nextmove(ini, -ch, dep + 1);

                            numofmov++;
                            if (it.utility > maxi) {

                                maxi = it.utility;
                                ret.clear();
//                            ret.PB(x);
                                ret.add(x);

//                            ret.PB(y);
                                ret.add(y);
//                            ret.PB(x + 1);
                                ret.add(x + 1);
//                            ret.PB(y - 1);
                                ret.add(y - 1);

                                ret.add(-1);
//                            ret.PB(-1);
                            }

//                        ini[x][y] = -1;
                            ini.get(x).set(y, pp);
//                        ini[x + 1][y - 1] = 0;
                            ini.get(x + 1).set(y - 1, 0);

                        }
                    }
                    if (x + 1 < n && y + 1 < n) {
//                    if (ini[x + 1][y + 1] == 0) {
                        if (ini.get(x + 1).get(y + 1) == 0) {

//                        ini[x + 1][y + 1] = -1;
                            ini.get(x + 1).set(y + 1, pp);
//ini[x][y] = 0;
                            ini.get(x).set(y, 0);

                            result it = nextmove(ini, -ch, dep + 1);
                            numofmov++;
                            if (it.utility > maxi) {
                                maxi = it.utility;
                                ret.clear();
                                ret.add(x);
                                ret.add(y);
                                ret.add(x + 1);
                                ret.add(y + 1);

                                ret.add(-1);
                            }

//                        ini[x][y] = -1;
                            ini.get(x).set(y, pp);
//                        ini[x + 1][y + 1] = 0;
                            ini.get(x + 1).set(y + 1, 0);

                            // return 2;
                        }
                    }

                    if (x + 2 < n && y - 2 >= 0) {
//                    if (ini[x + 2][y - 2] == 0) {
                        if (ini.get(x + 2).get(y - 2) == 0) {
//                        if (ini[x + 1][y - 1] == 1) {
                            if (ini.get(x + 1).get(y - 1) <= -1) {
                                int qq = ini.get(x + 1).get(y - 1);

//                            ini[x + 2][y - 2] = -1;
                                ini.get(x + 2).set(y - 2, pp);
//                            ini[x][y] = 0;
                                ini.get(x).set(y, 0);

//                            ini[x + 1][y - 1] = 0;
                                ini.get(x + 1).set(y - 1, 0);

                                result it = nextmove(ini, -ch, dep + 1);
                                numofmov++;

                                if (it.utility > maxi) {
                                    maxi = it.utility;
                                    ret.clear();
                                    ret.add(x);
                                    ret.add(y);
                                    ret.add(x + 2);
                                    ret.add(y - 2);

                                    ret.add(-1);
                                }

//                            ini[x + 1][y - 1] = 1;
                                ini.get(x + 1).set(y - 1, qq);
//                            ini[x][y] = -1;
                                ini.get(x).set(y, pp);
//                            ini[x + 2][y - 2] = 0;
                                ini.get(x + 2).set(y - 2, 0);

                                // return 3;
                            }
                        }
                    }

                    if (x + 2 < n && y + 2 < n) {
//                    if (ini[x + 2][y + 2] == 0) {
                        if (ini.get(x + 2).get(y + 2) == 0) {
//                        if (ini[x + 1][y + 1] == 1) {
                            if (ini.get(x + 1).get(y + 1) <= -1) {
                                int qq = ini.get(x + 1).get(y + 1);

//                            ini[x + 2][y + 2] = -1;
                                ini.get(x + 2).set(y + 2, pp);
//                         -   ini[x][y] = 0;
                                ini.get(x).set(y, 0);

//                            ini[x + 1][y + 1] = 0;
                                ini.get(x + 1).set(y + 1, 0);

                                result it = nextmove(ini, -ch, dep + 1);
                                numofmov++;

                                if (it.utility > maxi) {
                                    maxi = it.utility;
                                    ret.clear();
                                    ret.add(x);
                                    ret.add(y);
                                    ret.add(x + 2);
                                    ret.add(y + 2);

                                    ret.add(-1);
                                }

//                            ini[x + 1][y + 1] = 1;
                                ini.get(x + 1).set(y + 1, qq);

//                            ini[x][y] = -1;
                                ini.get(x).set(y, pp);
//                            ini[x + 2][y + 2] = 0;
                                ini.get(x + 2).set(y + 2, 0);
                                // return 4;
                            }
                        }
                    }

                }

                if (x > 0 && y > 0) {
//                    if (ini[x - 1][y - 1] == 0) {
                    if (ini.get(x - 1).get(y - 1) == 0) {

//                        ini[x - 1][y - 1] = 1;
//if(ini.get(x-1).get(y-1)==1){
                        ini.get(x - 1).set(y - 1, pp);
//                        ini[x][y] = 0;
                        ini.get(x).set(y, 0);

                        result it = nextmove(ini, -ch, dep + 1);
                        numofmov++;
                        if (it.utility > maxi) {
                            maxi = it.utility;
                            ret.clear();
                            ret.add(x);
                            ret.add(y);
                            ret.add(x - 1);
                            ret.add(y - 1);

                            ret.add(1);
                        }

//                        ini[x][y] = 1
                        ini.get(x).set(y, pp);

//                        ini[x - 1][y - 1] = 0;
                        ini.get(x - 1).set(y - 1, 0);

                        // return 1;
                    }
                }
                if (x > 0 && y + 1 < n) {
//                    if (ini[x - 1][y + 1] == 0) {
                    if (ini.get(x - 1).get(y + 1) == 0) {

//                        ini[x - 1][y + 1] = 1;
                        ini.get(x - 1).set(y + 1, pp);
//                        ini[x][y] = 0;
                        ini.get(x).set(y, 0);
                        result it = nextmove(ini, -ch, dep + 1);
                        numofmov++;

                        if (it.utility > maxi) {
                            maxi = it.utility;
                            ret.clear();
                            ret.add(x);
                            ret.add(y);
                            ret.add(x - 1);
                            ret.add(y + 1);
                            ret.add(1);
                        }
//                        ini[x][y] = 1;
                        ini.get(x).set(y, pp);

//                        ini[x - 1][y + 1] = 0;
                        ini.get(x - 1).set(y + 1, 0);

                        // return 2;
                    }
                }

                if (x - 2 >= 0 && y - 2 >= 0) {
//                        if 1(ini[x - 2][y - 2] == 0) {
                    if (ini.get(x - 2).get(y - 2) == 0) {
//                            if (ini[x - 1][y - 1] == -1) {
                        if (ini.get(x - 1).get(y - 1) <= -1) {
                            int qq = ini.get(x - 1).get(y - 1);

//                                ini[x - 2][y - 2] = 1;
                            ini.get(x - 2).set(y - 2, pp);

//                                ini[x][y] = 0;
                            ini.get(x).set(y, 0);

//                                ini[x - 1][y - 1] = 0;
                            ini.get(x - 1).set(y - 1, 0);

                            result it = nextmove(ini, -ch, dep + 1);
                            numofmov++;

                            if (it.utility > maxi) {
                                maxi = it.utility;
                                ret.clear();
                                ret.add(x);
                                ret.add(y);
                                ret.add(x - 2);
                                ret.add(y - 2);
                                ret.add(1);
                            }
//                                ini[x - 1][y - 1] = -1;
                            ini.get(x - 1).set(y - 1, qq);

//                                ini[x][y] = 1;
                            ini.get(x).set(y, pp);

//                                ini[x - 2][y - 2] = 0;
                            ini.get(x - 2).set(y - 2, 0);

                            // return 3;
                        }
                    }
                }

                if (x - 2 >= 0 && y + 2 < n) {
//                        if (ini[x - 2][(y + 2)] == 0) {
                    if (ini.get(x - 2).get(y + 2) == 0) {
//                            if (ini[x - 1][y + 1] == -1) {

                        if (ini.get(x - 1).get(y + 1) <= -1) {
                            int qq = ini.get(x - 1).get(y + 1);

//                                ini[x - 2][y + 2] = 1;
                            ini.get(x - 2).set(y + 2, pp);
//                                ini[x][y] = 0;
                            ini.get(x).set(y, 0);

//                                ini[x - 1][y + 1] = 0;
                            ini.get(x - 1).set(y + 1, 0);

                            result it = nextmove(ini, -ch, dep + 1);
                            numofmov++;

                            if (it.utility > maxi) {
                                maxi = it.utility;
                                ret.clear();
                                ret.add(x);
                                ret.add(y);
                                ret.add(x - 2);
                                ret.add(y + 2);

                                ret.add(1);
                            }
//                                ini[x - 1][y + 1] = -1;
                            ini.get(x - 1).set(y + 1, qq);
//                                ini[x][y] = 1;
                            ini.get(x).set(y, pp);

//                                ini[x - 2][y + 2] = 0;
                            ini.get(x - 2).set(y + 2, 0);
// return 4;
                        }
                    }
                }

                // return 0;
            }

            if (numofmov == 0) {
                return nextmove(ini, -ch, dep + 1);
            }

            if (maxi == Integer.MIN_VALUE) {
                return nextmove(ini, -ch, dep + 1);

                // cerr << "no moves available";
                // exit(0);
                // return {0, ret};
                // draww
            }
//                return {maxi, ret
//                };
            return new result(maxi, ret);
        }

//        return new result(0, 0);
    }

};

class state {

    int remone = 12;
    int remminus = 12;

    int chance;

    int acquired;
    int acqx, acqy;

    ArrayList<ArrayList<Integer>> board;
    int n;

    int movepossible(int x, int y) {
        int i, j, k, l;

        int n = this.n;

        int ch = this.board.get(x).get(y);

        if (ch == 0) {
            return 1;
        }

        if (ch >= 1) {

            if (x > 0 && y > 0) {
                if (this.board.get(x - 1).get(y - 1) == 0) {
                    return 1;
                }

            }
            if (x > 0 && y + 1 < n) {
                if (this.board.get(x - 1).get(y + 1) == 0) {
                    return 2;
                }

            }

            if (x - 2 >= 0 && y - 2 >= 0) {
                if (this.board.get(x - 2).get(y - 2) == 0) {
                    if (this.board.get(x - 1).get(y - 1) == -1) {
                        return 3;
                    }
                }
            }

            if (x - 2 >= 0 && y + 2 < n) {
                if (this.board.get(x - 2).get(y + 2) == 0) {
                    if (this.board.get(x - 1).get(y + 1) == -1) {
                        return 4;
                    }
                }
            }

            if (ch == 2) {

                if (x + 1 < n && y > 0) {
                    if (ini.board.get(x + 1).get(y - 1) == 0) {
                        return 5;
                    }
                }

                if (x + 1 < n && y + 1 < n) {
                    if (ini.board.get(x + 1).get(y + 1) == 0) {
                        return 6;
                    }
                }

                if (x + 2 < n && y - 2 >= 0) {
                    if (ini.board.get(x + 2).get(y - 2) == 0) {
                        if (ini.board.get(x + 1).get(y - 1) < 0) {
                            return 7;
                        }

                    }

                }

                if (x + 2 < n && y + 2 < n) {
                    if (ini.board.get(x + 2).get(y + 2) == 0) {
                        if (ini.board.get(x + 1).get(y + 1) < 0) {
                            return 8;
                        }
                    }
                }

            }

            return 0;

        } else {

            if (x + 1 < n && y > 0) {
                if (this.board.get(x + 1).get(y - 1) == 0) {
                    return 1;
                }

            }
            if (x + 1 < n && y + 1 < n) {
                if (this.board.get(x + 1).get(y + 1) == 0) {
                    return 2;
                }

            }

            if (x + 2 < n && y - 2 >= 0) {
                if (this.board.get(x + 2).get(y - 2) == 0) {
                    if (this.board.get(x + 1).get(y - 1) == -1) {
                        return 3;
                    }
                }
            }

            if (x + 2 < n && y + 2 < n) {
                if (this.board.get(x + 2).get(y + 2) == 0) {
                    if (this.board.get(x + 1).get(y + 1) == -1) {
                        return 4;
                    }
                }
            }

            if (ch == -2) {

                if (x - 1 >= 0 && y > 0) {
                    if (ini.board.get(x - 1).get(y - 1) == 0) {
                        return 5;
                    }
                }

                if (x - 1 >= 0 && y + 1 < n) {
                    if (ini.board.get(x - 1).get(y + 1) == 0) {
                        return 6;
                    }
                }

                if (x - 2 >= 0 && y - 2 >= 0) {
                    if (ini.board.get(x - 2).get(y - 2) == 0) {
                        if (ini.board.get(x - 1).get(y - 1) > 0) {
                            return 7;
                        }

                    }

                }

                if (x - 2 >= 0 && y + 2 < n) {
                    if (ini.board.get(x - 2).get(y + 2) == 0) {
                        if (ini.board.get(x - 1).get(y + 1) > 0) {
                            return 8;
                        }
                    }
                }

            }

            return 0;

        }

//        return 1;
    }

    state(int nn) {
        acquired = 0;

        chance = 1;

        int i, j;

        this.n = nn;
        board = new ArrayList<ArrayList<Integer>>();

        for (i = 0; i < nn; i++) {
            ArrayList<Integer> ss = new ArrayList<Integer>();

            for (j = 0; j < nn; j++) {
                ss.add(0);
            }

            board.add(ss);
        }
    }

};

public class Checker {

    public static state ini;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new maine().setVisible(true);

        int i, j, k, l;

        int n = 8;

        ini = new state(n);

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                ini.board.get(i).set(j, 0);
            }
        }
        k = 3;

        for (i = 0; i < k; i++) {
            for (j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    ini.board.get(i).set(j, -1);
                }
            }
        }

        for (i = n - 1; i >= n - k; i--) {
            for (j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    ini.board.get(i).set(j, 1);
                }
            }
        }

//        ini.board.get(4).set(4, 2);

        ini.chance = 1;
        ini.acquired = 0;

    }

};
