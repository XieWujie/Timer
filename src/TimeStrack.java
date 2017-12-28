import java.util.Scanner;

public class TimeStrack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //输入时间（秒）
        long num = scan.nextInt();
        //转换为北京时间
        num +=8*60*60;
        int year0 = 1970;
        int newYear = year0;
        int newMonth = 0;
        int newDay;
        int newHour;
        int newMinute;
        int newSecond;
        //定义是否为闰年
        int isR = 0;
        boolean isBreak = true;
        //得到年
        while (isBreak)
        {
           // 判断是否为闰年
            if ((newYear % 4 != 0)||((newYear%100==0)&&(newYear%400!=0))) {
                num -= 31536000;
                newYear++;
                if (num <= 31622400) {
                    isBreak = false;
                }
            }
            else{
                num -= 31622400;
                newYear++;
                if (num <= 31536000) {
                    isR = 1;
                    isBreak = false;
                }
            }
        }
        //得到天数
        newDay = (int)num/(60*60*24);
        int restNum =(int) num%(60*60*24);
        //得到小时
        newHour = (int)restNum/(60*60);
        int extraNum = (restNum)%(60*60);
        //得到分
        newMinute = (int)extraNum/(60);
        //得到秒
        newSecond = extraNum%60;
        int a = 31;
        int b = 0;
        for (int i = 1; i <= 12; i++) {
            if (newDay > b && newDay <= a) {
                //得到月
                newMonth = i;
                //得到日
                newDay-=b;
            }
            a += fun(i + 1, isR);
            b += fun(i, isR);
        }
        System.out.println(newYear + " 年 " + newMonth + " 月 " +newDay+ " 日"+newHour+":"+newMinute+":"+newSecond);
    }
/*
*判断具体月份的天数，并返回
 */
    public static int fun(int month, int isR) {
        int a = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            a += 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            a += 30;
        } else if (month == 2) {
            a = 28 + isR;
        }
        return a;
    }
}