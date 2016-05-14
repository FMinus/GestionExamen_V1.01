/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.IDAO;

import Entities.UserEntity;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.*;

/**
 *
 * @author AbdelMajid
 */
public interface IDAO<T> extends DAO<T,ObjectId>{
    public T getByName(String champ ,String name);
    public List<T> getList();
    public List<T> getXSupA(float note);
    public void deleteBy(String champ,String name);
    public void updateXby(String champ,String name);
    public void addX(T t);
    
    
    
    
}
