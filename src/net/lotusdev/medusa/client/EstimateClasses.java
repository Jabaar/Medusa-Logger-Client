package net.lotusdev.medusa.client;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

public class EstimateClasses extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstimateClasses frame = new EstimateClasses();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EstimateClasses() {
		setTitle("Estimated Classes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EstimateClasses.class.getResource("/net/lotusdev/medusa/client/res/JavaClass.gif")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Builder.getEstimateClasses();
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
		);
		
		JTree tree = new JTree();
		tree.setShowsRootHandles(true);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Classes") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("colors");
						node_1.add(new DefaultMutableTreeNode("blue"));
						node_1.add(new DefaultMutableTreeNode("violet"));
						node_1.add(new DefaultMutableTreeNode("red"));
						node_1.add(new DefaultMutableTreeNode("yellow"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("sports");
						node_1.add(new DefaultMutableTreeNode("basketball"));
						node_1.add(new DefaultMutableTreeNode("soccer"));
						node_1.add(new DefaultMutableTreeNode("football"));
						node_1.add(new DefaultMutableTreeNode("hockey"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("food");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_1.add(new DefaultMutableTreeNode("bananas"));
					add(node_1);
				}
			}
		));
		scrollPane.setViewportView(tree);
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		
		root.removeAllChildren(); //this removes all nodes
	    model.reload();
	    
	    ImageIcon leafIcon = new ImageIcon("src/net/lotusdev/medusa/client/res/JavaClass.gif");
	    DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
	    renderer.setLeafIcon(leafIcon);
	    tree.setCellRenderer(renderer);
		
		for(int i = 0; i < Builder.getClasses.size(); i++) {
			model.insertNodeInto(new DefaultMutableTreeNode(Builder.getClasses.get(i)), root, root.getChildCount());
		}
		contentPane.setLayout(gl_contentPane);
	}
}
