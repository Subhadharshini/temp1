package com.example.project;

import com.example.project.asset.Asset;
import com.example.project.asset.AssetRepo;
import com.example.project.bonds.Bond;
import com.example.project.bonds.BondRepo;
import com.example.project.broker.Broker;
import com.example.project.broker.BrokerRepo;
import com.example.project.property.Property;
import com.example.project.property.PropertyRepo;
import com.example.project.share.Share;
import com.example.project.share.ShareRepo;
import com.example.project.stock.Stock;
import com.example.project.stock.StockRepo;
import com.example.project.trader.Trader;
import com.example.project.trader.TraderRepo;
import com.example.project.transaction.Transaction;
import com.example.project.transaction.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
public class Controller {

    @Autowired
    private TraderRepo traderRepo;
    @Autowired
    private ShareRepo shareRepo;
    @Autowired
    private TransactionRepo transactionRepo;
    @Autowired
    private BrokerRepo brokerRepo;
    @Autowired
    private AssetRepo assetRepo;
    @Autowired
    private BondRepo bondRepo;
    @Autowired
    private PropertyRepo propertyRepo;
    @Autowired
    private StockRepo stockRepo;

    // --------------------------------------TRADER-------------------------------------
    // Get all traders
    @GetMapping("getTraders")
    public List<Trader> getTraders(){
        return traderRepo.findAll();
    }

    // Get trader by id
    @GetMapping("getTraderByID")
    public Optional<Trader> getTraderById(@RequestParam long id){
        return traderRepo.findById(id);
    }

    // create or post trader
    @PostMapping("addTrader")
    public void addTrader(@RequestBody Trader t){
        traderRepo.save(t);
    }

    //edit details of a trader
    @PostMapping("editTrader")
    public void editTrader(@RequestBody Trader t){
       Optional<Trader> t1 = traderRepo.findById(t.getId());

        if(t1.isPresent()) {
            Trader t2 = t1.get();
            t2.setName(t.getName());
            t2.setAccountno(t.getAccountno());
            t2.setBalance(t.getBalance());
            traderRepo.save(t2);
        }
        else
        {
            //trader not present
        }
    }

    // delete trader by id
    @GetMapping("deleteTrader")
    public void deleteTraderByID(@RequestParam long id){
        traderRepo.deleteById(id);
    }

    // --------------------------------------SHARES-------------------------------------
    // Get all shares
    @GetMapping("getShares")
    public List<Share> getShares(){
        return shareRepo.findAll();
    }

    // Get share by id
    @GetMapping("getShareById")
    public Optional<Share> getShareById(@RequestParam long id){
        return shareRepo.findById(id);
    }

    // create or post share
    @PostMapping("addShare")
    public void addShare(@RequestBody Share s){
        shareRepo.save(s);
    }

    //edit details of a share
    @PostMapping("editShare")
    public void editShare(@RequestBody Share t){
        Optional<Share> t1 = shareRepo.findById(t.getId());

        if(t1.isPresent()) {
            Share t2 = t1.get();
            t2.setCompanyName(t.getCompanyName());
            t2.setCompanyCode(t.getCompanyCode());
            t2.setUnitCost(t.getUnitCost());
            t2.setHighestPrice(t.getHighestPrice());
            t2.setLowestPrice(t.getLowestPrice());
            shareRepo.save(t2);
        }
        else
        {
            //share not present
        }
    }

    // delete share by id
    @GetMapping("deleteShare")
    public void deleteShareById(@RequestParam long id){
        shareRepo.deleteById(id);
    }

    // --------------------------------------TRANSACTIONS-------------------------------------
    // Get all transactions
    @GetMapping("getTransactions")
    public List<Transaction> getTransactions(){
        return transactionRepo.findAll();
    }

    // Get Transaction by id
    @GetMapping("getTransactionById")
    public Optional<Transaction> getTransactionById(@RequestParam long id){
        return transactionRepo.findById(id);
    }

    // create or post Transaction
    @PostMapping("addTransaction")
    public void addTransaction(@RequestBody Transaction s){
        Trader t = s.getTrader();
        Share sh = s.getShare();

        double price = s.getPrice();

        if((s.getBuyOrSell()).equals("buy")) //Amount deducted for buying
        {
            if(t.getBalance() < price) {
                System.out.println("Insufficient Balance");
                return;
            }
            else
                t.setBalance(t.getBalance() - price);
        }
        else
            t.setBalance(t.getBalance() + price); //Amount added for selling

        traderRepo.save(t);
        shareRepo.save(sh);
        transactionRepo.save(s);
    }

    // Get all transactions in a given date
    @GetMapping("getTransactionsByDate")
    public List<Transaction> getTransactionsByDate(@RequestParam String date){
        return transactionRepo.findTransactionsByDateEquals(date);
    }

