import java.util.Arrays;

public class DisjointSet {
    int[] parents;
    int[] sizes;
    int[] ranks;
    int numOfSets;

    DisjointSet(int n){
        parents = new int[n];
        ranks = new int[n];
        sizes = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = i;
        }
        Arrays.fill(sizes, 1);
    }
    
    public int union(int a, int b){
        // union by rank heuristic
        int rootA = findSet(a);
        int rootB = findSet(b);
		    if(rootA == rootB)
		      return -1;
			
        if(ranks[rootA]>ranks[rootB]){
            parents[rootB] = rootA;
            sizes[rootA] += sizes[rootB];
            numOfSets--;
            // here we are returning the size of the union set
            return sizes[rootA];
        } else {
            parents[rootA] = rootB;
            sizes[rootB] += sizes[rootA];
            if(ranks[rootB]==ranks[rootA]){
                ranks[rootB]++;
            }
            numOfSets--;
            return sizes[rootB];
        }
    }
    
    public int findSet(int i){
        // path compression heuristic
        if(parents[i]!=i)
            parents[i] = findSet(parents[i]);
        return parents[i];
    }
}
