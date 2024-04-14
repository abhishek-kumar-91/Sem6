import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SalesDetails {

    public static void main(String[] args) {
        // Simulated list of sales details
        List<SalesRecord> salesList = new ArrayList<>();
        salesList.add(new SalesRecord(1, "Product1", 10, 20.0, getDate("2024-04-01")));
        salesList.add(new SalesRecord(2, "Product2", 5, 15.0, getDate("2024-04-03")));
        salesList.add(new SalesRecord(3, "Product3", 8, 18.0, getDate("2024-04-05")));
        salesList.add(new SalesRecord(4, "Product1", 15, 22.0, getDate("2024-04-07")));
        salesList.add(new SalesRecord(5, "Product2", 20, 16.0, getDate("2024-04-09")));

        Scanner scanner = new Scanner(System.in);
        
        // Get start date from user
        System.out.print("Enter start date (yyyy-MM-dd): ");
        String startDateStr = scanner.nextLine();
        
        // Get end date from user
        System.out.print("Enter end date (yyyy-MM-dd): ");
        String endDateStr = scanner.nextLine();

        try {
            // Convert start and end date strings to Date objects
            Date startDate = getDate(startDateStr);
            Date endDate = getDate(endDateStr);
            
            // Display sales details between selected dates
            System.out.println("Sales Details between " + startDateStr + " and " + endDateStr);
            System.out.println("PID\tPName\tQty\tRate\tAmount");
            for (SalesRecord record : salesList) {
                Date recordDate = record.getDate();
                if (recordDate.after(startDate) && recordDate.before(endDate)) {
                    System.out.println(record);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    // Utility method to parse date string
    private static Date getDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(dateString);
    }

    // Class to represent sales record
    static class SalesRecord {
        private int pid;
        private String pname;
        private int qty;
        private double rate;
        private Date date;

        public SalesRecord(int pid, String pname, int qty, double rate, Date date) {
            this.pid = pid;
            this.pname = pname;
            this.qty = qty;
            this.rate = rate;
            this.date = date;
        }

        public int getPid() {
            return pid;
        }

        public String getPname() {
            return pname;
        }

        public int getQty() {
            return qty;
        }

        public double getRate() {
            return rate;
        }

        public Date getDate() {
            return date;
        }

        public double getAmount() {
            return qty * rate;
        }

        @Override
        public String toString() {
            return pid + "\t" + pname + "\t" + qty + "\t" + rate + "\t" + getAmount();
        }
    }
}
