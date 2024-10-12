import java.util.*;
import java.io.*;

public class CodeTree_4 {
	static ArrayList<Node> root = new ArrayList<>();
	static HashMap<Integer, Node> nodes = new HashMap<>();
	static int score = 0;
	
	static class Node {
		// 노드 번호, 부모 노드 번호, 색깔, 최대 깊이, 현재 깊이
		int mId, color, maxDepth;
		Node parent = null;
		ArrayList<Node> children = new ArrayList<>();
		
		Node(int mId, int color, int maxDepth) {
			this.mId = mId;
			this.color = color;
			this.maxDepth = maxDepth;
		}
		
		void setParent(Node parent) {
			this.parent = parent;
		}
		
		void setColor(int color) {
			this.color = color;
		}
		
		void addChild(Node child) {
			this.children.add(child);
		}
		
		ArrayList<Node> getChildren() {
			return this.children;
		}
	}
	
	// 1. 노드 추가
	public static void addNode(Node node, int pId) {
		// 1-1. 루트노드라면, root와 nodes에 노드 추가
		if(pId == -1) {
			root.add(node);
			nodes.put(node.mId, node);
			return;
		}
		
		// 1-2. 부모 노드가 있다면, maxDepth를 넘어서지 않는지 체크 후 추가
		if(checkDepth(nodes.get(pId), 2)) {
			node.setParent(nodes.get(pId));
			node.parent.addChild(node);
			nodes.put(node.mId, node);
		}
	}
	
	// 1-2-1. maxDepth 넘어서지 않는지 체크
	public static boolean checkDepth(Node node, int depth) {
		// 1) 루트 노드이면, 본인 maxDepth와 비교
		if(node.parent == null) {
			if(node.maxDepth < depth) return false;
			else return true;
		}
		
		// 2) 부모 노드가 있다면, 부모 노드 체크
		boolean isPossible = checkDepth(node.parent, depth+1);
		
		// 부모 노드의 maxDepth를 넘어서거나, 현재 노드의 maxDepth를 넘어서면 false
		if(!isPossible || node.maxDepth < depth) return false;
		return true;
	}
	
	// 2. 색 변경
	public static void changeColor(int mId, int color) {
		// 2-1. 현재 노드의 색 변경
		Node node = nodes.get(mId);
		node.setColor(color);
		
		// 2-2. 자식 노드가 있다면, 자식 노드의 색도 변경
		changeChildColor(node, color);
	}
	
	// 2-2-1. 자식 노드 순회하면서 색깔 변경
	public static void changeChildColor(Node node, int color) {
		for(Node child : node.getChildren()) {
			child.setColor(color);
			
			changeChildColor(child, color);
		}
	}
	
	// 3. 색 조회
	public static int getColor(int mId) {
		return nodes.get(mId).color;
	}
	
	// 4. 점수 조회
	public static int getScore() {
		score = 0; // 점수
		
		// 4-1. 모든 노드의 가치를 구하고, 가치의 제곱값을 점수에 더하기
		for(Node rootNode : root) {
			getSubtreeColor(rootNode);
		}
		
		return score;
	}
	
	// 5. 서브 트리 내 모든 노드의 색깔 조회
	public static Set<Integer> getSubtreeColor(Node node) {
		Set<Integer> colorSet = new HashSet<>();
		
		// 5-1. 현재 노드의 색깔 추가
		colorSet.add(node.color);
		
		// 5-2. 자식 노드가 있다면, 자식 노드의 색깔도 추가
		for(Node child : node.getChildren()) {
			colorSet.addAll(getSubtreeColor((child)));
		}
		
		score += (int)Math.pow(colorSet.size(), 2);
		
		return colorSet;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int q = Integer.parseInt(br.readLine()); // 명령 횟수
		
		while(q-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int command = Integer.parseInt(st.nextToken()); // 명령어
			int mId, pId, color, maxDepth;
			
			switch(command) {
			// 1. 노드 추가
			case 100:
				mId = Integer.parseInt(st.nextToken());
				pId = Integer.parseInt(st.nextToken());
				color = Integer.parseInt(st.nextToken());
				maxDepth = Integer.parseInt(st.nextToken());
				
				addNode(new Node(mId, color, maxDepth), pId);
				break;
				
			// 2. 색 변경
			case 200:
				mId = Integer.parseInt(st.nextToken());
				color = Integer.parseInt(st.nextToken());
				
				changeColor(mId, color);
				break;
				
			// 3. 색 조회
			case 300:
				mId = Integer.parseInt(st.nextToken());
				
				System.out.println(getColor(mId));
				break;
				
			// 4. 점수 조회
			default:
				System.out.println(getScore());
			}
		}
	}
}
