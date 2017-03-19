
public class DijkstraSP 
{
	private double[] distTo;          // distTo[v] = distance  of shortest s->v path
    private DirectedEdge[] edgeTo;    // edgeTo[v] = last edge on shortest s->v path
    private IndexMinPQ<Double> pq;    // priority queue of vertices
	
    
    public DijkstraSP(EdgeWeightedDigraph G, int s) {
       
    	edgeTo = new DirectedEdge[G,V()];
    	distTo = new double[G,V()];
        pq = new IndexMinPQ<Double>(G.V());
        
        for (int v = 0; v<G.V(); v++)
        	distTo[v] = Double.POSITIVE_INFINITY;
        dist[s]=0.0;
        
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) 
              relax(G,pq.delMin());
    }

    // relax edge e and update pq if changed
    private void relax(EdgeWeightedDigraph G,  int v) {
    	for (DirectedEdge e : G.adj(v))
    	{	
        
    		int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) 
            {
            	distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else                pq.insert(w, distTo[w]);
            }
    	}
    }
    
    public double distTo(int v) {
        return distTo[v];
    }

   
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
    
    public class DirectedEdge{
    	private final int v;
    	private final int w;
    	private final double weight;
    	
    	public DirectedEdge(int v, int w, double weight){
    		
    		this.v = v;
    		this.w = w;
    		this.weight = weight;
    		
    	}
    	
    	public double weight(){
    		return weight;
    	}
    	
    	public int from(){
    		return v;
    	}
    	
    	public int to(){
    		return w;  		
    	}
    	
    	public String toString()
    	{return String.format("%d->%d %.2f", v,w,weight);}
    	   	
    }
    
    public class EdgeWeightedDigraph
    {
    	private final int V;
    	private int E;
    	private Bag<DirectedEdge>[] adj;
    	
    	public EdgeWeightedDigraph(int V)
    	{
    		this.V = V;
    		this.E = E;
    		adj = (Bag<DirectedEdge>[]) new Bag[V];
    		for (int v = 0; v < V; v++)
    			adj[v] = new Bag<DirectedEdge>();
    	}
    	
    	public EdgeWeightedDigraph(In in)
    	{
    		public int V() {return V;}
    		public int E() {return E;}
    		
    		public void addEdge(DirectedEdge e)
    		{
    			adj[e.from()].add(e);
    			E++;
    		}
    		
    		public Iterable <DirectedEdge> adj(int v)
    		{ return adj[v];}
    		
    		public Iterable <DirectedEdge> edges()
    		{
    			Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
    			for (int v= 0; v< V; v++)
    				for (DirectedEdge e : adj[v])
    					bag.add(e);
    			return bag;
    		}
    		
    	}
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
