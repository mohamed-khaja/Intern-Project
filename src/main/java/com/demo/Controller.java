package com.demo;

import java.util.Scanner;
import com.demo.database.DBController;
import org.apache.log4j.*;

public class Controller {

    static Logger log = LogManager.getLogger(Controller.class);
    Scanner scan = new Scanner(System.in);
    Model model = new Model();
    DBController db = new DBController();

    public void add(){
        System.out.println("Enter the Phone Details:");
        System.out.println("ID:");
        model.setId(scan.nextInt());
        System.out.println("Name:");
        model.setName(scan.next());
        System.out.println("Price:");
        model.setPrice(scan.nextFloat());
        log.debug("Adding the Values to the DB");
        db.dbAdd(model);
    }

    public void view(){
        db.dbView();
    }

    public void update(){
        System.out.println("Enter the ID of the Phone: ");
        model.setId(scan.nextInt());
        System.out.println("Enter New Price: ");
        model.setPrice(scan.nextFloat());
        log.info("Updating the Price");
        db.dbUpdate(model);
    }

    public void remove(){
        System.out.println("Enter the ID of the phone to be removed: ");
        model.setId(scan.nextInt());
        log.warn("Removing an Item");;
        db.dbRemove(model);
    }
}
