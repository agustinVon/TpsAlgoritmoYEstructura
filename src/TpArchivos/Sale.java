package TpArchivos;

public class Sale {
    String destinyCode; //3 Chars
    String articleCode; //4 Chars
    int cuantity;
    double priceInDolars;
    Date dateOfSale;

    public Sale(String destinyCode, String articleCode, int cuantity, double priceInDolars, Date dateOfSale) {
        if(destinyCode.length()>3){
            throw new RuntimeException("Code too big");
        }
        for (int i = destinyCode.length(); i < 3; i++) {
            destinyCode=destinyCode+" ";
        }
        this.destinyCode = destinyCode;

        if(articleCode.length()>4){
            throw new RuntimeException("Code too big");
        }
        for (int i = articleCode.length(); i < 4; i++) {
            articleCode=articleCode+" ";
        }
        this.articleCode = articleCode;

        this.cuantity = cuantity;
        this.priceInDolars = priceInDolars;
        this.dateOfSale = dateOfSale;
    }

    public String getDestinyCode() {
        return destinyCode;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public int getCuantity() {
        return cuantity;
    }

    public double getPriceInDolars() {
        return priceInDolars;
    }

    public int getDay(){
        return dateOfSale.getDay();
    }

    public int getMonth(){
        return dateOfSale.getMonth();
    }


}
