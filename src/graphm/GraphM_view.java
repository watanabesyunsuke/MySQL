package graphm;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraphM_view extends Frame implements ActionListener,WindowListener {
	private Button button1 = new Button("BarChart");
	private Button button2 = new Button("LineChart");
	private CategoryDataset data;
	public GraphM_view(int a) {
		addWindowListener(this);
 		setTitle("Graph");
 		setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
 		add(button1);
	    add(button2);
	    button1.addActionListener(this);
	    button2.addActionListener(this);
	    
	    setLayout(new FlowLayout(FlowLayout.CENTER));
	    
	    DefaultCategoryDataset data = new DefaultCategoryDataset();
	       int ton;
	       String id,year,name;
	       ResultSet rs;
	       MySQL mysql = new MySQL();
	       rs = mysql.selectAll();
	       
	    	try {
				while(rs.next()) {
					id = rs.getString("id");
				    name = rs.getString("name");
					year = rs.getString("year");
					ton = rs.getInt("ton");
					System.out.println("ID：" + id);
				    System.out.println("name：" + name);
				    System.out.println("year：" + year);
				    System.out.println("ton：" + ton);
				    data.addValue(ton, name, year);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		
	    if(a==0) {
 			JFreeChart chart=ChartFactory.createBarChart3D("Import Volume",
                    "Year",
                    "Ton",
                    data,
                    PlotOrientation.VERTICAL,
                    true,
                    false,
                    false);
           ChartPanel cpanel = new ChartPanel(chart);
           add(cpanel,BorderLayout.CENTER);
 		}else if(a==1) {
 			 JFreeChart chart=ChartFactory.createLineChart3D("Import Volume",
                     "Year",
                     "Ton",
                     data,
                     PlotOrientation.VERTICAL,
                     true,
                     false,
                     false);
             ChartPanel cpanel = new ChartPanel(chart);
             add(cpanel,BorderLayout.CENTER);
         }
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1) {
			dispose();
			GraphM_view graph = new GraphM_view(0);
			graph.setBounds(5,5,700,600);
            graph.setVisible(true);
         } else if(e.getSource()==button2) {
        	dispose();
 			GraphM_view graph = new GraphM_view(1);
 			graph.setBounds(5,5,700,600);
            graph.setVisible(true);
            }
	}
}
