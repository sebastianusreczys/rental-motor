
package com.java.web.dao;

import com.java.web.domain.Costumer;

public interface CostumerDao {
   
    boolean daftar(Costumer costumer);
    
    boolean login(Costumer costumer);
    
   
}
