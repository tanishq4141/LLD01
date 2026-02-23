public class TaxCalculator {

  String customerType;
  double subtotal;

  public TaxCalculator(String customerType,double subtotal){
    this.customerType=customerType;
    this.subtotal=subtotal;

  }

  public double calculate(){
    double taxPct = TaxRules.taxPercent(customerType);
    double tax = subtotal * (taxPct / 100.0);
    return tax;

  }

   

   
  
}
