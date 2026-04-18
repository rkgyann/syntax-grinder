import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
public class WaterFlowGUI extends JFrame {
private final int S = 0, C1 = 1, C2 = 2, C3 = 3, C4 = 4, C5 = 5, C6 = 6, T = 7;
private List<Edge>[] adj;
private Map<Integer, Point> nodeLocations;
private List<Edge> currentPath = new ArrayList<>();
private int totalMaxFlow = 0;
private int stepCounter = 1;
private DefaultListModel<String> traceModel;
private JList<String> traceList;
class Edge {
int from, to, capacity, flow;
public Edge(int from, int to, int capacity) {
this.from = from; this.to = to; this.capacity = capacity; this.flow = 0;
}
public int residual() { return capacity - flow; }
}
public WaterFlowGUI() {
setTitle("Water Flow Solver - Final Strict Configuration (Max Flow: 29)");
setSize(1150, 700);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLayout(new BorderLayout());
initGraph();
initLocations();
GraphPanel canvas = new GraphPanel();
add(canvas, BorderLayout.CENTER);
traceModel = new DefaultListModel<>();
traceList = new JList<>(traceModel);
traceList.setFont(new Font("Monospaced", Font.BOLD, 13));
JScrollPane scrollPane = new JScrollPane(traceList);
scrollPane.setPreferredSize(new Dimension(400, 0));
JPanel tracePanel = new JPanel(new BorderLayout());
tracePanel.setBorder(BorderFactory.createTitledBorder("Strict Trace (No Back-Edges)"));
tracePanel.add(scrollPane, BorderLayout.CENTER);
add(tracePanel, BorderLayout.EAST);
JButton stepButton = new JButton("Execute Next Step");
stepButton.setFont(new Font("Arial", Font.BOLD, 16));
stepButton.addActionListener(e -> {
if (findAndAugmentPathStrict()) {
canvas.repaint();
} else {
traceModel.addElement("--------------------------------");
traceModel.addElement("MAX FLOW REACHED: " + totalMaxFlow +
" ML/Day");
stepButton.setEnabled(false);
}
});
add(stepButton, BorderLayout.SOUTH);
}
private void initGraph() {
adj = new ArrayList[8];
for (int i = 0; i < 8; i++) adj[i] = new ArrayList<>();
// Final Corrected Edges based on Figure 1.1
addStrictPipeline(S, C1, 12);
addStrictPipeline(S, C2, 8);
addStrictPipeline(S, C4, 15);
addStrictPipeline(C1, C3, 9);
addStrictPipeline(C1, C5, 6);
addStrictPipeline(C2, C3, 7);
addStrictPipeline(C2, C5, 10);
addStrictPipeline(C2, C4, 5); // Corrected: C2 -> C4 (Downward)
addStrictPipeline(C2, C6, 5);
addStrictPipeline(C4, C6, 18);
addStrictPipeline(C3, T, 11);
addStrictPipeline(C5, T, 14);
addStrictPipeline(C6, T, 9);
}
private void addStrictPipeline(int u, int v, int cap) {
adj[u].add(new Edge(u, v, cap));
}
private void initLocations() {
nodeLocations = new HashMap<>();
nodeLocations.put(S, new Point(80, 300));
nodeLocations.put(C1, new Point(250, 100));
nodeLocations.put(C2, new Point(250, 300));
nodeLocations.put(C4, new Point(250, 500));
nodeLocations.put(C3, new Point(500, 100));
nodeLocations.put(C5, new Point(500, 300));
nodeLocations.put(C6, new Point(500, 500));
nodeLocations.put(T, new Point(750, 300));
}
private boolean findAndAugmentPathStrict() {
Edge[] parentEdge = new Edge[8];
Queue<Integer> q = new LinkedList<>();
q.add(S);
boolean[] visited = new boolean[8];
visited[S] = true;
while (!q.isEmpty()) {
int curr = q.poll();
for (Edge e : adj[curr]) {
if (!visited[e.to] && e.residual() > 0) {
visited[e.to] = true;
parentEdge[e.to] = e;
q.add(e.to);
}
}
}
if (!visited[T]) return false;
int bottleneck = Integer.MAX_VALUE;
currentPath = new ArrayList<>();
List<Integer> pathNodes = new ArrayList<>();
int temp = T;
while (temp != S) {
Edge e = parentEdge[temp];
bottleneck = Math.min(bottleneck, e.residual());
currentPath.add(e);
pathNodes.add(temp);
temp = e.from;
}
pathNodes.add(S);
Collections.reverse(pathNodes);
for (Edge e : currentPath) {
e.flow += bottleneck;
}
totalMaxFlow += bottleneck;
StringBuilder sb = new StringBuilder();
for (int i = 0; i < pathNodes.size(); i++) {
int n = pathNodes.get(i);
sb.append((n == 0) ? "S" : (n == 7) ? "T" : "C" + n);
if (i < pathNodes.size() - 1) sb.append(" -> ");
}
traceModel.addElement("Step " + stepCounter++);
traceModel.addElement(" Path: " + sb.toString());
traceModel.addElement(" Flow Added: " + bottleneck + " ML/Day");
traceModel.addElement(" Total: " + totalMaxFlow + " ML/Day");
traceModel.addElement(" ");
return true;
}
class GraphPanel extends JPanel {
@Override
protected void paintComponent(Graphics g) {
super.paintComponent(g);
Graphics2D g2 = (Graphics2D) g;
g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
RenderingHints.VALUE_ANTIALIAS_ON);
for (int i = 0; i < 8; i++) {
for (Edge e : adj[i]) {
Point p1 = nodeLocations.get(e.from);
Point p2 = nodeLocations.get(e.to);
boolean isHighlight = currentPath.contains(e);
g2.setColor(isHighlight ? Color.BLUE : new Color(180, 180, 180));
g2.setStroke(new BasicStroke(isHighlight ? 5 : 2));
g2.drawLine(p1.x, p1.y, p2.x, p2.y);
g2.setColor(Color.BLACK);
g2.setFont(new Font("Arial", Font.BOLD, 12));
int mX = (p1.x + p2.x) / 2;
int mY = (p1.y + p2.y) / 2;
if (e.from == 1 && e.to == 5) { mX -= 25; mY -= 10; }
if (e.from == 2 && e.to == 3) { mX += 10; mY += 20; }
g2.drawString(e.flow + "/" + e.capacity, mX, mY);
}
}
for (int i = 0; i < 8; i++) {
Point p = nodeLocations.get(i);
g2.setColor(new Color(255, 165, 0));
g2.fillOval(p.x - 25, p.y - 25, 50, 50);
g2.setColor(Color.BLACK);
g2.setStroke(new BasicStroke(2));
g2.drawOval(p.x - 25, p.y - 25, 50, 50);
String label = (i == S) ? "S" : (i == T) ? "T" : "C" + i;
g2.drawString(label, p.x - 10, p.y + 7);
}
}
}
public static void main(String[] args) {
SwingUtilities.invokeLater(() -> new WaterFlowGUI().setVisible(true));
}
}