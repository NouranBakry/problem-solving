// cleaner code would have been created using a map to store the months, and using a StringBuilder

class Solution {
    public String reformatDate(String date) {
        String[] months = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
                "Dec" };

        String[] components = date.split(" ");
        String day = components[0];
        String month = components[1];
        String year = components[2];
        int monthCount = 0;
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(month)) {
                monthCount = i + 1;
            }
        }
        String monthNum = "";
        if (monthCount % 10 == monthCount) {
            monthNum = "0" + monthCount;
        } else
            monthNum += monthCount;
        String dayNum = "";
        int dayCount = Integer.parseInt(day.substring(0, day.length() - 2));
        if (dayCount % 10 == dayCount) {
            dayNum = "0" + day.substring(0, day.length() - 2);
        } else
            dayNum += day.substring(0, day.length() - 2);

        String output = year + "-" + monthNum + "-" + dayNum;
        return output;
    }
}

// using a map for fetching months 

class Solution {
    public String reformatDate(String date) {
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        String[] components = date.split(" ");
        String day = components[0];
        String month = components[1];
        String year = components[2];
        String monthNum = months.get(month);

        String dayNum = "";
        int dayCount = Integer.parseInt(day.substring(0, day.length() - 2));
        if (dayCount % 10 == dayCount) {
            dayNum = "0" + day.substring(0, day.length() - 2);
        } else
            dayNum += day.substring(0, day.length() - 2);

        String output = year + "-" + monthNum + "-" + dayNum;
        return output;
    }
}