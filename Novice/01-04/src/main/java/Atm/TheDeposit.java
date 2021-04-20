package Atm;

    public class TheDeposit extends ATMMachine
    {
        static double deposit;
        public void setDeposit(double d)
        {
            deposit = d;
        }
        public static double getDeposit()
        {
            return deposit;
        }
    }


