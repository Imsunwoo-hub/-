package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_나무재테크 {
	public static int N;
	public static int M;
	public static int K;
	public static int[][] stdt;
	public static int[][] eng;
	public static PriorityQueue<int[]> tree;
	public static Queue<int[]> dtree;
	public static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void age() {
		PriorityQueue<int[]> temp = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});

		while (!tree.isEmpty()) {
			int[] t = tree.poll();
			if (t[2] <= eng[t[0]][t[1]]) {
				eng[t[0]][t[1]] -= t[2];
				t[2]++;
				temp.offer(t);
			} else {
				dtree.offer(t);
			}
		}
		tree = temp;
	}

	public static void die() {
		while (!dtree.isEmpty()) {
			int[] t = dtree.poll();
			eng[t[0]][t[1]] += t[2] / 2;
		}
	}

	public static void spr() {
		PriorityQueue<int[]> temp = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		while (!tree.isEmpty()) {
			int[] t = tree.poll();
			if (t[2] % 5 == 0) {
				for (int dir = 0; dir < 8; dir++) {
					int ny = t[0] + dy[dir];
					int nx = t[1] + dx[dir];
					if (ny < 0 || ny >= N || nx < 0 || nx >= N)
						continue;
					temp.offer(new int[] { ny, nx, 1 });
				}
			}
			temp.offer(t);

		}
		tree = temp;
	}

	public static void sd() {
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				eng[n][m] += stdt[n][m];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		eng = new int[N][N];
		stdt = new int[N][N];
		tree = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});

		dtree = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				stdt[i][j] = Integer.parseInt(st.nextToken());
				eng[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			tree.offer(new int[] { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()) });
		}
		

		for (int i = 0; i < K; i++) {
			age();
			die();
			spr();
			sd();
		}
		System.out.println(tree.size());

	}
}
