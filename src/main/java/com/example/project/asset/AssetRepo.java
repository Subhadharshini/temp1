package com.example.project.asset;

import com.example.project.trader.Trader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepo extends CrudRepository<Asset, Long> {
    List<Asset> findAll();
    List<Asset> findAssetsByTrader(Trader t);
}