
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

class ShipDetails{
	private String ship_id;
	private String start_city;
	private String end_city;
	private int day_of_week;
	private int status;
	ShipDetails(String ship,String start_city,String end_city,String day_of_week){
		this.ship_id=ship;
		this.start_city=start_city;
		this.end_city=end_city;
		this.day_of_week=0;
		if(day_of_week=="m")
			this.day_of_week=1;
		if(day_of_week=="t")
			this.day_of_week=2;
		if(day_of_week=="w")
			this.day_of_week=3;
		if(day_of_week=="r")
			this.day_of_week=4;
		if(day_of_week=="f")
			this.day_of_week=5;
		status=0;
	}
	public String getShip_id() {
		return ship_id;
	}
	public String getStart_city() {
		return start_city;
	}
	public String getEnd_city() {
		return end_city;
	}
	public int getDay_of_week() {
		return day_of_week;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	
}
public class ShimpmentBundleProblem5 {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader reader;
		try {
			LinkedList<ShipDetails> al=new LinkedList<ShipDetails>();  
			HashMap<Integer, LinkedList> map = new HashMap<>(); 
			reader = new BufferedReader(new FileReader(
					"shipmentFile.txt"));
			String line = reader.readLine();
			while (line != null) {
				//System.out.println(line);
				String[] ship = line.split(" ");
				ShipDetails s= new ShipDetails(ship[0],ship[1],ship[2],ship[3]);
				if(!map.containsKey(s.getDay_of_week())){
					al.add(s);
					map.put(s.getDay_of_week(), al);
				} else {
					map.get(s.getDay_of_week()).add(s);
				}
				line = reader.readLine();
			}
			findBundles(map);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void findBundles(HashMap<Integer, LinkedList> map) {
		// TODO Auto-generated method stub
		LinkedList<ShipDetails> q =new LinkedList<>();
		//add all ship details of specific day
		for(int i=1;i<=map.size();i++){
			q.addAll(map.get(i));
		}
		
		while(true) 
        {
			int nodeCount = q.size(); 
            if(nodeCount == 0) 
                break;
            while(nodeCount > 0) 
            { 
            	
            	ShipDetails sd = q.peek();
            	if(sd.getStatus() == 1){
            		q.remove();
            		break;
            	}
            	sd.setStatus(1);
            	System.out.print(sd.getShip_id()+" ");
            	for(int i=1;i<q.size();i++){
            		if(q.get(i).getDay_of_week()-sd.getDay_of_week()>2){
            			break;
            		}
            		if(sd.getStart_city() == q.get(i).getEnd_city()) {
            			q.get(i).setStatus(1);
            			System.out.print(q.get(i).getShip_id()+" ");
            		}
            	}
                nodeCount--; 
            }
            System.out.println();
        }
	}

}
