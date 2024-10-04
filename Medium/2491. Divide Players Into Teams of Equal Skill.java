import java.util.Arrays;

class Counting {
    public long dividePlayers(int[] skill) {
        final var n = skill.length;
        final var skillCnt = new int[1001];
        var totalSkill = 0;
        for (int s : skill) {
            totalSkill += s;
            skillCnt[s]++;
        }
        if (totalSkill % (n / 2) > 0) {
            return -1;
        }
        final var targetTeamSkill = totalSkill / (n / 2);
        var totalChemistry = 0L;
        for (int s : skill) {
            int t = targetTeamSkill - s;
            if (skillCnt[t] == 0) {
                return -1;
            }
            totalChemistry += (long) s * t;
            skillCnt[t]--;
        }
        return totalChemistry / 2;
    }
}

class Sorting {
    public long dividePlayers(int[] skill) {
        final var n = skill.length;
        Arrays.sort(skill);
        final int equal = skill[0] + skill[n - 1];
        var res = 0L;
        for (int i = 0; i < n / 2; i++) {
            if (skill[i] + skill[n - 1 - i] != equal) {
                return -1;
            }
            res += skill[i] * skill[n - 1 - i];
        }
        return res;
    }
}