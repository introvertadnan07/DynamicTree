import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class DynamicTreeExample {
    public static void main(String[] args) {
        // Set Look and Feel for better UI (Optional)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        // Creating the frame
        JFrame frame = new JFrame("Java JTree Example");

        // Creating the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        // Creating first parent node with children
        DefaultMutableTreeNode parent1 = new DefaultMutableTreeNode("Parent 1");
        parent1.add(new DefaultMutableTreeNode("Child 1.1"));
        parent1.add(new DefaultMutableTreeNode("Child 1.2"));

        // Creating second parent node with children
        DefaultMutableTreeNode parent2 = new DefaultMutableTreeNode("Parent 2");
        parent2.add(new DefaultMutableTreeNode("Child 2.1"));
        parent2.add(new DefaultMutableTreeNode("Child 2.2"));

        // Adding parents to root
        root.add(parent1);
        root.add(parent2);

        // Creating the JTree
        JTree tree = new JTree(root);

        // Expand all nodes by default
        expandAllNodes(tree, 0, tree.getRowCount());

        // Adding tree to frame
        frame.add(new JScrollPane(tree));

        // Setting frame properties
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Center window
        frame.setVisible(true);
    }

    // Function to expand all nodes in the JTree
    private static void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; i++) {
            tree.expandRow(i);
        }
        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }
}
