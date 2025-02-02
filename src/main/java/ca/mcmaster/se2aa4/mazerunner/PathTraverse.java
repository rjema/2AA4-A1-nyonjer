// // package ca.mcmaster.se2aa4.mazerunner;

// public class PathTraverse {
//     private Path path;
//     private Runner runner;

//     public PathTraverse(Path path, Runner runner){
//         this.maze = maze;
//         this.runner = runner;
//     }

    // public boolean leftTraversal(){
    //     int r = entry.leftRow();
    //     int c = entry.leftCol();

    //     int exitRow = entry.rightRow();
    //     int exitCol = entry.rightCol();

    //     int i = 0;

    //     String expandedPath = path.getCanonPath();

    //     if (expandedPath.length() != exitCol+1){
    //         return "Incorrect path";
    //     }

    //     while (i < expandedPath.length() && r <= exitRow && c <= exitCol){

    //         if (expandedPath.charAt(i) == 'F'){
    //             i++;
    //         } else {
    //             return "Incorrect path";
    //         }

    //         if (r == exitRow && c == exitCol){
    //             return "Correct path";
    //         }
    //         c++; 
    //     }

    //     return "Incorrect path";
    // }

//     public boolean rightTraversal(){
//         return false;
//     }

//     public String traverse(){
//         if (leftTraversal()){
//             return "Correct path";
//         } else if (rightTraversal()){
//             return "Correct path";
//         } else {
//             return "Incorrect path";
//         }
//     }
// }