    // Get all transactions by a trader
    @GetMapping("getTransactionsByTraderId")
    public List<Transaction> getTransactionsByTraderId(@RequestParam long id){
        Optional<Trader> t = traderRepo.findById(id);
        if(t.isPresent()) {
            Trader t1 = t.get();
            return transactionRepo.findTransactionsByTrader(t1);
        }
        else
            return null;
    }

    // delete Transaction by id
    @GetMapping("deleteTransaction")
    public void deleteTransactionById(@RequestParam long id){
        transactionRepo.deleteById(id);
    }

    // --------------------------------------BROKERS-------------------------------------
    //add Broker
    @PostMapping("addBroker")
    public void addBroker(@RequestBody Broker b){
        brokerRepo.save(b);
    }

    //view all Brokers
    @GetMapping("getBrokers")
    public List<Broker> getBrokers()
    {
        return brokerRepo.findAll();
    }

    @PostMapping("changeBrokerAccountDetails")
    public void changeBrokerAccountDetails(@RequestBody Broker b){
        Optional<Broker> broker1 = brokerRepo.findById(b.getId());
        if(broker1.isPresent())
        {
            Broker b1 = broker1.get();
            b1.setBroker_name(b.getBroker_name());
            b1.setAccount_no(b.getAccount_no());
            brokerRepo.save(b1);
        }
    }

    @GetMapping("deleteBrokerById")
    public void deleteBrokerById(@RequestParam long id){
        brokerRepo.deleteById(id);
    }

    // --------------------------------------ASSETS-------------------------------------
    //Add Asset
    @PostMapping("addAsset")
    public void addAsset(@RequestBody Asset asset)
    {
        assetRepo.save(asset);
    }

    //view all Assets
    @GetMapping("getAssets")
    public List<Asset> getAssets(){
        return assetRepo.findAll();
    }
    //view all assets based on trader ID
    @GetMapping("assets")
    public List<Asset> fetchAssets(@RequestParam long id){
        Optional<Trader> t = traderRepo.findById(id);
        if(t.isPresent())
        {
            Trader t1 = t.get();
            return assetRepo.findAssetsByTrader(t1);
        }
        return null;
    }


    // --------------------------------------STOCKS-------------------------------------
    // --------------------------------------BONDS-------------------------------------
    //add bond
    @PostMapping("addBond")
    public void addBond(@RequestBody Bond bond){
        bondRepo.save(bond);
    }

    //view bonds
    @GetMapping("getBonds")
    public List<Bond> getBonds(){
        return bondRepo.findAll();
    }
    //Calculate profit gained
    @GetMapping("profitGained")
    public double profitGained(@RequestBody Bond bond) throws ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(bond.getDoi());
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse("11/08/2022");
        //Date dateBefore = bond.getDate_of_issue();
        //Date today = new Date(2022, Calendar.AUGUST, 11);

        long d1 = date1.getTime();
        long d2 = date2.getTime();

        long timeDiff = Math.abs(d2- d1);

        double monthsDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS)/30.0;
        double profit = monthsDiff*bond.getPrinciple()*bond.getInterest_rate();

        return profit;
    }

    //calculate total profit
    @GetMapping("totalProfit")
    public double totalProfit(@RequestBody Bond bond) throws ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(bond.getMaturity_date());
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(bond.getDoi());
        //Date dateBefore = bond.getDate_of_issue();
        //Date today = new Date(2022, Calendar.AUGUST, 11);

        long d1 = date1.getTime();
        long d2 = date2.getTime();

        long timeDiff = Math.abs(d2 - d1);

        double monthsDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS)/30.0;
        double total_profit = monthsDiff*bond.getPrinciple()*bond.getInterest_rate();

        return total_profit;
    }


    // --------------------------------------PROPERTIES-------------------------------------

    //add a Property
    @PostMapping("addProp")
    public void addProperty(@RequestBody Property property){
        propertyRepo.save(property);
    }

    //view all properties
    @GetMapping("getProperties")
    public List<Property> getProperties()
    {
        return propertyRepo.findAll();
    }

    //check if we are at profit or loss
    @GetMapping("checkProfit/{id}")
    public String checkProfit(@PathVariable long id){
        Property p1 = propertyRepo.findByid(id);
        long val1 = p1.getBuying_price();
        long val2 = p1.getCurrent_value();
        if(val1<=val2)
        {
            double profit_percent = (val2-val1)*100.0;
            return "Profit! "+profit_percent/val1+" %";

        }
        else
        {
            double loss_percent = (val1-val2)*100.0;
            return "Loss! "+loss_percent/val1+" %";
        }

    }


}