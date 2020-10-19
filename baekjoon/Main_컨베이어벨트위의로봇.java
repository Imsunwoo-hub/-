package beakjoon;

import java.util.Scanner;

public class Main_컨베이어벨트위의로봇 {
	static int N, M;
	static int[][] info;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		info = new int[2 * N][2]; // 유무|내구도
		for (int i = 0; i < 2 * N; i++) {
			info[i][1] = sc.nextInt();
		}

		int ans = solve();
		System.out.println(ans);
	}

	private static int solve() {
		int time = 0;
		int cnt = 0;
		int len = N << 1;
		while (cnt < M) {
			time++;
			int start = 0;
			for (; start < len; start++) {
				if ((start + time) % len == 0) {
					break;
				}
			}

			for (int i = start + N - 1, pos = N - 1; i >= start; i--, pos--) {
				int now = i % len;
				int next = now + 1 == len ? 0 : now + 1;
				if (pos == 0) {
					if (info[now][1] > 0) {
						info[now][0] = 1;
						info[now][1]--;
						if (info[now][1] == 0)
							cnt++;
					}
				} else if (0 < pos && pos < N - 1) {
					if (info[now][0] == 1 && info[next][0] == 0 && info[next][1] != 0) {
						info[now][0] = 0;
						info[next][0] = 1;
						info[next][1]--;
						if (info[next][1] == 0)
							cnt++;
						if (pos + 1 == N - 1) {
							info[next][0] = 0;
						}
					}
				} else if (pos == N - 1) {
					info[now][0] = 0;
				}
			}
		}
		return time;
	}
}