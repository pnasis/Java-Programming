import java.awt.Dimension;
import javax.swing.*;
import java.util.*;
import org.apache.commons.collections15.Transformer;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;


public class SuspectsNetwork extends JFrame{

	//Creating Items.
	Graph<String, String> g = new SparseMultigraph<String, String>();
	JPanel panel = new JPanel();
	JTextArea diameterArea = new JTextArea();
	
	public SuspectsNetwork(Registry reg)
	{		
		/*----------Creating the Vertices of the Graph.----------*/
		for(Suspect s: reg.getSuspects())
		{
			g.addVertex(s.getCodeName());
		}
		
		/*----------Setting up the labels of the Vertices.----------*/
		VisualizationViewer<String, String> vs = new VisualizationViewer<String, String>(new CircleLayout<String, String>(g), new Dimension(300,360));
	    Transformer<String, String> transformer = new Transformer<String, String>()
	    {
	        @Override
	        public String transform(String arg0)
	        {
	        	return arg0;
        	}
	    };
        vs.getRenderContext().setVertexLabelTransformer(transformer);
        vs.getRenderContext().setEdgeLabelTransformer(transformer);
        
        /*----------Creating the Edges of the Graph.----------*/
        int count=0;
        ArrayList<Suspect> alreadyChecked = new ArrayList<>();
        for(Suspect s1: reg.getSuspects())
        {
        	for(Suspect s2: reg.getSuspects())
        	{
        		if(s2.isConnectedTo(s1) && !alreadyChecked.contains(s2))
        		{
        			g.addEdge(Integer.toString(count), s1.getCodeName(), s2.getCodeName());
        			count++;
        		}
        	}
        	alreadyChecked.add(s1);
        }
        
        /*----------Calculating the Diameter of the Graph.----------*/
        DijkstraShortestPath<String, String> path = new DijkstraShortestPath<String, String>(g);
        double distance = 0;

        for(String s1: g.getVertices())
        {
        	for(String s2: g.getVertices())
        	{
        		if(!s1.equals(s2)) //If it's not the same Vertex, calculate the distance between these two vertices.
        		{
        			double temp = (double) path.getDistance(s1, s2);
        			if(temp > distance)
        			{
        				distance = temp;
        			}
        		}
        	}
        }
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        diameterArea.setPreferredSize(new Dimension(400,20));
        diameterArea.append("Diameter = " + (double) distance);        
        
        //Adding items to the panel.
        panel.add(vs);
        panel.add(diameterArea);
		
        //About Panel.
        this.setContentPane(panel);
        this.setSize(400,500);
        this.setTitle("Suspects Network");
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);   
	}
}
