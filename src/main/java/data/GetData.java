package data;

import utils.DataFinder;

public class GetData {
    public enum Url {
        BASE_URI;

        public String getValue() {
            return DataFinder.getBaseUrl(this);
        }
    }
}
