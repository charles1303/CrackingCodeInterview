package com.career.cup;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	public HashMap<String, Vertex> vertices;
	public HashMap<Integer, Edge> edges;
	
	public Graph(){
		this.vertices = new HashMap<String, Vertex>();
		this.edges = new HashMap<Integer, Edge>();
	}
	
	public Graph(ArrayList<Vertex> vertices){
		this.vertices = new HashMap<String, Vertex>();
		this.edges = new HashMap<Integer, Edge>();
		for(Vertex v: vertices){
		      this.vertices.put(v.getLabel(), v);
		}
	}
	
	public boolean addVertex(Vertex vertex, boolean overwriteExisting){
        Vertex current = this.vertices.get(vertex.getLabel());
        if(current != null){
            if(!overwriteExisting){
                return false;
            }
            while(current.getNeighborCount() > 0){
                this.removeEdge(current.getNeighbor(0));
            }
        }
        vertices.put(vertex.getLabel(), vertex);
        return true;
    }
	
	public Edge removeEdge(Edge e){
       e.getOne().removeNeighbor(e);
       e.getTwo().removeNeighbor(e);
       return this.edges.remove(e.hashCode());
	}

	public class Edge {
		private Vertex one, two;
		int weight;
		
		public Vertex getOne(){
			return this.one;
		}
		
		public Vertex getTwo(){
			return this.two;
		}

		public Edge(Vertex one, Vertex two, int weight) {

			this.one = (one.getLabel().compareTo(two.getLabel()) <= 0) ? one
					: two;

			this.two = (this.one == one) ? two : one;

			this.weight = weight;

		}
	}

	public class Vertex {
		private ArrayList<Edge> edges;
		private String label;

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public void addNeighbor(Edge edge) {

			if (this.edges.contains(edge)) {
				return;
			}
			this.edges.add(edge);
		}

		public boolean containsNeighbor(Edge other) {

			return this.edges.contains(other);

		}
		public int getNeighborCount(){
		   return this.edges.size();
		}
		
		public Edge getNeighbor(int index){
			return this.edges.get(index);
		}
		public void removeNeighbor(Edge e){
		     this.edges.remove(e);
		}

	}

	public boolean addEdge(Vertex one, Vertex two, int weight) {
		if (one.equals(two)) {
			return false;
		}
		// ensures the Edge is not in the Graph
		Edge e = new Edge(one, two, weight);
		if (edges.containsKey(e.hashCode())) {
			return false;
		}
		// and that the Edge isn't already incident to one of the vertices
		else if (one.containsNeighbor(e) || two.containsNeighbor(e)) {
			return false;
		}

		edges.put(e.hashCode(), e);
		one.addNeighbor(e);
		two.addNeighbor(e);
		return true;

	}

}
