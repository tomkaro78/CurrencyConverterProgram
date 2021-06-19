public class CoinFactory {

    //will generate new coin object
    public static Coin getCoinInstance(Coins coin) {
        switch (coin) {
            case ILS:
                return new ILS();

            case USD:
                return new USD();

            case EUR:
                return new EUR();

        }
        return null;
    }

}
