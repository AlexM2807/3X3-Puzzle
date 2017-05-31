import java.util.List;







public class Node {

	
	List<Integer> stare;
	Node parinte;
	String actiune;
	int cost;
	int distance ;
	private Process process;



	public int getDistance()
	{
		return distance;
	}

	public void setDistance(int distance)
	{
		this.distance = distance;
	}

	public List<Integer> getStare()
	{
		return stare;
	}

	public void setStare(List<Integer> stare)
	{
		this.stare = stare;
	}

	

	

	
	@Override
	public String toString()
	{
		return "Node [stare=" + stare + "]";
	}

	

	public Node getParinte()
	{
		return parinte;
	}

	public void setParinte(Node parinte)
	{
		this.parinte = parinte;
	}

	public String getActiune() {
		return actiune;
	}

	public void setActiune(String actiune) {
		this.actiune = actiune;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Node(List<Integer> stare, Node parinte, String actiune, int cost, int distance) {
		
		this.stare = stare;
		this.parinte = parinte;
		this.actiune = actiune;
		this.cost = cost;
		this.distance = distance + cost;
	}


	public Node()
	{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
	
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stare == null) ? 0 : stare.hashCode());
		return result;
	}



@Override
public boolean equals(Object obj) {
	// System.out.println("Node Equals");
	Node other = (Node) obj;
	return getStare().hashCode() == other.getStare().hashCode();
}





	
	
	


	 
}


