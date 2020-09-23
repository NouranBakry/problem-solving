class Solution {
    public double average(int[] salary) {
        int min = salary[0];
        int max = salary[0];
        int totalSalary = 0;
        double avgSalary = 0;
        // finding min and max
        for (int i = 0; i < salary.length; i++) {
            if (salary[i] <= min) {
                min = salary[i];
            }
            if (salary[i] >= max) {
                max = salary[i];
            }
        }
        for (int i = 0; i < salary.length; i++) {
            if (salary[i] != min && salary[i] != max) {
                totalSalary += salary[i];
            }
        }

        avgSalary = totalSalary / (double) (salary.length - 2);

        return avgSalary;
    }
}